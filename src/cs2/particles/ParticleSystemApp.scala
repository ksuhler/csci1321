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
import scalafx.scene.input.MouseEvent


object ParticleSystemApp {
  
  val app = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Particles!"
      scene = new Scene(600,400) {
        val canvas = new Canvas(600,400)
        content = canvas
        
        val g = canvas.getGraphicsContext2D
        g.strokeRect(100,200, 300,100)
        var wind = new Vec2
        
        var psList:List[ParticleSystem] = Nil
        
        canvas.onMouseClicked = (e:MouseEvent) => {
          psList ::= new ParticleSystem(new Vec2(e.x,e.y))
        }
        
        val ps = new ParticleSystem (new Vec2(300,100))
        
        canvas.onMouseMoved = (e:MouseEvent) => {
         wind = new Vec2((e.x-300)/300, 0)
        }
        
        val timer = AnimationTimer (t => {
          g.setFill(Color White)
          g.fillRect(0,0, 600,400)
          for(ps <- psList) {
            ps.display(g)
            ps.timeStep
            ps.applyForce(new Vec2(0,0.1))
            ps.applyForce(wind)
            ps.addParticle
            }
        })
        timer.start
      }
    }
  }
  
  def main(args:Array[String]) {
    app.main(args)
  }
  
}