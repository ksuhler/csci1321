package cs2.particles

import scalafx.Includes._
import cs2.util.Vec2
import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import scalafx.animation.AnimationTimer
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color
import scalafx.scene.image.Image
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode



object ParticleSystemApp {
    val app = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Particles!"
      scene = new Scene(600,400) {
        val canvas = new Canvas(600,400)
        content = canvas
        
        val g = canvas.getGraphicsContext2D
        //g.strokeRect(100,200, 300,100)
       var wind = new Vec2
       
        var psList:List[ParticleSystem] = Nil
        
        canvas.onMouseClicked = (e:MouseEvent) => {
          psList ::= new ParticleSystem(new Vec2(e.x,e.y))
        }
        
       // val ps = new ParticleSystem (new Vec2(300,100))
        
        canvas.onKeyPressed = (e:KeyEvent) => {
          if(e.code == KeyCode.Space) {
            psList = Nil
          }
        }
        
        val partImage = new Image("file:smoke.png")
     
        canvas.onMouseMoved = (e:MouseEvent) => {
         wind = new Vec2((e.x-300)/300, 0)
        }
        
        val backg = new RainbowBackround(600,400)
        
        val timer = AnimationTimer (t => {
          backg.display(g)
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
  
  def main(args:Array[String]){
    app.main(args)
  }
  
}