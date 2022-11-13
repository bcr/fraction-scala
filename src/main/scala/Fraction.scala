private def gcf(a: Int, b: Int) : Int =
    var temp = 0
    var num1 = a
    var num2 = b

    while(num2 != 0)
        temp = num1 % num2
        num1 = num2
        num2 = temp

    return num1

case class Fraction(numerator: Int, denominator: Int):
    def *(that: Fraction) = Fraction(this.numerator * that.numerator, this.denominator * that.denominator)
    def /(that: Fraction) = Fraction(this.numerator * that.denominator, this.denominator * that.numerator)
    def +(that: Fraction) = Fraction(this.numerator * that.denominator + this.denominator * that.numerator, this.denominator * that.denominator)
    def -(that: Fraction) = Fraction(this.numerator * that.denominator - this.denominator * that.numerator, this.denominator * that.denominator)

    def reduce() : Fraction =
        val this_gcf = gcf(numerator, denominator)
        Fraction(numerator / this_gcf, denominator / this_gcf)

    def toMixedNumberString: String =
        if (denominator == 1)
            return s"${numerator / denominator}"
        if (numerator > denominator)
            val output_whole = numerator / denominator
            val output_numerator = numerator % denominator
            return s"${output_whole}_${output_numerator}/${denominator}"
        else
            return s"${numerator}/${denominator}"

// https://docs.scala-lang.org/scala3/reference/contextual/extension-methods.html
extension (s: String)
    def toFraction: Fraction =
        val negative = (s.charAt(0) == '-')
        var whole = 0
        var remainder: String = s;
        val underscore_pieces = s.split('_')

        if (underscore_pieces.length > 1)
            whole = underscore_pieces(0).toInt * (if (negative) -1 else 1)
            remainder = underscore_pieces(1)

        val fraction_pieces = remainder.split('/')

        if (fraction_pieces.length > 1)
            val numerator = fraction_pieces(0).toInt * (if ((whole == 0) && negative) -1 else 1)
            val denominator = fraction_pieces(1).toInt
            return Fraction((numerator + whole * denominator) * (if (negative) -1 else +1), denominator)

        return Fraction(remainder.toInt, 1)

    def evaluateFractionExpression: String =
        val components = s.split("\\s+")

        if (components.length < 3)
            return "Illegal input - expected operand operator operand"

        try
            val a = components(0).toFraction
            val operator = components(1)
            val b = components(2).toFraction

            var result = operator match
                case "+" => a + b
                case "-" => a - b
                case "*" => a * b
                case "/" => a / b
                case _   => throw new IllegalArgumentException(s"Unknown operator \"${operator}\"")

            result.reduce().toMixedNumberString
        catch
            case e: NumberFormatException => return s"Illegal operand ${e.getMessage()}"
            case e: IllegalArgumentException => return e.getMessage()
            case e: ArithmeticException => return e.getMessage()
