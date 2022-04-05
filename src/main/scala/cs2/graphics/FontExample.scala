package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import scalafx.animation.AnimationTimer
import scalafx.scene.text.Font

object FontExample extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title = "My First Window"
    scene = new Scene(800,600) {
      val canvas = new Canvas(800,600)
      content = canvas
      val g = canvas.graphicsContext2D
 
      //Saving the default font for later use
      val defaultFont:Font = g.getFont()

      //Print out all available fonts
      println("Available fonts: " + Font.families)

      //Creating a string that can be modified for display
      var activeString = "CUSTOM STRING: "
      canvas.onKeyTyped = (e:KeyEvent) => {
        activeString += e.getCharacter()
      }
      canvas.requestFocus()

      val timer = AnimationTimer (t => {
        g.setFill(Color.AntiqueWhite)
        g.fillRect(0,0, width.value,height.value)
        g.setFill(Color.Chocolate)
        //Text with the default settings
        g.setFont(defaultFont)
        g.fillText("Hello - this is some sample text above a rectangle", 100, 100)
        g.fillRect(100,100, 300,50)
        
        //Creating a custom font for use
        g.setFont(Font("Serif",24))
        g.setFill(Color.BlueViolet)
        g.fillText(activeString, 150,400)
      })
      timer.start
        
    }
  }
}