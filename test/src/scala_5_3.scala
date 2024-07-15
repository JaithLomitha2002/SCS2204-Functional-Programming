import scala.io.StdIn.readInt

object scala_5_3 {
  def main(args: Array[String]): Unit = {
    println("Enter the number of Fibonacci numbers to print:")
    val n = readInt()
    println(s"The first $n Fibonacci numbers are:")
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }

  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
}