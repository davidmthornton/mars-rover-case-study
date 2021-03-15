package code.models

sealed trait Direction {
  def leftOf:Direction
  def rightOf:Direction
}

case object North extends Direction {
  override def toString() = {"^"}
  override def leftOf = West
  override def rightOf = East
}

case object East extends Direction {
  override def toString() = {">"}
  override def leftOf = North
  override def rightOf = South
}

case object South extends Direction {
  override def toString() = {"V"}
  override def leftOf = East
  override def rightOf = West
}

case object West extends Direction {
  override def toString() = {"<"}
  override def leftOf = South
  override def rightOf = North
}