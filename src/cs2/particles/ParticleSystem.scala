package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image
import scalafx.scene.image.Image

class ParticleSystem (private var orig:Vec2) {
  private var parts = scala.collection.mutable.Buffer[Particle] ()
  
  def addParticle() {
   // parts = new ImageParticle(new Vec2(orig), new Image("file:smoke.png")) :: parts
    
    parts += new RainbowParticle(new Vec2(orig))
    /*if(math.random < 0.5)
    parts ::= new RoundParticle(new Vec2(orig)) :: parts
    else
    parts ::= new SquareParticle(new Vec2(orig)) 
    * */
  }
  
  def display(g:GraphicsContext) {
    parts.foreach(x => x.display(g))
  }
  
  def timeStep() {
    var i = 0 
    
    while(i < parts.length) {
      if(parts(i).timeStep()) {
        parts.remove(i)
      } else {
      i += 1
      }
    }
   
  }
  def applyForce(acc:Vec2) {
    for(p <- parts) p.applyForce(acc)
  }
}