package calculator
import scala.math.sqrt

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal{
      (b()*b()) - (4*a()*c())
    }
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal{
      val delta_val = delta()
      if(delta_val<0) Set()
      else {
        val root1 = (-b() + sqrt(delta_val)) / (2*a())
        val root2 = (-b() - sqrt(delta_val)) / (2*a())
        (Set() + root1) + root2
      }
    }
  }
}
