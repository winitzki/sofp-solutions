/** 
  Exercise 2.2.6.4
  Use foldLeft to implement a function filterMap that combines map and
  filter for sequences. The predicate is applied to the elements of
  the initial sequence, and values that pass the predicate are mapped.

  The required type signature and a sample test:

  def filterMap[A, B](xs: Seq[A])(pred: A => Boolean)(f: A => B): Seq[B] = ???

  scala> filterMap(Seq(1, 2, 3, 4)) { x => x > 2 } { x => x * 10 }
  res0: Seq[Int] = List(30, 40)
  */

def filterMap[A, B](xs: Seq[A])(pred: A => Boolean)(f: A => B): Seq[B] = {
  xs.filter(pred).map(f)
}

val result =  filterMap(Seq(1, 2, 3, 4)) { x => x > 2 } { x => x * 10 }
val expected: Seq[Int] = List(30, 40)
assert(result == expected)

// scala> filterMap(Seq(1, 2, 3, 4)) { x => x > 2 } { x => x * 10 }
// filterMap(Seq(1, 2, 3, 4)) { x => x > 2 } { x => x * 10 }
// val res1: Seq[Int] = List(30, 40)

