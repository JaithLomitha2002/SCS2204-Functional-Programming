

object scala_10_2 {

  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be non-zero!!!")
    
    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def neg: Rational = new Rational(-numer, denom)

    def +(that: Rational): Rational = 
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    
    def -(that: Rational): Rational = 
      this + that.neg

    override def toString: String = s"$numer/$denom"

    private def gcd(a: Int, b: Int): Int = 
      if (b == 0) a else gcd(b, a % b)
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)
    
    val result = x - y - z
    println(s"$x - $y - $z = $result")
  }
}