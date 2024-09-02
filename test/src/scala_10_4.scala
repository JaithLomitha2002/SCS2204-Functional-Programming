

object scala_10_4 {
  class Account(val name: String, var balance: Double) {

    def deposit(amount: Double): Unit = {
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (amount <= balance) balance -= amount
      else println(s"$name: Insufficient funds")
    }
    
    def withdraw2(amount: Double): Unit = {
      balance -= amount
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

  class Bank(accounts: List[Account]) {

    def accountsWithNegativeBalances: List[Account] = {
      accounts.filter(_.balance < 0)
    }

    def totalBalance: Double = {
      accounts.map(_.balance).sum
    }

    def applyInterest(): Unit = {
      accounts.foreach { acc =>
        if (acc.balance > 0) {
          acc.deposit(acc.balance * 0.05)
        } else if (acc.balance < 0) {
          acc.withdraw2(-acc.balance * 0.1)
        }
      }
    }

    override def toString: String = accounts.mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    val acc1 = new Account("Account1", 1000)
    val acc2 = new Account("Account2", -200)
    val acc3 = new Account("Account3", 300)

    val bank = new Bank(List(acc1, acc2, acc3))

    println("Accounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(println)

    println(s"Total balance: $$${bank.totalBalance}")

    bank.applyInterest()

    println("Balances after applying interest:")
    println(bank)
  }
}