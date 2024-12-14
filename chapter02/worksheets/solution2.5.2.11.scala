/** 
  Exercise 2.5.2.11
  (a) For a given integer interval [𝑛1 , 𝑛2], find the largest integer
      𝑘 ∈ [𝑛1 , 𝑛2] such that the decimal representation of 𝑘 does
      not contain any of the digits 3, 5, or 7.

  The required type signature and a sample test:

  def largestNotThreeFiveSeven(a: Long, b: Long): Long = ??? 

  scala> largestNotThreeFiveSeven(19, 97)
  res0: Long = 96
  
  (b) For a given integer interval [𝑛1 , 𝑛2], find the integer 𝑘 ∈ [𝑛1 , 𝑛2] with the
      largest sum of decimal digits.

  (c) A positive integer 𝑛 is called a perfect number if it is equal to the sum of
      its divisors (integers 𝑘 such that 1 ≤ 𝑘 < 𝑛 and 𝑘 divides 𝑛).
      For example, 6 is a perfect number because its divisors are 1, 2,
      and 3, and 1 + 2 + 3 = 6, while 8 is not a perfect number because
      its divisors are 1, 2, and 4, and 1 + 2 + 4 = 7 ≠ 8. 

      Write a function that determines whether a given number 𝑛 is perfect.
      Determine all perfect numbers up to one million.
  */

def largestNotThreeFiveSeven(a: Long=19, b: Long = 97): Long = {
  val xs = (a to b).toList
  val ys =  xs.map(x => x.toString).map(_.toString).filter(! _.contains("3")).filter(! _.contains("5")).filter(! _.contains("7")).last
  ys.toLong
}

def largestSumDezDigitsIntern(xs: List[Long], res: Long = 0, thisNumber: Long = 0): Long = {
  if (xs.isEmpty) thisNumber
  else {
    val a =  xs.head.toString.toList.map(_.asDigit).sum
    if (res < a) {
      largestSumDezDigitsIntern(xs.tail, a, xs.head)
    }
    else
    {
      largestSumDezDigitsIntern(xs.tail, res, thisNumber)
    }
  }
}

def largestSumDezDigits(a: Long = 9, b: Long = 101): Long = {
  val xs = (a to b).toList
  largestSumDezDigitsIntern(xs)
}

def allNeededDivisors(n: Int = 99): List[Int] = {
  (1 to (n - 1)).toList.filter(n % _ == 0)
}

def isPerfect(n: Int = 28): Boolean = {
  val a: Int =  allNeededDivisors(n).sum
  allNeededDivisors(n).sum ==  n
}

def perfectNumbersUpToN(n: Int): List[Int] = {
  (1 to n).toList.filter(isPerfect(_))
}

val result = largestNotThreeFiveSeven()
val expected: Long = 96
assert(result == expected) 

val result2 =  largestSumDezDigits()
val expected2: Long = 99
assert(result2 == expected2) 

val result3 = isPerfect(8)
val expected3 =  false
assert(result3 == expected3) 

val result4 = isPerfect(6)
val expected4 =  true
assert(result4 == expected4) 

val result5 = isPerfect(28)
val expected5 =  true
assert(result5 == expected5) 

val result6 = isPerfect(33)
val expected6 =  false
assert(result6 == expected6) 

val result7 = perfectNumbersUpToN(10000)
val expected7: List[Int] = List(6, 28, 496, 8128)
assert(result7 == expected7) 

// :load solution2.5.2.11.scala
// def largestNotThreeFiveSeven(a: Long, b: Long): Long
// def largestSumDezDigitsIntern(xs: List[Long], res: Long, thisNumber: Long): Long
// def largestSumDezDigits(a: Long, b: Long): Long
// def allNeededDivisors(n: Int): List[Int]
// def isPerfect(n: Int): Boolean
// def perfectNumbersUpToN(n: Int): List[Int]
// val result: Long = 96
// val expected: Long = 96
// val result2: Long = 99
// val expected2: Long = 99
// val result3: Boolean = false
// val expected3: Boolean = false
// val result4: Boolean = true
// val expected4: Boolean = true
// val result5: Boolean = true
// val expected5: Boolean = true
// val result6: Boolean = false
// val expected6: Boolean = false
// val result7: List[Int] = List(6, 28, 496, 8128)
// val expected7: List[Int] = List(6, 28, 496, 8128)
