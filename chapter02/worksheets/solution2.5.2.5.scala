/** 
  Exercise 2.5.2.5
  Same task as in Exercise 2.5.2.4 but using a set of sets.

  Instead of just three sets a, b, c, we are given a value of type
  Set[Set[Int]].

  The required type signature and a sample test:

  def prodSet(si: Set[Set[Int]]): Set[Set[Int]] = ???

  scala> prodSet(Set(Set(1, 2), Set(3), Set(4, 5), Set(6)))
  res0: Set[Set[Int]] = Set(Set(1,3,4,6),Set(1,3,5,6),Set(2,3,4,6),Set(2,3,5,6))

  Hint: use foldLeft and flatMap.
  */

def prodSetIntern(b: Set[Set[Int]] = Set(Set.empty), symbols: Set[Int] = Set.empty): Set[Set[Int]] = {
  if (b.tail.isEmpty) (b.head).map{ x => Set(x) ++ symbols }
  else
    b.head.flatMap{ x => prodSetIntern(b.tail.toSet, Set(x) ++ symbols) }
}

def prodSet(a: Set[Set[Int]] = Set(Set.empty)): Set[Set[Int]] = {
  prodSetIntern(a)
}

val result = prodSet(Set(Set(1, 2), Set(3), Set(4, 5), Set(6)))
val expected: Set[Set[Int]] = Set(Set(1,3,4,6),Set(1,3,5,6),Set(2,3,4,6),Set(2,3,5,6))
assert(result == expected)

// scala> :load solution2.5.2.5.scala
// :load solution2.5.2.5.scala
// def prodSetIntern(b: Set[Set[Int]], symbols: Set[Int]): Set[Set[Int]]
// def prodSet(a: Set[Set[Int]]): Set[Set[Int]]
// val result: Set[Set[Int]] = Set(Set(6, 4, 3, 1), Set(6, 5, 3, 1), Set(6, 4, 3, 2), Set(6, 5, 3, 2))
// val expected: Set[Set[Int]] = Set(Set(1, 3, 4, 6), Set(1, 3, 5, 6), Set(2, 3, 4, 6), Set(2, 3, 5, 6))
