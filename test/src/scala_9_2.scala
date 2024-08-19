

object scala_9_2 {
  def main(args: Array[String]): Unit = {

    val isValidInteger: String => Boolean = input => 
      input.forall(_.isDigit) || (input.startsWith("-") && input.tail.forall(_.isDigit))

    val classifyNumber: Int => String = number => number match {
      case n if n <= 0 => "Negative/Zero is input"
      case n if n % 2 == 0 => "Even number is given"
      case _ => "Odd number is given"
    }

    args match {
      case Array(input) if isValidInteger(input) =>
        val number = input.toInt
        println(s"$number\t: ${classifyNumber(number)}")
      case _ =>
        println("Invalid Input !!!")
    }
  }
}
