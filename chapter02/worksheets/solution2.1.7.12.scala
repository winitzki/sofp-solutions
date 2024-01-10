/** author: Andreas Röhler */ 

/**
  Exercise 2.1.7.12*

  Given a Seq[Map[Person, Amount]], showing the amounts various people paid on
  each day, compute a Map[Person, Seq[Amount]], showing the sequence of payments for each person.

  Assume that Person and Amount are type parameters.
  The required type signature and a sample test:

  def payments[Person, Amount](data: Seq[Map[Person, Amount]]): Map[Person, Seq[Amount]] = ???

  On day 1, Tarski paid 10 and Gödel paid 20. On day 2, Church paid 100 and Gentzen paid 50, etc.

  scala> payments (Seq(Map("Tarski" -> 10, "Gödel" -> 20), Map("Church" -> 100, "Gentzen" -> 50), Map("Tarski" -> 50), Map("Banach" -> 15, "Gentzen" -> 35)))

  res0: Map[String, Seq[Int]] = Map(Genzten -> List(50, 35), Church -> List(100), Banach -> List(15), Tarski -> List(10, 50), Gödel -> List(20))

  Hint: use flatMap, groupBy, mapValues on dictionaries.

 */

val payments = (Seq(Map("Tarski" -> 10, "Gödel" -> 20), Map("Church" -> 100, "Gentzen" -> 50), Map("Tarski" -> 50), Map("Banach" -> 15, "Gentzen" -> 35)))

def amountsPerPerson[Person, Amount](data: Seq[Map[Person, Amount]]): Map[Person, Seq[Amount]] = {
  val b = data.flatten.groupBy(s => s._1)
  b.transform( (k,v) => v.map{case (x, y) => y})
}

val result =  amountsPerPerson(payments)

val expected: Map[String,Seq[Int]] = Map("Gentzen" -> List(50, 35), "Church" -> List(100), "Banach" -> List(15), "Gödel" -> List(20), "Tarski" -> List(10, 50))

assert(result == expected) 

// val a = (Seq(Map("Tarski" -> 10, "Gödel" -> 20), Map("Church" -> 100, "Gentzen" -> 50), Map("Tarski" -> 50), Map("Banach" -> 15, "Gentzen" -> 35)))

// val b = a.flatten.groupBy(s => s._1)
// // res7: scala.collection.immutable.Map[String,Seq[(String, Int)]] = Map(Gentzen -> List((Gentzen,50), (Gentzen,35)), Church -> List((Church,100)), Banach -> List((Banach,15)), Gödel -> List((Gödel,20)), Tarski -> List((Tarski,10), (Tarski,50)))

// val c =  b.transform( (k,v) => v.map{case (x, y) => y})
// // res64: scala.collection.immutable.Map[String,Seq[Int]] = Map(Gentzen -> List(50, 35), Church -> List(100), Banach -> List(15), Gödel -> List(20), Tarski -> List(10, 50))
