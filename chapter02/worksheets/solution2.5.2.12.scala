/** 
  Exercise 2.5.2.12

  Transform a sequence by removing adjacent repeated elements when
  they are repeated more than 𝑘 times. Repetitions up to 𝑘 times
  should remain unchanged.

  The required type signature and a sample test:

  def removeDups[A](s: Seq[A], k: Int): Seq[A] = ???

  scala> removeDups(Seq(1, 1, 1, 1, 5, 2, 2, 5, 5, 5, 5, 5, 1), 3)
  res0: Seq[Int] = List(1, 1, 1, 5, 2, 2, 5, 5, 5, 1)
 */

def removeDupsIntern[A](xs: Seq[A], k: Int, res: Seq[A] = Seq.empty): Seq[A] = { 
  if (xs.isEmpty) res.reverse
  else { 
    val a: Seq[A] = xs.takeWhile(_ == xs.head).take(k)
    val b =  xs.dropWhile(_ == xs.head)
    removeDupsIntern(b, k, a ++ res)
  }
}

def removeDups[A](s: Seq[A], k: Int): Seq[A] = {
  removeDupsIntern(s, k)
}

val result = removeDups(Seq(1, 1, 1, 1, 5, 2, 2, 5, 5, 5, 5, 5, 1), 3)
val expected: Seq[Int] = List(1, 1, 1, 5, 2, 2, 5, 5, 5, 1)
assert(result == expected) 
