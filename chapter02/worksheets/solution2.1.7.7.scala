/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.7

  Given p:Seq[String] and q:Seq[Int] of equal length and assuming that
  values in q do not repeat, compute a Map[Int, String] mapping numbers
  from q to the corresponding strings from p.
  */

val p: Seq[String] = Seq("asdf", "bsdf", "csdf", "dsdf")
val q: Seq[Int] = (1 to p.length)

val result: Map[Int, String] = q.zip(p).toMap
val expected = Map(1 -> "asdf", 2 -> "bsdf", 3 -> "csdf", 4 -> "dsdf")
assert(result == expected)
