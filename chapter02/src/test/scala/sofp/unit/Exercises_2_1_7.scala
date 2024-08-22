package sofp.unit

import com.eed3si9n.expecty.Expecty.expect
import munit.FunSuite

class Exercises_2_1_7 extends FunSuite {

  val _ = if 1 == 1 then 0 else 1

  test("Exercise 2.1.7.1") {

    val allPairs      =
      (0 to 9).flatMap { i =>
        (0 to 9).map { j =>
          (i, j)
        }
      }
    val filteredPairs = allPairs.filter { case (i, j) => i + 4 * j > i * j }

    expect(filteredPairs.take(4) == Seq((0, 1), (0, 2), (0, 3), (0, 4)))
    expect(filteredPairs.length == 64)
  }

  test("Exercise 2.1.7.3 solved by Andreas Röhler") {
    val names: List[String]        = List("Joe", "Bob", "Mary")
    val a: List[Boolean]           = List(true, false, true)
    val b: List[(String, Boolean)] = names.zip(a)
    val c: List[Any]               = b.map { case (x, y) => if (y == true) x else () }
    val d: List[Any]               = c.filter(_ != (()))
    expect(d == List("Joe", "Mary"))
  }

  test("Exercise 2.1.7.3") {
    val names: List[String]        = List("Joe", "Bob", "Mary")
    val a: List[Boolean]           = List(true, false, true)
    val b: List[(String, Boolean)] = names.zip(a)
    val c: List[(String, Boolean)] = b.filter { case (x, y) => y }
    val d: List[String]            = c.map { case (x, y) => x }
    expect(d == List("Joe", "Mary"))
  }

  test("Exercise 2.1.7.3 as function") {
    def selectTrue(names: List[String], flags: List[Boolean]): List[String] =
      names.zip(flags).filter { case (name, flag) => flag }.map { case (name, flag) => name }

    def selectTrueShorter(names: List[String], flags: List[Boolean]): List[String] =
      names.zip(flags).filter(_._2).map(_._1)

    def selectTrueOperatorSyntax(names: List[String], flags: List[Boolean]): List[String] =
      names zip flags filter (_._2) map (_._1)

    val names    = List("Joe", "Bob", "Mary")
    val flags    = List(true, false, true)
    val expected = List("Joe", "Mary")

    expect(selectTrue(names, flags) == expected)
    expect(selectTrueShorter(names, flags) == expected)
    expect(selectTrueOperatorSyntax(names, flags) == expected)

    // If all flags are true, the initial list remains unchanged.
    val allTrue = List(true, true, true)
    expect(selectTrue(names, allTrue) == names)
    expect(selectTrueShorter(names, allTrue) == names)
    expect(selectTrueOperatorSyntax(names, allTrue) == names)

    // If all flags are false, the result is an empty list.
    val allFalse = List(false, false, false)
    expect(selectTrue(names, allFalse) == List())
    expect(selectTrueShorter(names, allFalse) == List())
    expect(selectTrueOperatorSyntax(names, allFalse) == List())
  }
}
