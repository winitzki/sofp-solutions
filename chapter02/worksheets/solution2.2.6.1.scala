/** 
Exercise 2.2.6.1 Implement a function fromPairs that performs the inverse transformation to the toPairs function defined in Example 2.2.5.6. The required type
signature and a sample test are:

def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = ???

scala> fromPairs(List((a,b), (c,<nothing>)))
res1: Seq[(String, String)] = List("a", "b", "c", "<nothing>")

Hint: This can be done with foldLeft or with flatMap.
 */

def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = { 
  var b: Seq[A] = List()
  xs.map( x => (b = b :+ x(0) :+ x(1)))
  b
}

val result = fromPairsString(List(("a","b"), ("c","<nothing>"))).tail
val expected = List("a", "b", "c", "<nothing>")

assert(result == expected)
