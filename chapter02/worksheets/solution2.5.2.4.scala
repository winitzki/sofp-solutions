/** 
  Exercise 2.5.2.4

  For a, b, c of type Set[Int],
  compute the set of all sets of the form Set(x, y, z)
  where x is from a, y from b, and z from c.

  The required type signature and a sample test:

  def prod3(a: Set[Int], b: Set[Int], c: Set[Int]): Set[Set[Int]] = ???

  scala> prod3(Set(1, 2), Set(3), Set(4, 5))
  res0: Set[Set[Int]] = Set(Set(1,3,4), Set(1,3,5), Set(2,3,4), Set(2,3,5))

  Hint: use flatMap.
 */

def prod3(a: Set[Int], b: Set[Int], c: Set[Int]): Set[Set[Int]] = {
  val d =  List(a, b, c)
  d(0).flatMap{ x => d(1).flatMap{ y => d(2).map{ z => Set(x, y, z) }}}
}

val result = prod3(Set(1, 2), Set(3), Set(4, 5))
val expected: Set[Set[Int]] = Set(Set(1,3,4), Set(1,3,5), Set(2,3,4), Set(2,3,5)) 
assert(result == expected)

// scala> :load solution2.5.2.4.scala
// :load solution2.5.2.4.scala
// def prod3(a: Set[Int], b: Set[Int], c: Set[Int]): Set[Set[Int]]
// val result: Set[Set[Int]] = Set(Set(1, 3, 4), Set(1, 3, 5), Set(2, 3, 4), Set(2, 3, 5))
// val expected: Set[Set[Int]] = Set(Set(1, 3, 4), Set(1, 3, 5), Set(2, 3, 4), Set(2, 3, 5))

