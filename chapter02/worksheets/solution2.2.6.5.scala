/** 
  Exercise 2.2.6.5
  Split a sequence into subsequences (“batches”) of length at most
  𝑛.
  The required type signature and a sample test:

  def byLength[A](xs: Seq[A], maxLength: Int): Seq[Seq[A]] = ???

  scala> byLength(Seq("a", "b", "c", "d"), 2)
  res0: Seq[Seq[String]] = List(List(a, b), List(c, d))

  scala> byLength(Seq(1, 2, 3, 4, 5, 6, 7), 3)
  res1: Seq[Seq[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7))
 */

def byLength[A](xs: Seq[A], maxLength: Int): Seq[Seq[A]] = {
  if (xs.length <= maxLength)
    Seq(xs)
  else
    Seq(xs.take(maxLength)) ++ byLength(xs.drop(maxLength), maxLength)
}

val expected = Seq(Seq("a", "b"), List("c", "d"))
val result = byLength(Seq("a", "b", "c", "d"), 2)
assert(result == expected) 
val a =  Seq(Seq(1, 2, 3), List(4, 5, 6), List(7))
val b =  byLength(Seq(1, 2, 3, 4, 5, 6, 7), 3)
assert(a == b)

// scala> :load solution2.2.6.5.scala
// :load solution2.2.6.5.scala
// def byLength[A](xs: Seq[A], maxLength: Int): Seq[Seq[A]]
// val expected: Seq[Seq[String]] = List(List(a, b), List(c, d))
// val result: Seq[Seq[String]] = List(List(a, b), List(c, d))
// val a: Seq[Seq[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7))
// val b: Seq[Seq[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7))

