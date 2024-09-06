/** 
  Exercise 2.2.6.3
  Use foldLeft to implement the zipWithIndex method for sequences.

  The required type signature and a sample test:

  def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)] = ???

  scala> zipWithIndex(Seq("a", "b", "c", "d"))
  res0: Seq[(String, Int)] = List((a, 0), (b, 1), (c, 2), (d, 3))
  */

def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)] = {
  type Acc = Seq[(A, Int)]
  def init: Acc = Seq((xs.head, -1))
  xs.foldLeft(init) { (x, y) => (y, x(0)(1) + 1) +: x }.reverse.tail
}

val expected: Seq[(String, Int)] = List(("a", 0), ("b", 1), ("c", 2), ("d", 3))
val result = zipWithIndex(Seq("a", "b", "c", "d"))
assert(result == expected) 

