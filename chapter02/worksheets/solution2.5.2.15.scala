/** 
  Exercise 2.5.2.15
  For a given sequence xs:Seq[Double], find a subsequence that
  has the largest sum of values.

  The sequence xs is not sorted, and its values may be positive or
  negative.

  The required type signature and a sample test:

  def maxsub(xs: Seq[Double]): Seq[Double] = ???

  scala> maxsub(Seq(1.0, -1.5, 2.0, 3.0, -0.5, 2.0, 1.0, -10.0, 2.0))

  res0: Seq[Double] = List(2.0, 3.0, -0.5, 2.0, 1.0)

  Hint: use dynamic programming and foldLeft.
 */

def sumFromfirstSeq(x: (Seq[Double], Seq[Double])): Double = {
  x._1.sum
}

def firstSeq(x: (Seq[Double], Seq[Double])): Seq[Double] = {
  x._1
}

def maxsubIntern(xs: Seq[Double]):(Seq[Double], Seq[Double]) = { 
  xs.foldLeft(Seq.empty[Double], Seq.empty[Double]){ case ((maxList, allList), y) =>
      { if (maxList.sum < (y +: allList).sum) { 
        (y +: allList, y +: allList) } 
        else (maxList, (y +: allList))
      }
  }
}

def maxsub(xs: Seq[Double], res: Seq[Double] = Seq.empty, max: Double = Double.NegativeInfinity): Seq[Double] = {
  if (xs.isEmpty) res.reverse                                                     
  else {
    if (sumFromfirstSeq(maxsubIntern(xs)) <= max) maxsub(xs.tail, res, max)
    else maxsub(xs.tail, firstSeq(maxsubIntern(xs)), (sumFromfirstSeq(maxsubIntern(xs))))
  }
}

val a =  List(1.0, -1.5, 2.0, 3.0, -0.5, 2.0, 1.0, -10.0, 2.0)
val result = maxsub(a)
val resultSum = maxsub(a).sum
val expected =  List(2.0, 3.0, -0.5, 2.0, 1.0)
val expectedSum =  List(2.0, 3.0, -0.5, 2.0, 1.0).sum
assert(result == expected) 
