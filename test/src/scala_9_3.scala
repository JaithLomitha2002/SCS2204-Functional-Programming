

object scala_9_3 {

  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    val toUpper: String => String = _.toUpperCase()
    val toLower: String => String = _.toLowerCase()
    
    val formatNames2: String => String = str => {
      if (str.length >= 2) {
        str.take(1) + str.take(2).tail.toUpperCase + str.drop(2).toLowerCase
      } else {
        str.toUpperCase
      }
    }
    
    val formatNames3: String => String = str => {
      if (str.length >= 2) {
        str.dropRight(1) + str.last.toUpper
      } else {
        str.toUpperCase
      }
    }

    val formattedNames = names.map {
      case "Benny" => formatNames("Benny")(toUpper)
      case "Niroshan" => formatNames("Niroshan")(formatNames2)
      case "Saman" => formatNames("Saman")(toLower)
      case "Kumara" => formatNames("Kumara")(formatNames3)
      case other => other
    }

    formattedNames.foreach(println)
  }
}