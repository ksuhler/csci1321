package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem (private var orig:Vec2) {
  private var parts:List[Particle] = Nil
  
  def addParticle() {
    parts = new RainbowParticle(orig.clone) :: parts
    /*if(math.random < 0.5)
    parts ::= new RoundParticle(new Vec2(orig)) :: parts
    else
    parts ::= new SquareParticle(new Vec2(orig)) 
    * */
    */
  }
  
  def display(g:GraphicsContext) {
    for(p <- parts) p.display(g)
  }
  
  def timeStep() {
    for(p <- parts) p.timeStep
  }
  def applyForce(acc:Vec2) {
    for(p <- parts) p.applyForce(acc)
  }
}