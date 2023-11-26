/** author: Sergei Winitzki */

/** Exercise 2.1.7.3
Given two sequences p: Seq[String] and q: Seq[Boolean] of equal length, compute a
Seq[String] with those elements of p for which the corresponding element of q is true.
Hint: use zip, map, filter. */ 

val names: List[String]        = List("Joe", "Bob", "Mary")
val a: List[Boolean]           = List(true, false, true)
val b: List[(String, Boolean)] = names.zip(a)
val c: List[(String, Boolean)] = b.filter { case (x, y) => y }
val d: List[String]            = c.map { case (x, y) => x }

