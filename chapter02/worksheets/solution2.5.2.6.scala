/** 
  Exercise 2.5.2.6

  In a sorted integer array where no values are repeated, find all
  pairs of values whose sum equals a given number 𝑛.
  Use tail recursion.

  A type signature and a sample test:

  def pairs(goal: Int, xs: Array[Int]): Set[(Int, Int)] = ???

  scala> pairs(10, Array(1, 2, 4, 5, 6, 8))
  res0: Set[(Int, Int)] = Set((2,8), (4,6), (5,5))
  */

def pairsIntern(goal: Int, xs: Array[Int], res: Seq[(Int, Int)] = Seq((0, 0))): Seq[(Int, Int)] =
  if (xs.isEmpty) res.reverse.tail
  else
    val a = xs.filter(_ + xs.head == goal)
    if (a.isEmpty)
      pairsIntern(goal, xs.tail, res)
    else
      val b = (xs.head, a(0))
      val c = b +: res
      pairsIntern(goal, xs.tail, c)
 
def pairs(goal: Int, xs: Array[Int]): Set[(Int, Int)] = {
  pairsIntern(goal, xs).toSet
}

val expected: Set[(Int, Int)] = Set((2,8), (4,6), (5,5)) 
val result = pairs(10, Array(1, 2, 4, 5, 6, 8))
assert(result == expected) 

// scala> :load solution2.5.2.6.scala
// :load solution2.5.2.6.scala
// def pairsIntern(goal: Int, xs: Array[Int], res: Seq[(Int, Int)]): Seq[(Int, Int)]
// def pairs(goal: Int, xs: Array[Int]): Set[(Int, Int)]
// val expected: Set[(Int, Int)] = Set((2,8), (4,6), (5,5))
// val result: Set[(Int, Int)] = Set((2,8), (4,6), (5,5))
