package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2, v:Vec2) extends Particle(p,v) {
  private var lifetime = 1.0
  
  override def display(g:GraphicsContext):Unit = {
    g.globalAlpha = lifetime
    g.drawImage(ImageParticle.img, pos.x,pos.y)
    lifetime -= 0.001
    g.globalAlpha = 1.0
  }

}

object ImageParticle {
  val img = new Image(getClass().getResource("/images/Smoke.png").toString())
}