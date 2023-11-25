val p = Seq("a", "b", "c")
val q = Seq(10, -1, 5)

p.zip(q).sortBy(_._2).map{case (x, y) => x}

// scala> :load solution2.1.7.5.scala
// Loading solution2.1.7.5.scala...
// p: Seq[String] = List(a, b, c)
// q: Seq[Int] = List(10, -1, 5)
// res0: Seq[String] = List(b, c, a)
