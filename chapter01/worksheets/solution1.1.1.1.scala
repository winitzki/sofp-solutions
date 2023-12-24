/** author: Sergei Winitzki */

/**
  Factorial of 10
  Find the product of integers from 1 to 10 (the factorial of 10).
  */

val result   = (1 to 10).product
val expected = 3628800

assert(result == expected) 

// scala> :load solution1.1.1.1.scala
// Loading solution1.1.1.1.scala...
// result: Int = 3628800
// expected: Int = 3628800
