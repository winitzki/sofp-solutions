val p = Seq("a", "b", "c")
val q = Seq(10, -1, 5)

p.zip(q).toList.sortBy(_._2).map{case (x, y) => x}
// res10: List[String] = List(b, c, a)


