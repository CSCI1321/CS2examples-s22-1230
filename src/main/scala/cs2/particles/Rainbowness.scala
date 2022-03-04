package cs2.particles

import scalafx.scene.paint.Color

trait Rainbowness {
  protected var hue = 0.0

  protected def stepColor():Color = {
    hue += 0.1
    Color.hsb(hue,0.9,0.9)
  }
}