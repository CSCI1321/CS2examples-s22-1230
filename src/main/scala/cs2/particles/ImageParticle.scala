package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class ImageParticle(p:Vec2, v:Vec2) extends Particle(p,v) {
  
  
  override def display(g:GraphicsContext):Unit = {
    g.drawImage(ImageParticle.img, pos.x,pos.y)
  }

}

object ImageParticle {
  val img = new Image(getClass().getResource("/images/Star.png").toString())
}