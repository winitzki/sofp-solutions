/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.4
  Convert a Seq[Int] into a Seq[(Int, Boolean)] where
  the Boolean value is true when the element is followed by a larger
  value. For example, the input sequence Seq(1,3,2,4) is to be
  converted into Seq((1,true),(3,false),(2,true),(4,false)). (The last
  element, 4, has no following element.)
 */

def followedByGreater(a: Seq[Int]): Seq[(Int, Boolean)] = {
  val b = a.last
  val c: Seq[(Int, Boolean)] = Seq((b, false))
  val d: Seq[(Int, Boolean)] = a.sliding(2).toList.map{ case List(x, y) => if (x < y) (x, true) else (x, false)}
  val e = d ++ c
  e
}

val z = Seq[Int](1, 3, 2, 4);
val result = followedByGreater(z)
val expected: Seq[(Int, Boolean)] = List((1,true), (3,false), (2,true), (4,false))

assert(result == expected)
