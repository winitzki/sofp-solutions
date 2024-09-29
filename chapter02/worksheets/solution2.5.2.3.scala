/** 
  Exercise 2.5.2.3

  For a given integer 𝑛, compute the sum of cubed digits, then the sum
  of cubed digits of the result, etc.;

  stop the resulting sequence when it repeats itself, and so determine
  whether it ever reaches 1.

  (Use Exercise 2.5.2.1.)

  def cubes(n: Int): Stream[Int] = ???

  scala> cubes(123).take(10).toList
  res0: List[Int] = List(123, 36, 243, 99, 1458, 702, 351, 153, 153, 153)

  scala> cubes(2).take(10).toList
  res1: List[Int] = List(2, 8, 512, 134, 92, 737, 713, 371, 371, 371)

  scala> cubes(4).take(10).toList
  res2: List[Int] = List(4, 64, 280, 520, 133, 55, 250, 133, 55, 250)

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

def digitsFSum(x: Int)(f: Int => Int): Int = {
  // digitsOf(x).map{ x => f(x)}.foldLeft(0)(_ + _)
  digitsOf(x).map{ x => f(x)}.sum
}

def digitsListSum(x: Int, xs: Seq[Int] = Seq(), f: (Int => Int)): Seq[Int] = {
  // digitsOf(x).map{ x => f(x)}.foldLeft(0)(_ + _)
  // var xs: Seq[Int] = Seq()
  val a: Int = digitsOf(x).map{ x => f(x)}.sum
  println(s"a: ${a}")
  if (xs.contains(a)) xs.reverse
  else digitsListSum(a, a +: xs, f)
}

def cubes(n: Int): Seq[Int] = {
  digitsListSum(n, xs = Seq(), { k => k * k * k })
}

def cubesReach1(x: Int): Boolean = {
  val a = Cubes.cubes(x)
    a.length == 1
}

val result =  cubesReach1(10)
val expected = true
assert(result == expected)

val result2 =  cubesReach1(4)
val expected2 = false
assert(result2 == expected2)

