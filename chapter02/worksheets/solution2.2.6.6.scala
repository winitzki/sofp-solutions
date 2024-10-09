/** 
  Exercise 2.2.6.6
  Split a sequence into batches by “weight” computed via a given function.

  The total weight of items in any batch should not be larger than a given
  maximum weight.

  The required type signature and a sample test:

  def byWeight[A](xs: Seq[A], maxW: Double)(w: A => Double): Seq[Seq[A]] = ???

  scala> byWeight((1 to 10).toList, 5.75){ x => math.sqrt(x) }

  res0: Seq[Seq[Int]] = List(List(1, 2, 3), List(4, 5), List(6, 7), List(8), List(9), List(10))
 */

def weighing[A](xs: Seq[A], maxW: Double, ys: Seq[A] = Nil, res: Seq[Seq[A]] = Seq.empty)(w: A => Double): Seq[Seq[A]] = {
  if (xs.isEmpty) res
  else
  if (((xs.head +: ys).map{w}.sum < maxW) && (xs.tail.isEmpty == false))
    weighing(xs.tail, maxW, xs.head +: ys, res)(w)
  else
        weighing(xs.tail, maxW, Seq(xs.head), ys +: res)(w)
  }

def byWeight[A](xs: Seq[A], maxW: Double)(w: A => Double): Seq[Seq[A]] = {
  weighing(xs, maxW)(w).reverse
}

val expected: Seq[Seq[Int]] = List(List(3, 2, 1), List(5, 4), List(7, 6), List(8), List(9))
val result =  byWeight((1 to 10).toList, 5.75){ x => math.sqrt(x) }
assert(result == expected) 
