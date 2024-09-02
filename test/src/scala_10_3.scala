

object scala_10_3 {
  class Account(val name: String, var balance: Double) {

    def deposit(amount: Double): Unit = {
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (amount <= balance) balance -= amount
      else println(s"$name: Insufficient funds")
    }

    def transfer(to: Account, amount: Double): Unit = {
      if (amount <= balance) {
        withdraw(amount)
        to.deposit(amount)
        println(s"Transfer successful! $$${amount} transferred from ${name} to ${to.name}.")
        println(s"New balances: ${name} - $$${balance}, ${to.name} - $$${to.balance}")
      } else {
        println(s"$name: Insufficient funds for transfer")
      }
    }

    override def toString: String = s"$name: Balance: $$${balance}"
  }

  def main(args: Array[String]): Unit = {
    val acc1 = new Account("Account1", 1000)
    val acc2 = new Account("Account2", 500)
    
    println(acc1)
    println(acc2)
    
    acc1.transfer(acc2, 200)
    
    println(acc1)
    println(acc2) 
  }
}