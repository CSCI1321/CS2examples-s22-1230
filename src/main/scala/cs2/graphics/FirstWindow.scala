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
import scalafx.scene.image.Image

object FirstWindow extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(600,600) {
      val canvas = new Canvas(600,600)
      content = canvas
      val g = canvas.graphicsContext2D

      def drawCircle(x:Double, y:Double, r:Double):Unit = {
        g.strokeOval(x-r,y-r, r*2,r*2)
        if(r > 2) {
          drawCircle(x-r,y, r/2)
          drawCircle(x+r,y, r/2)
          drawCircle(x,y-r, r/2)
          drawCircle(x,y+r, r/2)
        }
      }

      drawCircle(300,300,150)

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
      /*
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
      var vball = 0.05

      val path = getClass().getResource("/images/Star.png")
      val img = new Image(path.toString)
    
      val timer = AnimationTimer (t => {
        g.setFill(Color.Black)
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.DeepSkyBlue)
        //g.fillOval(xball,yball, rball*2,rball*2)
        g.drawImage(img, xball,yball, rball*2,rball*2)
        yball += vball
        if(yball+rball*2 >= height.value || yball <= 0) {
          vball = -vball
        }
      })
      timer.start
      */
    }
  }
}