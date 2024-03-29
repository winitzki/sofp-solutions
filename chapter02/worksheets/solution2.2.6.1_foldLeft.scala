/**
  Exercise 2.2.6.1

  Implement a function fromPairs that performs the inverse
  transformation to the toPairs function defined in Example 2.2.5.6.

  The required type signature and a sample test are:

  def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = ???

  scala> fromPairs(List((1,2), (3,4)))
  res0: Seq[Int] = List(1, 2, 3, 4)

  scala> fromPairs(List(("a","b"), ("c",<nothing>)))
  res1: Seq[String] = List(a, b, c, <nothing>)

  Hint: This can be done with foldLeft or with flatMap.
  */

object FromPairs {
  def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = {
    // Type alias, for brevity.
    type Acc = (Seq[A])
    def init: Acc = Seq()
    xs.foldLeft(init){ (x, y) => x :+ y._1 :+ y._2 }
  }
    def main(args: Array[String]) = {
      val result: Seq[String] = fromPairs(List(("a","b"), ("c","<nothing>")))
      val expected: Seq[String] = List("a", "b", "c", "<nothing>")
      val a: Seq[Int] = fromPairs(List((1, 2), (3, 4)))
      val b: Seq[Int] = List(1, 2, 3, 4)
      println("result: %s".format(result))
        assert(result == expected)
      println("a: %s".format(a))
        assert(a == b)
    }
}

FromPairs.main(Array())

// scala> :load solution2.2.6.1_foldLeft.scala
// :load solution2.2.6.1_foldLeft.scala
// result: List(a, b, c, <nothing>)
// a: List(1, 2, 3, 4)
// // defined object FromPairs

