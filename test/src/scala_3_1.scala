

object scala_3_1 {
  def reverseString(str: String): String = {
    if (str.isEmpty) ""
    else reverseString(str.tail) + str.head
  }

  def main(args: Array[String]): Unit = {
    val inputString = "scala"
    val reversedString = reverseString(inputString)
    println(s"Original string: $inputString")
    println(s"Reversed string: $reversedString")
  }
}
