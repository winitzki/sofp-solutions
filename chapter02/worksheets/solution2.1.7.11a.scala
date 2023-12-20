/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.11
  (a) Given two sets, p: Set[Int] and q: Set[Int], compute a set of type Set[(Int,Int)]
  as the Cartesian product of the sets p and q. This is the set of all pairs (x, y) where x is an
element from the set p and y is an element from the set q.

  (b) Implement this computation as a function with type parameters I, J instead of Int. The required
type signature and a sample test:
def cartesian[I, J](p: Set[I], q: Set[J]): Set[(I, J)] = ???
scala> cartesian(Set("a", "b"), Set(10, 20))
res0: Set[(String, Int)] = Set((a,10), (a,20), (b,10), (b,20))

Hint: use flatMap and map on sets.
 */

// (0 to 9).flatMap(x => (0 to 9).map { y => (x, y) } )

val p: Set[Int] = (0 to 9).toSet
val q: Set[Int] = (0 to 9).toSet

p.flatMap(x => q.map { y => (x, y) } )

val expected: Set[(Int,Int)] = Set((7,1), (7,5), (1,8), (7,6), (2,5), (1,5), (7,9), (5,0), (9,0), (6,7), (8,9), (3,9), (0,2), (0,0), (5,2), (7,4), (5,1), (4,0), (3,4), (6,4), (7,7), (4,7), (0,9), (6,6), (7,8), (3,1), (9,1), (6,1), (4,1), (5,9), (6,2), (8,1), (0,7), (2,0), (0,3), (6,9), (4,4), (3,0), (8,0), (1,6), (0,5), (3,6), (6,5), (2,8), (6,8), (1,1), (6,3), (3,5), (7,3), (4,6), (8,3), (9,8), (1,9), (4,5), (1,4), (2,6), (8,2), (0,8), (8,8), (4,9), (0,4), (2,9), (5,7), (5,4), (9,7), (3,2), (1,3), (2,2), (5,5), (4,8), (2,7), (4,2), (2,4), (3,7), (0,1), (9,6), (8,4), (5,3), (5,8), (3,3), (1,7), (2,3), (1,2), (2,1), (4,3), (9,9), (8,7), (6,0), (8,5), (9,3), (9,4), (7,2), (9,5), (8,6), (1,0), (3,8), (5,6), (0,6), (9,2), (7,0))

val result: Set[(Int,Int)] = p.flatMap(x => q.map { y => (x, y) } )

assert(result == expected) 
