package code

import code.models.{Grid, Position, Sand}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.util.{Failure, Success}

class GridSpec extends AnyWordSpec with Matchers {

  val testGrid: Grid = Main.getDefaultGrid()

  "getTerrain" should {
    "return a Terrain from the grid if the supplied position exists" in {
      testGrid.getTerrain(Position(0, 0)) shouldBe Success(Sand)
    }

    "return a Failure from the grid if the supplied position does not exist" in {
      testGrid.getTerrain(Position(5, 5)) shouldBe an[Failure[_]]
    }
  }
}