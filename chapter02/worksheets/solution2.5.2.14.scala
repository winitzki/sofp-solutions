/** 
  Exercise 2.5.2.14
  (a) Remove repeated elements (whether adjacent or not) from a
      sequence of type Seq[A].
      (This reproduces the standard library’s method distinct.)

  (b) For a sequence of type Seq[A], remove all elements that are repeated (whether
      adjacent or not) more than 𝑘 times:

  def removeK[A](k: Int, xs: Seq[A]): Seq[A] = ???

  scala> removeK(2, Seq("a", "b", "a", "b", "b", "c", "b", "a"))
  res0: Seq[String] = List(a, b, a, b, c)
  */

def removeKIntern[A](k: Int, xs: Seq[A], res: Seq[A] = Nil): Seq[A] = {
  if (xs.isEmpty) res.reverse
  else
    if (res.isEmpty) removeKIntern(k, xs.tail, xs.head +: res)
    else
      val a = res.filter(_ == xs.head).length
      if (a < k) removeKIntern(k, xs.tail, xs.head +: res)
      else
        removeKIntern(k, xs.tail, res)
}

def removeK[A](k: Int, xs: Seq[A]): Seq[A] = {
  removeKIntern(k, xs)
}

val result =  removeK(2, Seq("a", "b", "a", "b", "b", "c", "b", "a"))
val expected: Seq[String] = List("a", "b", "a", "b", "c")
assert(result == expected)

// scala> :load solution2.5.2.14.scala
// :load solution2.5.2.14.scala
// def removeKIntern[A](k: Int, xs: Seq[A], res: Seq[A]): Seq[A]
// def removeK[A](k: Int, xs: Seq[A]): Seq[A]
// val result: Seq[String] = List(a, b, a, b, c)
// val expected: Seq[String] = List(a, b, a, b, c)
