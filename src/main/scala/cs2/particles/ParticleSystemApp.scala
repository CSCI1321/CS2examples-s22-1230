package cs2.particles

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color

object ParticleSystemApp extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(800,800) {
      val canvas = new Canvas(width.value, height.value)
      content = canvas
      val g = canvas.graphicsContext2D

      val ps = new ParticleSystem()

      val timer = AnimationTimer(t => {
        g.setFill(Color.White)
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.OrangeRed)
        ps.display(g)
        ps.timeStep()
        ps.applyForce(Vec2(0,0.005))
        ps.addParticle()
      })
      timer.start

      

    }
  }
}