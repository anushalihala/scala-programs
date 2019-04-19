package reductions

import scala.annotation._
import org.scalameter._
import common._

object ParallelParenthesesBalancingRunner {

  @volatile var seqResult = false

  @volatile var parResult = false

  val standardConfig = config(
    Key.exec.minWarmupRuns -> 40,
    Key.exec.maxWarmupRuns -> 80,
    Key.exec.benchRuns -> 120,
    Key.verbose -> true
  ) withWarmer(new Warmer.Default)

  def main(args: Array[String]): Unit = {
    val length = 100000000
    val chars = new Array[Char](length)
    val threshold = 10000
//    val seqtime = standardConfig measure {
//      seqResult = ParallelParenthesesBalancing.balance(chars)
//    }
//    println(s"sequential result = $seqResult")
//    println(s"sequential balancing time: $seqtime ms")
//
//    val fjtime = standardConfig measure {
//      parResult = ParallelParenthesesBalancing.parBalance(chars, threshold)
//    }
//    println(s"parallel result = $parResult")
//    println(s"parallel balancing time: $fjtime ms")
//    println(s"speedup: ${seqtime / fjtime}")
    println(ParallelParenthesesBalancing.parBalance("()".toCharArray, threshold=1))
  }
}

object ParallelParenthesesBalancing {

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def balance(chars: Array[Char]): Boolean = {
    def balanceHelper(idx:Int, acc:Int): Boolean ={
      if(acc<0) false
      else if(idx >= chars.length) acc==0
      else if(chars(idx)=='(') balanceHelper(idx+1, acc+1)
      else if(chars(idx)==')') balanceHelper(idx+1, acc-1)
      else balanceHelper(idx+1, acc)
    }
    balanceHelper(0, 0)
  }

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def parBalance(chars: Array[Char], threshold: Int): Boolean = {

    def traverse(idx: Int, until: Int, left_braces: Int, right_braces: Int): (Int, Int) /*: ???*/ = {
      if(idx>=until) (left_braces, right_braces)
      else {
        if(chars(idx)==')') {
          if(left_braces>0) traverse(idx+1, until, left_braces - 1, right_braces)
          else traverse(idx+1, until, left_braces, right_braces + 1)
        }
        else if(chars(idx)=='(') traverse(idx+1, until, left_braces + 1, right_braces)
        else traverse(idx+1, until, left_braces, right_braces)
      }
    }

    def reduce(from: Int, until: Int): (Int, Int) /*: ???*/ = {
      if(until-from <= threshold){
        traverse(from, until, 0, 0)
      }
      else {
        val mid = (from + until)/2
        var ((lb1,rb1), (lb2,rb2)) = parallel(reduce(from, mid), reduce(mid, until))
        if(lb1>rb2) lb2 += lb1-rb2
        else if(lb1<rb2) rb1 += rb2-lb1
        (lb2, rb1)
      }
    }

    reduce(0, chars.length) == (0,0)
  }

  // For those who want more:
  // Prove that your reduction operator is associative!

}
