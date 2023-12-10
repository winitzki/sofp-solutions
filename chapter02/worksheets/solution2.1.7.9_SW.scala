/** author: Sergei Winitzki */ 

/** 
  Exercise 2.1.7.9
  Given a Seq[(String, Int)] showing a list of purchased items (where item names
may repeat), compute a Map[String, Int] showing the total counts. So, for the input:
Seq(("apple", 2), ("pear", 3), ("apple", 5), ("lemon", 2), ("apple", 3))

the output must be Map("apple" -> 10, "pear" -> 3, "lemon" -> 2).
Hint: use groupBy, map, sum.
 */

val a: Seq[(String, Int)] =  Seq(("pear", 2), ("apple", 2), ("apple", 6), ("pear", 1), ("lemon", 4), ("apple", 2), ("apple", 2))

val b: Map[String, Seq[(String, Int)]] = a.groupBy(_._1)

val result: Map[String, Int] = b.map { case (name: String, pairs: Seq[(String, Int)]) => (name, pairs.map(_._2).sum) }

val expected = Map("apple" -> 12, "pear" -> 3, "lemon" -> 4)
assert( result == expected)
