class FractionSuite extends munit.FunSuite {
  test("can construct") {
    val fraction = Fraction(1, 2)
    assert(fraction != null)
  }
}
