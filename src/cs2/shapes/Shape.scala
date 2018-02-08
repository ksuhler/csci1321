package cs2.shapes

import cs2.util.Vec2

abstract class Shape() {
  
  def area():Double 
  def perimeter():Double 
  def toString():String 
}

/** Include the classes for Circle, Rectangle, and Square here in this file **/
/**------------------------------------------------------------------------**/
/**Square**/
class Square(var circle:Double) extends Shape() {
  var side = circle
  override def area():Double = { side * side }
  override def perimeter():Double = { side * 4 }
  override def toString():String ={ "Square" }
}
/**Circle**/
class Circle(val r:Double) extends Shape() {
  override def area():Double ={ math.Pi * math.pow(r, 2) }
  override def perimeter():Double = {  2 * math.Pi * r }
  override def toString():String = { "circle" }
}

/**Rectangle**/
class Rectangle(var w:Double, var h:Double) extends Shape() {
  def this(wid:Vec2, hig:Vec2) = {  
    this(hig.x-wid.x, hig.y-wid.y)  }
 
  override def area():Double = { 
    if(w < 0) { w = w * -1}
    if(h < 0) { h = h * -1}
    w * h
  }
  override def perimeter():Double = { w * 2 + h * 2 }
  override def toString():String = { "Rectangle" }
}
/**------------------------------------------------------------------------**/
/** Shape Tester**/

object ShapeTester {
  def main(args:Array[String]) {
    var shapeList = List[Shape]()
    shapeList = new Circle(1.5) :: shapeList
    shapeList = new Circle(5) :: shapeList
    shapeList = new Rectangle(100,200) :: shapeList
    shapeList = new Rectangle(new Vec2(0,0), new Vec2(150,20)) :: shapeList
    shapeList = new Rectangle(new Vec2(100,100), new Vec2(50,200)) :: shapeList
    shapeList = new Square(30) :: shapeList
    
    shapeList.foreach { x => println(x + " Area: " + x.area) }
    shapeList.foreach { x => println(x + " Perimeter: " + x.perimeter) }
  }
}
