/** author: Andreas Röhler */
/** author: Sergei Winitzki */ 

/** 
  Exercise 2.1.7.9
  Given a Seq[(String, Int)] showing a list of purchased items (where item names
may repeat), compute a Map[String, Int] showing the total counts. So, for the input:
Seq(("apple", 2), ("pear", 3), ("apple", 5), ("lemon", 2), ("apple", 3))

the output must be Map("apple" -> 10, "pear" -> 3, "lemon" -> 2).
Hint: use groupBy, map, sum.
 */

object TotalCount {
  def totalCount(a: Seq[(String, Int)]): Map[String, Int] = {
    a.groupBy(s => s._1).map { case (x, y) => (x, y.map(_._2).sum) }
  }
  def main(args: Array[String]) {
    val expected =  Map("apple" -> 10, "pear" -> 3, "lemon" -> 2)
    val result =  this.totalCount(Seq(("apple", 2), ("pear", 3), ("apple", 5), ("lemon", 2), ("apple", 3)))
    assert(result == expected)
    if (result == expected) println("result: %s".format(result))

  }
}



// scala> :load solution2.1.7.9_as_object_ohne_main.scala
// Loading solution2.1.7.9_as_object_ohne_main.scala...
// defined object TotalCount
// result: Map[String,Int] = Map(pear -> 3, apple -> 10, lemon -> 2)
// expected: scala.collection.immutable.Map[String,Int] = Map(apple -> 10, pear -> 3, lemon -> 2)
