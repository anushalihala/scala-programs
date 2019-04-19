package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def factorial(n: Int) = {
        def fact(acc: Int, n: Int): Int = {
          if (n == 0) acc
          else fact(acc * n, n - 1)
        }
        fact(1,n)
      }
      factorial(r)/(factorial(c) * factorial(r-c))
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceHelper(chars:List[Char], acc:Int): Boolean ={
        if(acc<0) false
        else if(chars.isEmpty) acc==0
        else if(chars.head=='(') balanceHelper(chars.tail, acc+1)
        else if(chars.head==')') balanceHelper(chars.tail, acc-1)
        else balanceHelper(chars.tail, acc)
      }
      balanceHelper(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0)
        1
      else if(money > 0 && !coins.isEmpty)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else
        0
    }

  }
