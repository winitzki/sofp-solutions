/** 
  Exercise 2.5.2.8

  (a) Reverse an integer’s digits (see Example 2.5.1.6) as shown:
  def revDigits(n: Int): Int = ???

  scala> revDigits(12345)
  res0: Int = 54321

  (b) A palindrome integer is an integer number n such that revDigits(n) == n.

  Write a predicate function of type Int => Boolean that checks
  whether a given positive integer is a palindrome.
  */

def revDigits(n: Int): Int = {
  Stream.iterate(n)(_ / 10).takeWhile(_ != 0).map(_ % 10).toList.reverse.foldRight(0)(_ + _ * 10)
}

val result = revDigits(12345)
val expected: Int = 54321
assert(result == expected) 

def isPalindrome(n: Int): Boolean = {
  n.toString.reverse.toInt == n
}

val iPexpected: Boolean = false
val iPresult = isPalindrome(123)
assert(iPresult == iPexpected) 

val iPexpected2: Boolean = true
val iPresult2 = isPalindrome(123321)
assert(iPresult2 == iPexpected2) 

// scala> :load solution2.5.2.8_stream_iterate.scala
// :load solution2.5.2.8_stream_iterate.scala
// there was 1 deprecation warning; re-run with -deprecation for details
// 1 warning found
// def revDigits(n: Int): Int
// val result: Int = 54321
// val expected: Int = 54321
// def isPalindrome(n: Int): Boolean
// val iPexpected: Boolean = false
// val iPresult: Boolean = false
// val iPexpected2: Boolean = true
// val iPresult2: Boolean = true
