/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.9
  Given a Seq[(String, Int)] showing a list of purchased items (where item names
may repeat), compute a Map[String, Int] showing the total counts. So, for the input:
Seq(("apple", 2), ("pear", 3), ("apple", 5), ("lemon", 2), ("apple", 3))

the output must be Map("apple" -> 10, "pear" -> 3, "lemon" -> 2).
Hint: use groupBy, map, sum.
 */

val a: Seq[(String, Int)] =  Seq(("pear", 2), ("apple", 2), ("apple", 6), ("pear", 1), ("lemon", 4), ("apple", 2), ("apple", 2))

val b =  a.groupBy(s => s._1)

val c = b.map{ case (x,y) => y}

val e = c.map{ k=>k.map{ case x=>x._1} }.map{ x=>x(0)}

val g = c.map{ k=>k.map{ case x=>x._2}.sum }

val result = e.zip(g).toMap

val expected = Map("pear" -> 3, "apple" -> 12, "lemon" -> 4)

assert(result == expected)
