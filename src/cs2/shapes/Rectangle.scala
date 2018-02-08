package cs2.shapes

import cs2.util.Vec2

class Rectangle(initSize:Vec2) extends Shape(initSize) {
  var shapename = "Rectangle"
  var point = size.x
  var point2 = size.y
  var point3:Vec2 = size.x-size.y
  
  override def area():Double = {
    if((point != Double) && (point2 != Double)) {
      point3.x * point3.y
    }
    else {
      point * point2
      }
  }
  override def perimeter():Double = {
    if((point != Double) && (point2 != Double)) {
      point3.x * 2 + point3.y * 2
    }
    else {
      point * 2 + point2 * 2
    }
  }
}