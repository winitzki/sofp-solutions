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

def flatten[A](xxs: Seq[Seq[A]]): Seq[A] = { 
  var init: Seq[A] = Seq()
  xxs.foldLeft(init){ (x, y) => y.foreach( k => (init = init :+ k)); init}
}

val result = flatten(Seq(Seq(1, 2, 3), Seq(), Seq(4)))
val expected: Seq[Int] = List(1, 2, 3, 4)
assert(result == expected)

val a = flatten(Seq(Seq("a","b"), Seq(), (Seq("c","<nothing>"))))
val b: Seq[String] = List("a", "b", "c", "<nothing>")
assert(a == b)

// scala> :load solution2.2.6.2.scala
// :load solution2.2.6.2.scala
// def flatten[A](xxs: Seq[Seq[A]]): Seq[A]
// val result: Seq[Int] = List(1, 2, 3, 4)
// val expected: Seq[Int] = List(1, 2, 3, 4)
// val a: Seq[String] = List(a, b, c, <nothing>)
// val b: Seq[String] = List(a, b, c, <nothing>)
