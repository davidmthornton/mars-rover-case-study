package code

import code.models.{East, North, Rover, West}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RoverSpec extends AnyWordSpec with Matchers {

  "rover processCommand" should {
    "show turn the rover 360 degrees when moved Left 4 times" in {
      val grid = Main.getDefaultGrid()
      val eitherRover = Main.defaultRover.processCommand(Rover.Left, grid)
      eitherRover shouldBe Right(Main.defaultRover.copy(direction = West))
      for {
        rover <- eitherRover
        rover2 <- rover.processCommand(Rover.Left, grid)
        rover3 <- rover2.processCommand(Rover.Left, grid)
        rover4 <- rover3.processCommand(Rover.Left, grid)
      } yield {
        rover4.direction shouldBe North
      }
    }

    "show turn the rover 360 degrees when moved Right 4 times" in {
      val grid = Main.getDefaultGrid()
      val eitherRover = Main.defaultRover.processCommand(Rover.Right, grid)
      eitherRover shouldBe Right(Main.defaultRover.copy(direction = East))
      for {
        rover <- eitherRover
        rover2 <- rover.processCommand(Rover.Right, grid)
        rover3 <- rover2.processCommand(Rover.Right, grid)
        rover4 <- rover3.processCommand(Rover.Right, grid)
      } yield {
        rover4.direction shouldBe North
      }
    }

  }
}
