package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.shape.StrokeLineCap

class ParticleSystem(protected val origin:Vec2) {
  protected var particles = List[Particle]()

  def addParticle():Unit = {
    //*
    if(math.random() < 0.5) {
      particles ::= new RoundParticle(new Vec2(origin.x,origin.y),
                      Vec2(math.random()-0.5, math.random()-0.5))
    } else {
      particles ::= new SquareParticle(origin.clone(),
                      Vec2(math.random()-0.5, math.random()-0.5))
    }/*
    particles ::= new ImageParticle(origin.clone(),
                      Vec2(math.random()-0.5, math.random()-0.5))
  */
  }

  def display(g:GraphicsContext):Unit = {
    //println(particles.length)
    for(p <- particles) p.display(g)
  }
  def timeStep():Unit = {
    particles.foreach(_.timeStep())
  }
  def applyForce(force:Vec2):Unit = {
    for(p <- particles) p.applyForce(force)
  }
  
}