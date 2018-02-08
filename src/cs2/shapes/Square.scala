package cs2.shapes

import cs2.util.Vec2

class Square(initSize:Vec2) extends Shape(initSize) {
  var shapename = "Square"
  var side = size.x
  override def area():Double = {
    side * side
  }
  override def perimeter():Double = {
    side * 4
  }
}