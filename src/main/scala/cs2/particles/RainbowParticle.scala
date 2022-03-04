package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color

class RainbowParticle(p:Vec2,v:Vec2) 
           extends RoundParticle(p,v)
           with Rainbowness {

  override def timeStep():Unit = {
    super.timeStep()
    c = stepColor()
  }

}