import streams.GameDef

object debugprog{
  val level =
    """ST
      |oo
      |oo""".stripMargin

  val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)

  class Pos(val row:Int, val col:Int){

  }

  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = pos => {
    if(levelVector.length <= pos.row) false
    else if(levelVector(pos.row).length <= pos.col) false
    else {
      val pos_ch = levelVector(pos.row)(pos.col)
      pos_ch!='-'
    }
  }

  for{
    i <- 0 to 4
    j <- 0 to 5
  } yield ((i,j), terrainFunction(vector)(new Pos(i,j)))

  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val temp = (for {
      i <- 0 until levelVector.length
      j = levelVector(i).indexOf(c)
      if j >= 0
    } yield new Pos(i, j))
    temp.head
  }

  val p = findChar('S', vector)
  println(p.row,p.col)
}