import patmat.Huffman._

object debugcode{
  def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    def decodeHelper(tree: CodeTree, bits: List[Bit], originalTree: CodeTree): List[Char] = {
      println(tree.toString)
      println(bits.toString)
      println(originalTree.toString)
      println("NEXT")
      if (bits.isEmpty) List()
      else tree match {
        case Leaf(c, w) => List(c) ::: {
          if(bits.isEmpty) List()
          else decodeHelper(originalTree, bits, originalTree)
        }
        case Fork(l, r, _, _) => if (bits.head == 0) decodeHelper(l, bits.tail, originalTree) else decodeHelper(r, bits.tail, originalTree)
      }
    }
    decodeHelper(tree, bits, tree)
  }
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
  decode(t1, List(0,1))
}