package cs2.particles

import cs2.util.Vec2

class ParticleSystem (private var orig:Vec2) {
  private var parts:List[Particle] = Nil
  
  def addParticle() {
    parts ::= new Particle(orig)
  }
  
  def display(g:GraphicsContent) {
    for(p <- parts) p.display(g)
  }
  
  def timeStep() {
    for(p <- parts) p.timeStep
  }
  
}