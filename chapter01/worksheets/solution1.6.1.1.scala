def staggeredFactorial(n: Int): Int = (n to 1 by -2).product

assert(staggeredFactorial(8) == 384)
