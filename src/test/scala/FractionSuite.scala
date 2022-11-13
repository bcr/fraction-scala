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
    val expected = "1"
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
}
