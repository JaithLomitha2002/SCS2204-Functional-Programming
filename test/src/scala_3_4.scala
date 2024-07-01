

object scala_3_4 {
  def sumEvenNumbers(numbers: List[Int]): Int = {
    numbers.filter((number: Int) => number % 2 == 0).sum
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val sumOfEvens = sumEvenNumbers(numbers)
    println(s"Sum of even numbers ${numbers}: ${sumOfEvens}")
  }
}
