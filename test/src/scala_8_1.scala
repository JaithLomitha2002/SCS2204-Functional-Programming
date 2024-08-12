

object scala_8_1 {

  def encrypt(text: String, shift: Int): String = {
    text.map {
      case c if c.isUpper =>
        ((c - 'A' + shift) % 26 + 'A').toChar
      case c if c.isLower =>
        ((c - 'a' + shift) % 26 + 'a').toChar
      case c => c
    }
  }

  def decrypt(text: String, shift: Int): String = {
    text.map {
      case c if c.isUpper =>
        ((c - 'A' - shift + 26) % 26 + 'A').toChar
      case c if c.isLower =>
        ((c - 'a' - shift + 26) % 26 + 'a').toChar
      case c => c
    }
  }

  def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val text = "Lomitha"
    val shift = 3

    val encryptedText = cipher(text, shift, encrypt)
    println(s"Encrypted: $encryptedText")

    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted: $decryptedText")
  }
}