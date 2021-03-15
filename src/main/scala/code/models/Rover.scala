package code.models

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment

case class Rover(direction: Direction, position: Position) {
//  def move(direction: Direction)

  sealed trait Error
  case object WillFallOffPlanet extends Error
  case object WillHitRock extends Error
  case object Unknown extends Error

  override def toString: String = {
    direction.toString
  }

  def processCommand(command:Rover.Command, grid:Grid):Either[Error, Rover] = {
    (command,grid) match {
      case (Rover.Left, _) => Right(this.copy(direction = this.direction.leftOf))
      case (Rover.Right, _) => Right(this.copy(direction = this.direction.rightOf))
      case _ => Left(Unknown)
    }
  }

}
object Rover {
  sealed trait Command
  case object Left extends Command
  case object Right extends Command
  case object Forward extends Command
  case object Backward extends Command
}