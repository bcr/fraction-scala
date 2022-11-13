class FractionSuite extends munit.FunSuite {
  test("can construct") {
    val fraction = Fraction(1, 2)
    assert(fraction != null)
  }

  test("toFraction String extension method whole number") {
    val obtained = "1".toFraction
    val expected = Fraction(1, 1)
    assertEquals(obtained, expected)
  }

  test("toFraction String extension method fraction only") {
    val obtained = "1/2".toFraction
    val expected = Fraction(1, 2)
    assertEquals(obtained, expected)
  }

  test("toFraction String extension method mixed number") {
    val obtained = "3_3/4".toFraction
    val expected = Fraction(15, 4)
    assertEquals(obtained, expected)
  }

  test("can multiply") {
    val a = Fraction(1, 2)
    val b = Fraction(3, 4)
    val expected = Fraction(3, 8)
    val obtained = a * b
    assertEquals(obtained, expected)
  }

  test("can divide") {
    val a = Fraction(1, 2)
    val b = Fraction(3, 4)
    val expected = Fraction(4, 6)
    val obtained = a / b
    assertEquals(obtained, expected)
  }

  test("can add") {
    val a = Fraction(1, 2)
    val b = Fraction(3, 4)
    val expected = Fraction(10, 8)
    val obtained = a + b
    assertEquals(obtained, expected)
  }

  test("can subtract") {
    val a = Fraction(1, 2)
    val b = Fraction(3, 4)
    val expected = Fraction(-2, 8)
    val obtained = a - b
    assertEquals(obtained, expected)
  }

  test("can reduce") {
    val a = Fraction(2, 4)
    val expected = Fraction(1, 2)
    val obtained = a.reduce()
    assertEquals(obtained, expected)
  }

  test("toMixedNumberString whole number") {
    val expected = "2"
    val a = expected.toFraction
    val obtained = a.toMixedNumberString
    assertEquals(obtained, expected)
  }

  test("toMixedNumberString fraction only") {
    val expected = "1/2"
    val a = expected.toFraction
    val obtained = a.toMixedNumberString
    assertEquals(obtained, expected)
  }

  test("toMixedNumberString mixed number") {
    val expected = "1_7/8"
    val a = expected.toFraction
    val obtained = a.toMixedNumberString
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression works with addition") {
    val expression = "1 + 1"
    val expected = "2"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression works with subtraction") {
    val expression = "1 - 1"
    val expected = "0"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression works with multiplication") {
    val expression = "3 * 9"
    val expected = "27"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression works with division") {
    val expression = "27 / 3"
    val expected = "9"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("given example #1 works") {
    val expression = "1/2 * 3_3/4"
    val expected = "1_7/8"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("given example #2 works") {
    val expression = "2_3/8 + 9/8"
    val expected = "3_1/2"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  // Operands and operators shall be separated by one or more spaces.
  test("more than one space") {
    val expression = "1/2    *    3_3/4"
    val expected = "1_7/8"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression handles illegal operators") {
    val expression = "27 x 3"
    val expected = "Unknown operator \"x\""
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression handles division by zero") {
    val expression = "1 / 0"
    val expected = "/ by zero"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression handles wrong number of arguments") {
    val expression = ""
    val expected = "Illegal input - expected operand operator operand"
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression handles bad first operand") {
    val expression = "mouse * 3"
    val expected = "Illegal operand For input string: \"mouse\""
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }

  test("evaluateFractionExpression handles bad second operand") {
    val expression = "3 * cat"
    val expected = "Illegal operand For input string: \"cat\""
    val obtained = expression.evaluateFractionExpression
    assertEquals(obtained, expected)
  }
}
