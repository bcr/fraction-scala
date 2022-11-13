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
}
