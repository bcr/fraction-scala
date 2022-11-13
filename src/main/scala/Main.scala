import scala.io.StdIn.readLine

@main def hello: Unit = 
  while (true)
    print("? ")
    val input = readLine()
    println(s"= ${input.evaluateFractionExpression}")
