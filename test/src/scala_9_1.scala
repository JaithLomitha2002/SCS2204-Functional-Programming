

object scala_9_1 {
  
  def main(args: Array[String]): Unit = {
 
    val calculateInterest: Double => Double = depositAmount => depositAmount match {
      case amount if amount <= 20000 => amount * 0.02
      case amount if amount <= 200000 => amount * 0.04
      case amount if amount <= 2000000 => amount * 0.035
      case amount if amount > 2000000 => amount * 0.065
    }


    val deposit1 = 15000.0
    val deposit2 = 50000.0
    val deposit3 = 1800000.0
    val deposit4 = 3000000.0

    println(s"Interest for deposit $deposit1\t: ${calculateInterest(deposit1)}")
    println(s"Interest for deposit $deposit2\t: ${calculateInterest(deposit2)}")
    println(s"Interest for deposit $deposit3\t: ${calculateInterest(deposit3)}")
    println(s"Interest for deposit $deposit4\t: ${calculateInterest(deposit4)}")
  }
}