package code.models

case class Position(column: Int, row: Int) {

  def rotate(direction: Direction): Position = {
    direction match {
      case North => this.copy(row = this.row - 1)
      case East => this.copy(column = this.column + 1)
      case South => this.copy(row = this.row + 1)
      case West => this.copy(column = this.column - 1)
    }
  }

}