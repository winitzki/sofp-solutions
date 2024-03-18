/** Exercise 2.1.7.3
Given two sequences p: Seq[String] and q: Seq[Boolean] of equal length, compute a
Seq[String] with those elements of p for which the corresponding element of q is true.
Hint: use zip, map, filter. */ 

val result = Seq("Joe", "Bob", "Mary").zip(Seq(true, false, true))
  // .map { case (x, y) => if (y == true) x else () }.filter(_ != (())).map{ case x => x.toString }
  .filter { case (x, y) => y }.map { case ( x, y) => x }
  assert(result == List("Joe", "Mary"))

// scala> :load solution2.1.7.3_AR.scala
// Loading solution2.1.7.3_AR.scala...
// res17: Seq[String] = List(Joe, Mary)
