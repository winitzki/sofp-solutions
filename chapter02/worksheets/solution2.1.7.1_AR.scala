/** author: Andreas Röhler */

/** 
Exercise 2.1.7.1
Find all pairs i, j within (0, 1, ..., 9) such that i + 4 ∗ j > i ∗ j.
Hint: use flatMap and filter.
  */

val a = (0 to 9).sliding(2).toList
val b = a.map{ case x => (x.apply(0) +  4 * x.apply(1)) }
val c = a.map{ case x => (x.apply(0) * x.apply(1)) } 
val d = b.zip(c)
// List((4,0), (9,2), (14,6), (19,12), (24,20), (29,30), (34,42), (39,56), (44,72))
val e = d.map{ case x => if (x._1  > x._2) x }.filter(_ != ())

/** 
scala> :load solution2.1.7.1_AR.scala
Loading solution2.1.7.1_AR.scala...
a: List[scala.collection.immutable.IndexedSeq[Int]] = List(Vector(0, 1), Vector(1, 2), Vector(2, 3), Vector(3, 4), Vector(4, 5), Vector(5, 6), Vector(6, 7), Vector(7, 8), Vector(8, 9))
b: List[Int] = List(4, 9, 14, 19, 24, 29, 34, 39, 44)
c: List[Int] = List(0, 2, 6, 12, 20, 30, 42, 56, 72)
d: List[(Int, Int)] = List((4,0), (9,2), (14,6), (19,12), (24,20), (29,30), (34,42), (39,56), (44,72))
warning: there was one deprecation warning; re-run with -deprecation for details
e: List[Any] = List((4,0), (9,2), (14,6), (19,12), (24,20))
 */
