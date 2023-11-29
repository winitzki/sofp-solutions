/** author: Sergei Winitzki */

/** Exercise 2.1.7.3
Given two sequences p: Seq[String] and q: Seq[Boolean] of equal length, compute a
Seq[String] with those elements of p for which the corresponding element of q is true.
Hint: use zip, map, filter. */ 

val names:  List[String]        = List("Joe", "Bob", "Mary")
val a:  List[Boolean]           = List(true, false, true)

def selectTrueOperatorSyntax(names: List[String], flags: List[Boolean]): List[String] =
  names zip flags filter (_._2) map (_._1)

assert(selectTrueOperatorSyntax(names, a) == List("Joe", "Mary"))

// scala> :load solution2.1.7.3_as_function_SW.scala
// Loading solution2.1.7.3_as_function_SW.scala...
// names: List[String] = List(Joe, Bob, Mary)
// a: List[Boolean] = List(true, false, true)
// selectTrueOperatorSyntax: (names: List[String], flags: List[Boolean])List[String]
// res27: List[String] = List(Joe, Mary)
