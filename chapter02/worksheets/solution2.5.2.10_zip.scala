/** 
  Exercise 2.5.2.10

  Transform a given sequence xs: Seq[Int] into a sequence of type
  Seq[(Int, Int)] of pairs that skip one neighbor.

  Implement this transformation as a function skip1 with a type
  parameter A instead of the type Int.

  The required type signature and a sample test:

  def skip1[A](xs: Seq[A]): Seq[(A, A)] = ???

  scala> skip1(List(1, 2, 3, 4, 5))
  res0: List[(Int, Int)] = List((1,3), (2,4), (3,5))
  */

def skip1[A](xs: Seq[A]): Seq[(A, A)] = {
  xs zip xs.tail.tail
}

val expected: List[(Int, Int)] = List((1,3), (2,4), (3,5))
val result =  skip1(List(1, 2, 3, 4, 5))
assert(result == expected) 

// scala> :load solution2.5.2.10_zip.scala
// :load solution2.5.2.10_zip.scala
// def skip1[A](xs: Seq[A]): Seq[(A, A)]
// val expected: List[(Int, Int)] = List((1,3), (2,4), (3,5))
// val result: Seq[(Int, Int)] = List((1,3), (2,4), (3,5))

