package code.models

sealed trait Terrain

case object Sand extends Terrain {
  override def toString() = {"."}
}

case object Rock extends Terrain {
  override def toString() = {"O"}
}