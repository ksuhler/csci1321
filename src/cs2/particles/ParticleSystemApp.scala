package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import cs2.util.Vec2
import scalafx.scene.canvas.Canvas
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.canvas.Canvas.sfxCanvas2jfx
import scalafx.scene.paint.Color.sfxColor2jfx


object ParticleSystemApp {
  
  val app = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Particles!"
      scene = new Scene(600,400) {
        val canvas = new Canvas(600,400)
        content = canvas
        
        val g = canvas.getGraphicsContext2D
        g.strokeRect(100,200, 300,100)
           
        val ps = new ParticleSystem (new Vec2(300,100))
        
        val timer = AnimationTimer (t => {
          g.setFill(Color White)
          g.fillRect(0,0, 400,600)
          ps.display(g)
          ps.timeStep
          ps.addParticle
        })
        timer.start
      }
    }
  }
  
  def main(args:Array[String]) {
    app.main(args)
  }
  
}