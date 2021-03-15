package code.models

import code.models.Rover.Command

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment
import scala.util.Try

case class Rover(direction: Direction, position: Position) {

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
      case (Rover.Forward, _) => move(position, Rover.Forward, grid)
      case _ => Left(Unknown)
    }
  }

  def move(startPosition: Position, direction: Command, grid: Grid): Either[Error, Rover] = {
    val newPosition: Position = startPosition.(direction)
    val newTerrain: Try[Terrain] = grid.getTerrain(startPosition)

    if(newTerrain.isSuccess) Right(this.copy(position = newPosition)) else Left(WillFallOffPlanet)
  }

}

object Rover {
  sealed trait Command
  case object Left extends Command
  case object Right extends Command
  case object Forward extends Command
  case object Backward extends Command
}