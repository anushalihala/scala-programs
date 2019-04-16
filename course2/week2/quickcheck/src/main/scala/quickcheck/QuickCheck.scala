package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = oneOf(
    const(empty),
    for {
      v <- arbitrary[Int]
      h <- oneOf(const(empty), genHeap)
    } yield insert(v, h)
  )

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  lazy val genHeap2: Gen[H] =
    for {
      v1 <- arbitrary[Int]
      v2 <- arbitrary[Int]
      h <- oneOf(const(empty), genHeap)
    } yield insert(v2, insert(v1, h))


  def checkOrder(h: H, prev: A): Boolean = {
    if(isEmpty(h)) true
    else {
      val curr = findMin(h)
      if (prev <= curr) checkOrder(deleteMin(h), curr)
      else false
    }
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("insert 2 and get min") = forAll { (m: Int, n:Int) =>
    val min_val = if (m<n) m else n
    findMin(insert(n, insert(m, empty))) == min_val
  }

  property("insert followed by delete on empty gives empty") = forAll { (m: Int) =>
    isEmpty(deleteMin(insert(m, empty)))
  }

  property("get sorted sequence") = forAll (genHeap2){ (h: H) => {
      checkOrder(h, findMin(h))
    }
  }

  property("minimum of melding") = forAll { (h1:H, h2:H) => (!(isEmpty(h1) && isEmpty(h2))) ==> {
      val meld_min = findMin(meld(h1, h2))
      if (isEmpty(h1)) meld_min == findMin(h2)
      else if (isEmpty(h2)) meld_min == findMin(h1)
      else {
        val min_of_both = if (findMin(h1) < findMin(h2)) findMin(h1) else findMin(h2)
        meld_min == min_of_both
      }
    }
  }

  property("ordered after delete") = forAll (genHeap2){ (h: H) =>  {
      val heap_after_delete = deleteMin(h)
      if (isEmpty(heap_after_delete)) true
      else checkOrder(heap_after_delete, findMin(heap_after_delete))
    }
  }

  property("meld does not lose elements") = forAll { (m: Int) => {
      val melded_heap = meld(insert(m, empty), empty)
      !isEmpty((melded_heap))
    }
  }

  property("ordered after meld") = forAll { (h1: H, h2: H) => (!(isEmpty(h1) && isEmpty(h2))) ==> {
      val melded_heap = meld(h1, h2)
      checkOrder(melded_heap, findMin(melded_heap))
    }
  }

  property("meld complete check") = forAll { (h1: H, h2: H) =>  {
      def helper(h: H): List[A] ={
        if(isEmpty(h)) List()
        else findMin(h) :: helper(deleteMin(h))
      }
      val melded_heap = meld(h1, h2)
      helper(melded_heap) == (helper(h1) ::: helper(h2)).sorted
    }
  }
}
