

object scala_4_1 {
  
  var itemNames: Array[String] = Array("Apple", "Banana", "Papaya")
  var itemQuantities: Array[Int] = Array(10, 20, 15)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}\t:\t${itemQuantities(i)}")
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $itemName. New $itemName quantity: ${itemQuantities(index)}")
    } else {
      println(s"$itemName does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in stock to sell. Current $itemName quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"$itemName does not exist in the inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    //displayInventory()
    //restockItem("Apple", 5)
    //sellItem("Banana", 10)
    //sellItem("Papaya", 20)
    //sellItem("Grapes", 20)
    //restockItem("Grapes", 10)
    displayInventory()
  }
  
}