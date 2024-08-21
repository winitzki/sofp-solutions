/** 
  Exercise 2.5.2.1
  Define a function dsq that computes the sum of squared digits of
  a given integer;

  for example, dsq(123) = 14
  (see Example 2.5.1.6).

  Generalize dsq to take as an argument a function f: Int => Int

  replacing the squaring operation.

  The required type signature and a sample test:

  def digitsFSum(x: Int)(f: Int => Int): Int = ???

  scala> digitsFSum(123){ x => x * x }

  res0: Int = 14

  scala> digitsFSum(123){ x => x * x * x }
  res1: Int = 36
  */

def digitsOf(n: Int): Seq[Int] = {
  Stream.iterate(n) { nk => nk / 10 }
    .takeWhile { nk => nk != 0 }
    .map { nk => nk % 10 }
    .toList.reverse
}

def digitsFSum(x: Int)(f: Int => Int): Int =
  digitsOf(x).map{ x => f(x)}.foldLeft(0)(_+ _)

val expected: Int =  14
val result =  digitsFSum(123){ x => x * x }
assert(result == expected) 

// scala> :load solution2.5.2.1.scala
// :load solution2.5.2.1.scala
// there was 1 deprecation warning; re-run with -deprecation for details
// 1 warning found
// def digitsOf(n: Int): Seq[Int]
// def digitsFSum(x: Int)(f: Int => Int): Int
// val expected: Int = 14
// val result: Int = 14

val a =  36
val b =  digitsFSum(123){ x => x * x * x }
assert(a == b)

// val a: Int = 36
// val b: Int = 36

