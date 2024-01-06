/** author: Andreas Röhler */ 

/** 
  Exercise 1.6.2.2
  An integer n is called a “3-factor” if it is divisible by only three different integers i,j,k
such that 1 < i,j,k < n. Compute the set of all “3-factor” integers n among n ∈ [1, ..., 1000] .
  */

val p =  (1 to 1000)
val q =  (2 to 999)

val r =  p.map(x => q.filter(y => (x != y) && (x % y == 0)) )
val s = p zip r
val t = s.map{ case (x, y) => (x, y.length) } 
val result = t.filter{ case (x, y) => 3 == y }.map{ case (x, y) => x }

print("3-factor result among n ∈ [1, ..., 1000]: %s\n".format(result))

// 3-factor result among n ∈ [1, ..., 1000]: Vector(16, 81, 625)
