/** 
  Exercise 2.2.6.3
  Use foldLeft to implement the zipWithIndex method for sequences.

  The required type signature and a sample test:

  def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)] = ???

  scala> zipWithIndex(Seq("a", "b", "c", "d"))
  res0: Seq[(String, Int)] = List((a, 0), (b, 1), (c, 2), (d, 3))
  */

def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)] = {
  val a =  (0 to xs.length - 1)
  type Acc = Seq[(A, Int)]
  var counter = (-1)
  def init: Acc = Seq.empty
  xs.foldLeft(init) { (x, y) => (counter = counter + 1); (x :+ (y, counter)) }
}

// scala> :load solution2.2.6.3.scala
// :load solution2.2.6.3.scala
// def zipWithIndex[A](xs: Seq[A]): Seq[(A, Int)]
// val result: Seq[(String, Int)] = List((a,0), (b,1), (c,2), (d,3))
// val expected: Seq[(String, Int)] = List((a,0), (b,1), (c,2), (d,3))
