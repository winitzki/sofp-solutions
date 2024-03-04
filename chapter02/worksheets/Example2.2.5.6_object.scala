/** 
Example 2.2.5.6

Implement a function toPairs that converts a sequence of type
Seq[A] to a sequence of pairs, Seq[(A, A)], by putting together the adjacent elements pairwise. If the initial sequence has an odd number of elements, a given
default value of type A is used to fill the last pair. The required type signature and
an example test:
  */

object ToPairsObject {
  def toPairs[A](xs: Seq[A], default: A): Seq[(A, A)] = {
    type Acc = (Seq[(A, A)], Seq[A])

    // Type alias, for brevity.
    def init: Acc = (Seq(), Seq())

    def updater(acc: Acc, x: A): Acc = acc match {
      case (result, Seq())
      => (result, Seq(x))
      case (result, Seq(prev)) => (result :+ ((prev, x)), Seq())

    }

    val (result, holdover) = xs.foldLeft(init)(updater)
    holdover match {
      // May need to append the last element to the result.
      case Seq()
      => result
      case Seq(x)
      => result :+ ((x, default))
    }
  }
}

val a = ToPairsObject.toPairs(Seq(1, 2, 3), 4)
println("a: %s".format(a))

// scala> :load Example2.2.5.6_object.scala
// :load Example2.2.5.6_object.scala
// a: List((1,2), (3,4))
// // defined object ToPairsObject
// val a: Seq[(Int, Int)] = List((1,2), (3,4))
