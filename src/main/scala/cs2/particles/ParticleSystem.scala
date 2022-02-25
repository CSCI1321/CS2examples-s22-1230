package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem() {
  var particles = List[Particle]()

  def addParticle():Unit = {
    particles ::= new SquareParticle(Vec2(400,100),
                    Vec2(math.random()-0.5, math.random()-0.5))
  }

  def display(g:GraphicsContext):Unit = {
    for(p <- particles) p.display(g)
  }
  def timeStep():Unit = {
    particles.foreach(_.timeStep())
  }
  def applyForce(force:Vec2):Unit = {
    for(p <- particles) p.applyForce(force)
  }
  
}