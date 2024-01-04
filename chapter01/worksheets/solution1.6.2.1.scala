/** author: Andreas Röhler */ 

/** 

  Exercise 1.6.2.1
  Define a function add20 of type List[List[Int]] => List[List[Int]] 
  that adds 20 to every element of every inner list.

  A sample test:

  scala> add20( List( List(1), List(2, 3) ) )
  res0: List[List[Int]] = List(List(21), List(22, 23))
 */

def add20(a: List[List[Int]]): List[List[Int]] = {

  a.map(b => b.map(c => c + 20))
}

val result =  add20( List( List(1), List(2, 3) ) )
val expected: List[List[Int]] = List(List(21), List(22, 23))
assert(result == expected) 

// scala> :load solution1.6.2.1.scala
// Loading solution1.6.2.1.scala...
// add20: (a: List[List[Int]])List[List[Int]]
// result: List[List[Int]] = List(List(21), List(22, 23))
// expected: List[List[Int]] = List(List(21), List(22, 23))
