package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent

object ParticleSystemApp extends JFXApp with Rainbowness {
  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,800) {
      val canvas = new Canvas(width.value, height.value)
      content = canvas
      val g = canvas.graphicsContext2D

      var pslist = List[ParticleSystem]() 
      
      canvas.onMouseClicked = (e:MouseEvent) => {
        pslist ::= new ParticleSystem(Vec2(e.x, e.y))
      }

      var wind = Vec2(0.01,0)

      canvas.onMouseMoved = (e:MouseEvent) => {
        wind = Vec2(e.x / width.value * 0.02 - 0.01, 0.0)
      }

      val timer = AnimationTimer(t => {
        g.setFill(stepColor())
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.rgb(40,80,200,0.2))
        for(ps <- pslist) {
          ps.display(g)
          ps.timeStep()
          ps.applyForce(Vec2(0,-0.001))
          ps.applyForce(wind)
          ps.addParticle()
        }
      })
      timer.start

      

    }
  }
}