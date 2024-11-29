/** 
  Exercise 2.5.2.7
  Reverse a sentence’s word order, but keep the words unchanged:

  def revSentence(s: String): String = ???

  scala> revSentence("A quick brown fox") // Words are separated by one space.

  res0: String = "fox brown quick A"
 */

def revSentence(s: String): String = {
  s.split(' ').reverse.mkString(" ")
}

val result =  revSentence("A quick brown fox")
val expected: String = "fox brown quick A" 
assert(result == expected)

// scala> :load solution2.5.2.7.scala
// :load solution2.5.2.7.scala
// def revSentence(s: String): String
// val result: String = fox brown quick A
// val expected: String = fox brown quick A
