object test {
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else
      0
  }
  /**
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(money: Int, coins: List[Int], paid: Int, acc: Int): Int = {
      println(money, coins, paid, acc)
      def payTop(money: Int, coin: Int): Boolean = {
        if ((money - coin) >= 0) true
        else false
      }

      if (money == 0) {
        if (coins.isEmpty) acc
        else {
          if(paid==0) 0
          else count(money + paid, coins.tail, 0, acc+1)
        }
      }
      else {
        if (coins.isEmpty) 0
        else {
          if (payTop(money, coins.head)) count(money - coins.head, coins, coins.head, acc)
          else count(money, coins.tail, 0, acc)
        }
      }
    }
    count(1, coins, 1, 0)
  }
  **/
  countChange(4, List(1, 2))

}