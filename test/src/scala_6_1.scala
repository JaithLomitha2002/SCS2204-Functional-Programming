

object scala_6_1 {

  case class Product(id: Int, name: String, quantity: Int, price: Double)

  val inventory1: Map[Int, Product] = Map(
    101 -> Product(101, "Apple", 50, 0.5),
    102 -> Product(102, "Banana", 30, 0.2),
    103 -> Product(103, "Orange", 20, 0.8)
  )

  val inventory2: Map[Int, Product] = Map(
    102 -> Product(102, "Banana", 25, 0.25),
    104 -> Product(104, "Mango", 10, 1.5)
  )

  def retrieveProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    (inventory1.keySet ++ inventory2.keySet).map { id =>
      val product1 = inventory1.get(id)
      val product2 = inventory2.get(id)

      val mergedProduct = (product1, product2) match {
        case (Some(p1), Some(p2)) =>
          Product(id, p1.name, p1.quantity + p2.quantity, math.max(p1.price, p2.price))
        case (Some(p1), None) =>
          p1
        case (None, Some(p2)) =>
          p2
        case _ => throw new Exception("Unexpected case")
      }
      id -> mergedProduct
    }.toMap
  }

  def checkAndPrintProduct(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) => println(s"Product found\t\t\t: $product")
      case None => println(s"Product with ID $productId not found.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Product Names in Inventory1\t: " + retrieveProductNames(inventory1).mkString(", "))

    println("Total Value of Inventory1\t: $" + calculateTotalValue(inventory1))

    println("Is Inventory1 Empty?\t\t: " + isInventoryEmpty(inventory1))

    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged Inventory\t\t: " + mergedInventory.values.mkString(", "))

    checkAndPrintProduct(inventory1, 102)
  }

}