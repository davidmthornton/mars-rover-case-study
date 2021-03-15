package code.models

import scala.util.Try

case class Grid(rows:Vector[Vector[Terrain]]) {

  override def toString(): String = {
    rows.map(_.mkString).mkString("\n")
  }

  def getTerrain(position: Position): Try[Terrain] = {
    Try {
      rows(position.row)(position.column)
    }
  }
}
