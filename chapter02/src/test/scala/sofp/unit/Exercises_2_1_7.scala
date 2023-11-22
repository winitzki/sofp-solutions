package sofp.unit

import com.eed3si9n.expecty.Expecty.expect
import munit.FunSuite

class Exercises_2_1_7 extends FunSuite {

  test("exercise 2.1.7.1") {

    val allPairs      =
      (0 to 9).flatMap { i =>
        (0 to 9).map { j =>
          (i, j)
        }
      }
    val filteredPairs = allPairs.filter { case (i, j) => i + 4 * j > i * j }

    expect(filteredPairs.take(4) == Seq((0, 1), (0, 2), (0, 3), (0, 4)))
    expect(filteredPairs.length == 64)
  }

}
