/** 
  Exercise 1.6.1.1
  Define a function that computes a “staggered factorial” (denoted by n!!) for positive
integers. It is defined as either 1 · 3 · ... · n or as 2 · 4 · ... · n, depending on whether n is even or odd.
For example, 8!! = 384 and 9!! = 945.

 */

def staggeredFactorial(n: Int): Int = (n to 1 by -2).product

assert(staggeredFactorial(8) == 384)
