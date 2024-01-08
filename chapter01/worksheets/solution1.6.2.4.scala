/** author: Andreas Röhler */

/** 
  Exercise 1.6.2.4
  Define a function see100 of type List[List[Int]] => List[List[Int]]
  that selects only those inner lists whose largest value is at least
  100.

  Test with:
  scala> see100( List( List(0, 1, 100), List(60, 80), List(1000) ) )
  res0: List[List[Int]] = List(List(0, 1, 100), List(1000))
 */

def see100(a: List[List[Int]]): List[List[Int]] = {
  a.filter(99 < _.max)
}

val result =  see100( List( List(0, 1, 100), List(60, 80), List(1000) ) )

val expected:List[List[Int]] = List(List(0, 1, 100), List(1000))

assert(result == expected) 
