import scala.io.StdIn.readLine

@main def hello: Unit = 
  var running = true
  while (running)
    print("? ")
    val input = readLine()
    if (input.length() > 0)
      println(s"= ${input.evaluateFractionExpression}")
    else
      running = false
