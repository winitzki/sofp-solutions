/** author: Andreas Röhler */ 

/** 
  Exercise 1.6.2.3
  Given a function f: Int => Boolean, an integer n is called a “3- f ”
if there are only three different integers j ∈ [1, ..., n] such that f
( j) returns true. Define a function that takes f as an argument and
returns a sequence of all “3- f ” integers among n ∈ [1, ..., 1000].
What is the type of that function? Implement Exercise 1.6.2.2 using
that function.
 */

def is3Factor(n: Int): Boolean = {
  val q =  (2 to n-1)
  val r = q.filter(y => (n != y) && (n % y == 0))
   (r.length == 3)
}

def nestedIs3Factor(f: (Int => Boolean)): List[Int] = {
  (1 to 1000).toList.filter(x => f(x))
}

nestedIs3Factor(is3Factor)
