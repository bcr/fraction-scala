case class Fraction(numerator: Int, denominator: Int)

// https://docs.scala-lang.org/scala3/reference/contextual/extension-methods.html
extension (s: String)
    def toFraction: Fraction = {
        return Fraction(s.toInt, 1)
    }
