/** author: Andreas Röhler */

/** 
Exercise 2.1.7.5 Given p: Seq[String] and q: Seq[Int] of equal length, compute a Seq[String] that
contains the strings from p ordered according to the corresponding numbers from q. For example, if
  p = Seq("a", "b", "c") and q = Seq(10, -1, 5) then the result must be Seq("b", "c", "a").
  */

val p = Seq("a", "b", "c")
val q = Seq(10, -1, 5)

val result = p.zip(q).sortBy(_._2).map{case (x, y) => x}

// test
val expected = List("b", "c", "a")
assert(result == expected)
