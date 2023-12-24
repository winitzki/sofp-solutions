/** author: Andreas Röhler */

/**
  Factorial of 10
  Find the product of integers from 1 to 10 (the factorial of 10).
  */

val a = 10
val b =  (1 to a)
// val c =  b.length
var result = 1
var counter = 0

while (counter < a) { 
  // println("counter: %s".format(counter))
  result = result * b(counter)
  // println("result: %s".format(result))
  counter += 1

}

println("result: %s".format(result))

val expected = 3628800
assert(result == expected) 

// scala> :load solution1.1.1.1_AR.scala
// Loading solution1.1.1.1_AR.scala...
// a: Int = 10
// b: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
// result: Int = 1
// counter: Int = 0
// result: 3628800
// expected: Int = 3628800
