package code


object Main extends App {

  sealed trait Terrain
  case object Sand extends Terrain {
    override def toString() = {"."}
  }
  case object Rock extends Terrain {
    override def toString() = {"O"}
  }

  case class Grid(rows:Vector[Vector[Terrain]]) {
    override def toString() = {
      rows.map(_.mkString).mkString("\n")
    }
  }


  def getDefaultGrid():Grid = {
    Grid(Vector.tabulate(5,5)((_,_)=>Sand))
  }

}
