package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class Particle (private var pos:Vec2) {
  private var vel:Vec2 = new Vec2(math.random*2-1,math.random*2-1)
  
  def display(g:GraphicsContext) {
    g.strokeOval(pos.x,pos.y, 20,20)
    
  }
  def timeStep() {
    pos += vel
  }
  def applyForce(acc:Vec2) {
    vel += acc
  }
 }
