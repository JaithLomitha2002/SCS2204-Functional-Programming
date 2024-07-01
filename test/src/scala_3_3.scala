

object scala_3_3 {
  def calMean(num1: Int, num2: Int): Double = {
    val mean = (num1 + num2) / 2
    BigDecimal(mean).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def main(args: Array[String]): Unit = {
    val num1 = 5
    val num2 = 15
    val result = calMean(num1, num2)
    println(f"Mean of ${num1} & ${num2}: ${result}")
  }
}
