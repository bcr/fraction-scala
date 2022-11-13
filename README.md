# Fractions in Scala

```
Write a command line program in the language of your choice that will take operations on fractions as an input and produce a fractional result.

Legal operators shall be *, /, +, - (multiply, divide, add, subtract).

Operands and operators shall be separated by one or more spaces.

Mixed numbers will be represented by whole_numerator/denominator. e.g. "3_1/4".

Improper fractions and whole numbers are also allowed as operands.

Example run
? 1/2 * 3_3/4
= 1_7/8

? 2_3/8 + 9/8
= 3_1/2
```

## Somewhat Tricky Things

* I added two extension methods to the `String` class in `Fraction.scala`
  - `toFraction` converts a string to a `Fraction`
  - `evaluateFractionExpression` will evaluate an expression and return a `String` result
* Illegal input handling isn't very nice
  - Non-compliant operands
* Negative numbers are probably a mess

## sbt project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).
