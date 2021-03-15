package code

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MainSpec extends AnyWordSpec with Matchers {
  "getdefaultGrid" should {
    "be a 5x5 grid of Sand" in {
      Main.getDefaultGrid().toString() shouldBe ("""|.....
        |.....
        |.....
        |.....
        |.....""").stripMargin
    }
  }
}
