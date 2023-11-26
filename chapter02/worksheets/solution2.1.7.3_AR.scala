/** author: Andreas Röhler */

/** Exercise 2.1.7.3
Given two sequences p: Seq[String] and q: Seq[Boolean] of equal length, compute a
Seq[String] with those elements of p for which the corresponding element of q is true.
Hint: use zip, map, filter. */ 

// val names: List[String]        = List("Joe", "Bob", "Mary")
// val a: List[Boolean]           = List(true, false, true)
// val b: List[(String, Boolean)] = names.zip(a)
// val c: List[Any]               = b.map { case (x, y) => if (y == true) x }
// val d: List[Any]               = c.filter(_ != (()))

List("Joe", "Bob", "Mary").zip(List(true, false, true)).map { case (x, y) => if (y == true) x }.filter(_ != (()))

// scala> :load solution2.1.7.3_AR.scala
// Loading solution2.1.7.3_AR.scala...
// res17: List[Any] = List(Joe, Mary)
