package sofp.unit

import com.eed3si9n.expecty.Expecty.expect

import munit.FunSuite

class Exercises_1_6_1 extends FunSuite {

  test("Exercise 1.6.1.1") {

    def staggeredFactorial(n: Int): Int = (n to 1 by -2).product

    expect(staggeredFactorial(8) == 384)
    expect(staggeredFactorial(9) == 945)
  }

}
