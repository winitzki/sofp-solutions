/** 
Exercise 2.2.6.1 Implement a function fromPairs that performs the inverse transformation to the toPairs function defined in Example 2.2.5.6. The required type
signature and a sample test are:

def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = ???

scala> fromPairs(List((1,2), (3,4)))
res0: Seq[Int] = List(1, 2, 3, 4)

scala> fromPairs(List((a,b), (c,<nothing>)))
res1: Seq[String] = List("a", "b", "c", "<nothing>")

Hint: This can be done with foldLeft or with flatMap.
 */

def fromPairs[A](xs: Seq[(A, A)]): Seq[A] = { 
  var b: Seq[A] = List()
  xs.map((x: (A, A)) => (b = b :+ (x: (A, A))._1 :+ (x: (A, A))._2))
  b
}

val result = fromPairs(List(("a","b"), ("c","<nothing>")))
val expected = List("a", "b", "c", "<nothing>")
assert(result == expected)

val a: Seq[Int] = fromPairs(List((1, 2), (3, 4)))
val c: Seq[Int] = List(1, 2, 3, 4)
assert(a == c)

// scala> :load solution2.2.6.1.scala
// :load solution2.2.6.1.scala
// def fromPairs[A](xs: Seq[(A, A)]): Seq[A]
// val result: Seq[String] = List(a, b, c, <nothing>)
// val expected: List[String] = List(a, b, c, <nothing>)
// val a: Seq[Int] = List(1, 2, 3, 4)
// val c: Seq[Int] = List(1, 2, 3, 4)
