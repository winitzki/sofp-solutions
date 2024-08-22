/** 
  Exercise 2.5.2.2
  Compute the Collatz sequence 𝑐𝑖 as a stream defined by
  𝑐₀ = 𝑛 ;
  𝑐 ₖ+₁ =
           𝑐ₖ/2         if 𝑐ₖ is even,
           3 ∗ 𝑐ₖ + 1   if 𝑐ₖ is odd.
  Stop the stream when it reaches 1 (as one would expect5 it will).
  */

def collatzSequence(n: Int, xs: List[Int] = List(0)): List[Int] =
  if xs.head == 1 then xs.init
  else if n % 2 == 0 then
       collatzSequence(n/2, n +: xs)
  else collatzSequence (n * 3 + 1, n +: xs)
    
val expected: List[Int] = List(1, 2, 4, 8)
val result = collatzSequence(8)
assert(result == expected)

// scala> :load solution2.5.2.2.scala
// :load solution2.5.2.2.scala
// def collatzSequence(n: Int, xs: List[Int]): List[Int]
// val expected: List[Int] = List(1, 2, 4, 8)
// val result: List[Int] = List(1, 2, 4, 8)
