package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

class Eraser(protected var pos:Vec2, protected var r:Double) {
  def display(g:GraphicsContext):Unit = {
    g.setStroke(Color.Gray)
    g.strokeOval(pos.x,pos.y, r*2,r*2)
  }

  def intersectParticle(p:Particle):Boolean = {
    val dx = pos.x - p.pos.x
    val dy = pos.y - p.pos.y
    val dist = math.sqrt(dx*dx + dy*dy)
    dist < (r + p.r)
  }
}