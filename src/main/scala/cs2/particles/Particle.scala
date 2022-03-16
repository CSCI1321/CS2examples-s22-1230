package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

abstract class Particle(protected var pos:Vec2, protected var vel:Vec2) {
  protected var r:Double = 20
  protected var c:Color = Color.Red

  //Abstract display method
  def display(g:GraphicsContext):Unit
  
  //Concrete methods
  def isDead():Boolean = false
  def timeStep():Unit = {
    pos += vel
  }
  final def applyForce(force:Vec2):Unit = {
    vel += force
  }


}