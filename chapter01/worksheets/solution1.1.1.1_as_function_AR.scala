/** author: Andreas Röhler */

/**
  Factorial of 10
  Find the product of integers from 1 to 10 (the factorial of 10).
  */

def myFactorial(a: Int): Int = {
  (1 to a).foldRight(1)(_ * _)  
}

val result =  myFactorial(10)
val expected = 3628800

println("result: %s".format(result))

val expected = 3628800
assert(result == expected) 
