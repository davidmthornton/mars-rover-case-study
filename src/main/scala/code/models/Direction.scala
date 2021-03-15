package code.models

sealed trait Direction

case object North extends Direction {
  override def toString() = {"^"}
}

case object East extends Direction {
  override def toString() = {">"}
}

case object South extends Direction {
  override def toString() = {"V"}
}

case object West extends Direction {
  override def toString() = {"<"}
}