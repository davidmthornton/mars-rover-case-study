package code.models

case class Rover(direction: Direction, position: Position) {
//  def move(direction: Direction)

  override def toString: String = {
    direction.toString
  }
}