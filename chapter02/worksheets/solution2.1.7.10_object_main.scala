/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.10
  Given a Seq[List[Int]], compute a new Seq[List[Int]] where each list contains three largest elements from the initial list (or fewer than three if the initial list is
  shorter). So, for the input:

  Seq(List(0, 50, 5, 10, 30), List(100), List(1, 2, 200, 20))

  the output must be:

  Seq(List(50, 30, 10), List(100), List(200, 20, 2))
  
Hint: use map, sortBy, take.
 */

object LargestTree {
  def largestTree(a: Seq[List[Int]]): Seq[List[Int]] = {
    a.map{ k=>k.sortBy(k=>(-k))}.map{ k => k.take(3) }
  }
  def main(args: Array[String]) = {
    val expected = Seq(List(50, 30, 10), List(100), List(200, 20, 2))
    val result =  this.largestTree(Seq(List(50, 30, 10), List(100), List(200, 20, 2)))
    assert(result == expected)
    if (result == expected) println("solution2.1.7.10_object_main result: %s\n".format(result))

  }
}

LargestTree.main(Array())

// s$ scala solution2.1.7.10_object_main.scala
// solution2.1.7.10_object_main.scala:31: warning: Script has a main object but statement is disallowed
// LargestTree.main(Array())
//                 ^
// one warning found
// solution2.1.7.10_object_main result: List(List(50, 30, 10), List(100), List(200, 20, 2))
