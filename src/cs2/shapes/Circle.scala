package cs2.shapes

import cs2.util.Vec2

class Circle(initSize:Vec2) extends Shape(initSize) {
  var shapename = "Circle"
  var r = size.x //radius
  override def area():Double ={
    math.Pi * math.pow(r, 2)
  }
  override def perimeter():Double = { //circumference
    2 * math.Pi * r
  }
}