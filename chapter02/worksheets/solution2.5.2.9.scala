/** 
  Exercise 2.5.2.9
  Define a function findPalindrome: Long => Long
  performing the following computation:

  First define f(n) = revDigits(n) + n for a given integer n,
  where the function revDigits was defined in Exercise 2.5.2.8.

  If f(n) is a palindrome integer, findPalindrome returns that integer.

  Otherwise, it keeps applying the same transformation and computes
  f(n), f(f(n)), ..., until a palindrome integer is eventually found
  (this is mathematically guaranteed).

  A sample test:
  scala> findPalindrome(10101)
  val res0: Long = 20202

  scala> findPalindrome(123)
  res0: Long = 444

  scala> findPalindrome(83951)
  res1: Long = 869363968

 */

def revDigits (n: Long): Long = {
  n.toString.reverse.toLong
}

def findPalindrome(n: Long): Long = {
  val a = n.toString.reverse.toLong + n
  if (revDigits(a) == a) a
  else
    findPalindrome(a)
}

val result = findPalindrome(10101)
val expected: Long = 20202
assert(result == expected)

val result1 =  findPalindrome(123)
val expected1: Long = 444
assert(result1 == expected1)

val result2 =   findPalindrome(83951)
val expected2: Long = 869363968
assert(result2 == expected2)

// scala> :load solution2.5.2.9.scala
// :load solution2.5.2.9.scala
// def revDigits(n: Long): Long
// def findPalindrome(n: Long): Long
// val result: Long = 20202
// val expected: Long = 20202
// val result1: Long = 444
// val expected1: Long = 444
// val result2: Long = 869363968
// val expected2: Long = 869363968
