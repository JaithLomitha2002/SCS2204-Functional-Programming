

object scala_3_2 {
  def filterStrings(strings: List[String]): List[String] = {
    strings.filter((string:String)=>string.length > 5)
  }

  def main(args: Array[String]): Unit = {
    val inputList = List("hello", "scs", "git", "functional", "programming")
    val filteredList = filterStrings(inputList)
    println(s"Original list: ${inputList}")
    println(s"Filtered list: ${filteredList}")
  }
}
