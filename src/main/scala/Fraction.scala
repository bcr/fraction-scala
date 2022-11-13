case class Fraction(numerator: Int, denominator: Int):
    def *(that: Fraction) = Fraction(this.numerator * that.numerator, this.denominator * that.denominator)
    def /(that: Fraction) = Fraction(this.numerator * that.denominator, this.denominator * that.numerator)

// https://docs.scala-lang.org/scala3/reference/contextual/extension-methods.html
extension (s: String)
    def toFraction: Fraction = {
        var whole = 0
        var remainder: String = s;
        val underscore_pieces = s.split('_')
        if (underscore_pieces.length > 1) {
            whole = underscore_pieces(0).toInt
            remainder = underscore_pieces(1)
        }
        val fraction_pieces = remainder.split('/')
        if (fraction_pieces.length > 1) {
            val numerator = fraction_pieces(0).toInt
            val denominator = fraction_pieces(1).toInt
            return Fraction(numerator + whole * denominator, denominator)
        }
        return Fraction(remainder.toInt, 1)
    }
