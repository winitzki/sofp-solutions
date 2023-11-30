/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.4
  Convert a Seq[Int] into a Seq[(Int, Boolean)] where
  the Boolean value is true when the element is followed by a larger
  value. For example, the input sequence Seq(1,3,2,4) is to be
  converted into Seq((1,true),(3,false),(2,true),(4,false)). (The last
  element, 4, has no following element.)
 */

val a = Seq[Int](1, 3, 2, 4)
val b = a.last
val c: Seq[(Int, Boolean)] = Seq((4, false))
// val c = List(b, false)
val d: Seq[(Int, Boolean)] = Seq[Int](1, 3, 2, 4).sliding(2).toList.map{ case List(x, y) => if (x < y) (x, true) else (x, false)}
val result = d ++ c

val expected: Seq[(Int, Boolean)] = List((1,true), (3,false), (2,true), (4,false))

assert(result == expected)
