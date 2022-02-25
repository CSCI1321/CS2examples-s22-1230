package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class Particle(var pos:Vec2, var vel:Vec2) {
  var r:Double = 20

  def display(g:GraphicsContext):Unit = {
    g.fillOval(pos.x,pos.y, 2*r,2*r)
  }
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(force:Vec2):Unit = {
    vel += force
  }


}