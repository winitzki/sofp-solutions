/** author: Andreas Röhler */
/** author: Sergei Winitzki */

/** 
  Exercise 2.1.7.7

  Given p:Seq[String] and q:Seq[Int] of equal length and assuming that
  values in q do not repeat, compute a Map[Int, String] mapping numbers
  from q to the corresponding strings from p.
  */

/** 
  Exercise 2.1.7.8
  Write the solution of Exercise 2.1.7.7 as a function with
 type parameters P and Q instead of the fixed types Int and String. 

  The return type of the function should be Map[P, Q]. Run some tests
 using types P = Double and Q = Set[Boolean]. */

def myMapping[P,Q](p: Seq[P], q: Seq[Q]): Map[P, Q] = {
  val erg: Map[P, Q] = p.zip(q).toMap
  erg
  }

val result = myMapping(Seq( Set(true), Set(true, false), Set() ), Seq( 1.0, 2.0, 3.0))

val expected: Map[scala.collection.immutable.Set[_ <: Boolean],Double] = Map(Set(true) -> 1.0, Set(true, false) -> 2.0, Set() -> 3.0)

assert(result == expected)
