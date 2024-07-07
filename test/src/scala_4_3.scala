

object scala_4_3 {
  
  def toUpper(name: String): String = {
    name.toUpperCase()
  }

  def toLower(name: String): String = {
    name.toLowerCase()
  }

  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }
  
  def formatNames2(str: String): String = {
    if (str.length >= 2) {
      str.take(2).toUpperCase + str.drop(2).toLowerCase
    } else {
      str.toUpperCase // Handle cases where string length is less than 2
    }
  }
  
  def formatNames3(str: String): String = {
  if (str.length >= 2) {
    str.dropRight(1) + str.last.toUpper
  } else {
    str.toUpperCase
  }
}

  
  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    val formattedNames = names.map {
      case "Benny" => formatNames("Benny")(toUpper)
      case "Niroshan" => formatNames("Niroshan")(formatNames2)
      case "Saman" => formatNames("Saman")(toLower)
      case "Kumara" =>formatNames("Kumara")(formatNames3)
      case other => other
    }

    formattedNames.foreach(println)
  }

  
}