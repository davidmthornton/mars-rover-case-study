package code

import code.models.{Grid, North, Position, Rock, Rover, Sand}

import scala.util.Random

object Main extends App {

  def getDefaultGrid(): Grid = {
    Grid(Vector.tabulate(5,5)((_,_)=>Sand))
  }

  def buildGrid(rockPercentage: Int): Grid = {
    Grid(Vector.tabulate(5,5)((_,_)=>if(Random.between(1,100) == rockPercentage) Rock else Sand))
  }

  def defaultRover: Rover = {
    Rover(North, Position(0,0))
  }

  def gridWithRover(grid: Grid, rover: Rover): String = {
      grid.rows.zipWithIndex.map {
        case (vector, rowNum) => vector.zipWithIndex.map {
          case (terrain, colNum) => if(rover.position == Position(colNum, rowNum)) rover.toString else terrain.toString
        }.mkString("")
      }.mkString("\n")
    }
}
