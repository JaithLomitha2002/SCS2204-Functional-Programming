object scala_10_5 {

  def countLetterOccurrences(words: List[String]): Int = {
    
    val lengths = words.map(word => word.length)

    val totalCount = lengths.reduce((a, b) => a + b)

    totalCount
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    
    val totalLetterCount = countLetterOccurrences(words)
    
    println(s"Total count of letter occurrences: $totalLetterCount")
  }
}