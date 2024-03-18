/**
  Exercise 2.2.6.1

  Implement a function fromPairs that performs the inverse
  transformation to the toPairs function defined in Example 2.2.5.6.

  The required type signature and a sample test are:

  def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = ???

  scala> fromPairs(List((1,2), (3,4)))
  res1: Seq[Int] = List(1, 2, 3, 4)

  scala> fromPairs(List((a,b), (c,<nothing>)))
  res1: Seq[(String, String)] = List("a", "b", "c", "<nothing>")

  Hint: This can be done with foldLeft or with flatMap.
  */

object FromPairs {
  def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = {
    xs.flatMap { x => x.toList }
  }
  def main(args: Array[String]) = {
    val result: Seq[String] = fromPairs(List(("a","b"), ("c","<nothing>")))
    val expected: Seq[String] = List("a", "b", "c", "<nothing>")
      println("result: %s".format(result))
    assert(result == expected)
    val a: Seq[Int] = fromPairs(List((1, 2), (3, 4)))
    val b: Seq[Int] = List(1, 2, 3, 4)
      println("a: %s".format(a))
    assert(a == b)
  }
}

FromPairs.main(Array())

// scala> :load solution2.2.6.1_flatMap.scala
// :load solution2.2.6.1_flatMap.scala
// result: List(a, b, c, <nothing>)
// a: List(1, 2, 3, 4)
// // defined object FromPairs

