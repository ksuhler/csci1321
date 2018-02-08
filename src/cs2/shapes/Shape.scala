package cs2.shapes

import cs2.util.Vec2

abstract class Shape(protected var size:Vec2) {
  protected var shapename:String = "name"
  
  def area():Double = {
    size.x * size.y
  }
  def perimeter():Double = {
    (size.x * 2) + (size.y * 2)
  }
  def toString():String = {
    shapename
  }
}

/** Include the classes for Circle, Rectangle, and Square here in this file **/
/**------------------------------------------------------------------------**/




/**------------------------------------------------------------------------**/

object ShapeTester {
  def main(args:Array[String]) {
    var shapeList = List[Shape]()
    shapeList ::= new Circle(1.5)
    shapeList ::= new Circle(5)
    shapeList ::= new Rectangle(100,200)
    shapeList ::= new Rectangle(new Vec2(0,0), new Vec2(150,20))
    shapeList ::= new Rectangle(new Vec2(100,100), new Vec2(50,200))
    shapeList ::= new Square(30)
    
    shapeList.foreach { x => println(x + ": " + x.area) }
    shapeList.foreach { x => println(x + ": " + x.perimeter) }
  }
}