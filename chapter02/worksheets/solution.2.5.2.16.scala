/** 
  Exercise 2.5.2.16

  Using tail recursion, find all common integers between two sorted
  sequences:

  @tailrec def commonInt(xs: Seq[Int], ys: Seq[Int]): Seq[Int] = ???

  scala> commonInt(Seq(1, 3, 5, 7), Seq(2, 3, 4, 6, 7, 8))
  res0: Seq[Int] = List(3, 7)
  */

import scala.annotation.tailrec

@tailrec def commonIntIntern(xs: Seq[Int], ys: Seq[Int], res: Seq[Int] = Seq.empty): Seq[Int] =
  if (xs.isEmpty || ys.isEmpty) res.reverse
  else
    if (xs.head == ys.head)
      commonIntIntern(xs.tail, ys.tail, xs.head +: res)
    else   
      if (xs.head < ys.head) commonIntIntern(xs.tail, ys, res)
      else
        commonIntIntern(xs, ys.tail, res)

def commonInt(xs: Seq[Int], ys: Seq[Int]): Seq[Int] =
  commonIntIntern(xs, ys, res = Seq.empty)

val expected: Seq[Int] = List(3, 7)
val result = commonInt(Seq(1, 3, 5, 7), Seq(2, 3, 4, 6, 7, 8))
assert(result == expected) 

// scala> :load solution.2.5.2.16.scala
// :load solution.2.5.2.16.scala
// def commonIntIntern(xs: Seq[Int], ys: Seq[Int], res: Seq[Int]): Seq[Int]
// def commonInt(xs: Seq[Int], ys: Seq[Int]): Seq[Int]
// val expected: Seq[Int] = List(3, 7)
// val result: Seq[Int] = List(3, 7)

