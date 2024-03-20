/** 
  Exercise 2.2.6.2
  Implement the flatten method for sequences by using foldLeft.

  The required type signature and a sample test are:

  def flatten[A](xxs: Seq[Seq[A]]): Seq[A] = ???

  scala> flatten(Seq(Seq(1, 2, 3), Seq(), Seq(4)))
  res0: Seq[Int] = List(1, 2, 3, 4)

  scala> flatten(Seq(Seq("a","b"), Seq(), (Seq("c","<nothing>"))))
  val res1: Seq[String] = List(a, b, c, <nothing>)
  */

object Flatten {
  def flatten[A](xxs: Seq[Seq[A]]): Seq[A] = {
    var init: Seq[A] = Seq()
      xxs.foldLeft(init){ (x, y) => y.foreach( k => (init = init :+ k)); init}
  }
  def main(args: Array[String]): Unit = {

    val result = flatten(Seq(Seq(1, 2, 3), Seq(), Seq(4)))
    val expected: Seq[Int] = List(1, 2, 3, 4)
    println("result: %s".format(result))
    println("expected: %s".format(expected))
    assert(result == expected)

    val a = flatten(Seq(Seq("a","b"), Seq(), (Seq("c","<nothing>"))))
    val b: Seq[String] = List("a", "b", "c", "<nothing>")
    println("a: %s".format(a))
    println("b: %s".format(b))

    assert(a == b)
  }
}

Flatten.main(Array())

// scala> :load solution2.2.6.2_main.scala
// :load solution2.2.6.2_main.scala
// result: List(1, 2, 3, 4)
// expected: List(1, 2, 3, 4)
// a: List(a, b, c, <nothing>)
// b: List(a, b, c, <nothing>)
// // defined object Flatten
