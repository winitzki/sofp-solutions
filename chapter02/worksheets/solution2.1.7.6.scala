/** author: Andreas Röhler */

/** 
Exercise 2.1.7.6 Write the solution of Exercise 2.1.7.5 as a function
with type parameter A instead of the fixed type String. The required
type signature and a sample test:

  def reorder[A](p: Seq[A], q: Seq[Int]): Seq[A] = ???

// In Scala, ??? means "not yet implemented".

scala> reorder(Seq(6.0,2.0,8.0,4.0), Seq(20,10,40,30))
res0: Seq[Double] = List(2.0, 6.0, 4.0, 8.0)

// Test with type parameter A = Double.
 */

/**
Exercise 2.1.7.5 Given p: Seq[String] and q: Seq[Int] of equal length, compute a Seq[String] that
contains the strings from p ordered according to the corresponding numbers from q. For example, if
  p = Seq("a", "b", "c") and q = Seq(10, -1, 5) then the result must be Seq("b", "c", "a").
  */

val p = Seq("a", "b", "c")
val q = Seq(10, -1, 5)

def reorder[A](p: Seq[A], q: Seq[Int]): Seq[A] = {
  p.zip(q).sortBy(_._2).map{case (x, y) => x}
  }

val result =  reorder(Seq(6.0,2.0,8.0,4.0), Seq(20,10,40,30))
val expected: Seq[Double] = List(2.0, 6.0, 4.0, 8.0)

assert(result == expected)
