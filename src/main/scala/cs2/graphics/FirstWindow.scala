package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scalafx.animation.AnimationTimer

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(800,600) {
      val canvas = new Canvas(800,600)
      content = canvas
      val g = canvas.graphicsContext2D
      /*
      g.strokeLine(0,0, 400,200)
      g.setStroke(Color.RoyalBlue)
      g.strokeRect(100,200, 300,200)
      g.setFill(Color.rgb(150,150,50))
      g.fillOval(100,200, 300,200)

      g.setLineWidth(2)
      for(x <- 0 to width.value.toInt) {
        g.setStroke(Color.rgb((x/width.value*255).toInt,0,0))
        g.strokeLine(x,0, x,height.value)
      }
      */

      canvas.onMouseDragged = (e:MouseEvent) => {
        g.strokeLine(width.value/2,height.value/2, e.x,e.y)
      }
      canvas.onKeyPressed = (e:KeyEvent) => {
        if(e.code == KeyCode.Space) {
          g.setFill(Color.White)
          g.fillRect(0,0, width.value,height.value)
        }
        if(e.code == KeyCode.R) {
          g.setStroke(Color.Red)
        }

      }
      canvas.requestFocus()

      var xball = 200.0
      var yball = 100.0
      var rball = 50.0
    
      val timer = AnimationTimer (t => {
        g.setFill(Color.White)
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.DeepSkyBlue)
        g.fillOval(xball,yball, rball*2,rball*2)
        yball += 0.05
      })
      timer.start
        
    }
  }
}