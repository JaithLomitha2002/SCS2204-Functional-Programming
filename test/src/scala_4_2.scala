

object scala_4_2 {
  
  def main(args: Array[String]): Unit = {
    args match {
      case Array(input) if input.forall(_.isDigit) || (input.startsWith("-") && input.tail.forall(_.isDigit)) =>
        val number = input.toInt
        number match {
          case n if n <= 0 =>
            println("Negative/Zero is input")
          case n if n % 2 == 0 =>
            println("Even number is given")
          case _ =>
            println("Odd number is given")
        }
      case _ =>
        println("Invalid Input !!!")
    }
  }
 
}
