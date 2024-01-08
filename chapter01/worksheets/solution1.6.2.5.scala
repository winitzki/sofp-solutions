/** author: Andreas Röhler */

/**
  Exercise 1.6.2.5
  Define a function of type List[Double] => List[Double] that “normalizes” the list:

  it finds the element having the largest absolute value and, if that
  value is nonzero, divides all elements by that value and returns a new
  list; otherwise returns the original list.

  Test with: scala> normalize(List(1.0, -4.0, 2.0))
  res0: List[Double] = List(0.25, -1.0, 0.5)
 */

def normalize(a: List[Double]): List[Double] = {

  val b =  a.map(k => k.abs).max
  if (b == 0) a else a.map(_ / 4) 
}

val result = normalize(List(1.0, -4.0, 2.0))
val expected: List[Double] = List(0.25, -1.0, 0.5)

assert(result == expected) 
