/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.8

  Write the solution of Exercise 2.1.7.7 as a function with type
  parameters P and Q instead of the fixed types String and Int. Test
  it with types P = Boolean and Q = Set[Int].
 */

/** 
  Exercise 2.1.7.7

  Given p:Seq[String] and q:Seq[Int] of equal length and assuming that
  values in q do not repeat, compute a Map[Int, String] mapping numbers
  from q to the corresponding strings from p.
  */

// def reorder[A](p: Seq[A], q: Seq[Int]): Seq[A] = ???
def myMapping[P,Q](p: Seq[P], q: Seq[Q]): Map[Q, P] = {
  val erg = q.zip(p).toMap
  erg
  }

val result = myMapping(Seq("asdf", "bsdf", "csdf", "dsdf"), Seq(1, 2, 3, 4))

val expected = Map(1 -> "asdf", 2 -> "bsdf", 3 -> "csdf", 4 -> "dsdf")
assert(result == expected)


  // val p: Seq[P] = Seq("asdf", "bsdf", "csdf", "dsdf")
  // val q: Seq[Int] = (1 to p.length)
