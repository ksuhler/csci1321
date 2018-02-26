package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

abstract class Particle (protected var pos:Vec2) {
  protected var vel:Vec2 = new Vec2(math.random*2-1,math.random*2-1)
  protected var col:Color = Color.Red
  
  def display(g:GraphicsContext) {
    g.strokeOval(pos.x,pos.y, 20,20)
    
  }
  def timeStep():Boolean = {
    pos += vel
    pos.y < -200 || pos.y > 600 || pos.x < -200 || pos.x > 800
  }
  def applyForce(acc:Vec2) {
    vel += acc
  }
 }
