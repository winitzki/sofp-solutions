/** 
  Exercise 2.5.2.3

  For a given integer 𝑛, compute the sum of cubed digits, then the sum
  of cubed digits of the result, etc.;

  stop the resulting sequence when it repeats itself, and so determine
  whether it ever reaches 1.

  (Use Exercise 2.5.2.1.)

  def cubes(n: Int): Stream[Int] = ???

  def cubesReach1(n: Int): Boolean = ???

  scala> cubesReach1(10)
  res3: Boolean = true

  scala> cubesReach1(4)
  res4: Boolean = false
  */

def digitsOf(n: Int): Seq[Int] = {
  Stream.iterate(n) { nk => nk / 10 }
    .takeWhile { nk => nk != 0 }
    .map { nk => nk % 10 }
    .toList.reverse
}

def digitsListSum(x: Int, xs: Seq[Int] = Seq(), f: (Int => Int)): Seq[Int] = {
  val a: Int = digitsOf(x).map{ x => f(x)}.sum
  if (xs.contains(a))
    if (a == 1) xs
    else xs.reverse
  else digitsListSum(a, a +: xs, f)
}

def cubes(n: Int): Seq[Int] = {
  digitsListSum(n, xs = Seq(), { k => k * k * k })
}

def cubesReach1(x: Int): Boolean = {
  val a = cubes(x)
    a(0) == 1
}


cubes(123)
cubes(10)
cubes(4)

val result =  cubesReach1(10)
val expected = true
assert(result == expected)

val result2 =  cubesReach1(4)
val expected2 = false
assert(result2 == expected2)

assert ( cubesReach1(20) == false )
assert ( cubesReach1(50) == false )
assert ( cubesReach1(100) == true )

assert ( cubesReach1(112) == true )
assert ( cubesReach1(114) == false )
assert ( cubesReach1(778) == true )
