/** author: Andreas Röhler */

/**
  Factorial of 10
  Find the product of integers from 1 to 10 (the factorial of 10).
  */

object MyFactorial {
  def myFactorial(a: Int): Int = {
    (1 to a).foldRight(1)(_ * _)
  }
  def main(args: Array[String]) {
    val expected = 3628800
    val result =  this.myFactorial(10)
    println("result: %s".format(result))
    assert(result == expected)
  }
}

MyFactorial.main(Array())

// scala> :load solution1.1.1.1_as_function_AR.scala
// Loading solution1.1.1.1_as_function_AR.scala...
// defined object MyFactorial
// result: 3628800

// $ scalac solution1.1.1.1_as_function_AR.scala
// solution1.1.1.1_as_function_AR.scala:33: error: expected class or object definition
// MyFactorial.main(Array())
// ^
// one error found
