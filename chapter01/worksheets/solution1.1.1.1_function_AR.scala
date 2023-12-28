/** author: Andreas Röhler */

/**
  Factorial of 10
  Find the product of integers from 1 to 10 (the factorial of 10).
  */

def myFactorial(a: Int): Int = {
  (1 to a).foldRight(1)(_ * _)  
}

val result =  myFactorial(10)
println("result: %s".format(result))

val expected = 3628800
assert(result == expected) 

// scala> :load solution1.1.1.1_function_AR.scala
// Loading solution1.1.1.1_function_AR.scala...
// myFactorial: (a: Int)Int
// result: Int = 3628800
// result: 3628800
// expected: Int = 3628800
