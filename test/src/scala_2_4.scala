

object scala_2_4 {
  def profit(price: Double): Double = (price * (120 + (15 - price) / 5 * 20)) - 500 - 3 * (120 + (15 - price) / 5 * 20)

}