import scala.io.StdIn.readLine

object scala_5_1 {
  def getProductList(): List[String] = {
    var productList: List[String] = List()
    var input: String = ""

    println("Enter product names (type 'done' to finish):")

    while (input != "done") {
      input = readLine()
      if (input != "done") {
        productList = productList :+ input
      }
    }

    productList
  }

  def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach {
      case (product, index) => println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
  }
}