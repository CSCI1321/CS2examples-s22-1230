package cs2.particles

import scalafx.scene.canvas.GraphicsContext
import cs2.util.Vec2

class RoundParticle(p:Vec2,v:Vec2) extends Particle(p,v) {
  override def display(g:GraphicsContext):Unit  = {
    g.setFill(c)
    g.fillOval(pos.x,pos.y, 2*r,2*r)
  }
}