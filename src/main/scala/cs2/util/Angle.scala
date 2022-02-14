package cs2.util

class Angle(private var rad:Double) {
  recenter()

  override def toString():String = {
    (rad / math.Pi).toString + " pi"
  }

  private def recenter():Unit = {
    rad = rad % (2*math.Pi)
    if(rad < 0) {
      rad = 2*math.Pi + rad
    }
  }

  def radians = rad
  def radians_=(amt:Double):Unit = {
    rad = amt
    recenter()
  }

  def degrees = rad / math.Pi * 180
  def degrees_=(amt:Double):Unit = {
    rad = amt / 180 * math.Pi
    recenter()
  }

  def + (other:Angle):Angle = {
    new Angle(this.rad + other.rad)
  }
  def + (rhs:Double):Angle = {
    new Angle(this.rad + rhs)
  }
  def += (other:Angle):Unit = {
    this.rad += other.rad
    this.recenter()
  }

  def - (other:Angle):Angle = { new Angle(this.rad - other.rad) }
  def -=(other:Angle):Unit = {
    this.rad -= other.rad
    this.recenter()
  }

  def unary_- :Angle = {
    new Angle(-this.rad)
  }

  def * (scalar:Double):Angle = {
    new Angle(this.rad * scalar)
  }

}

object Angle {
  //"Constructors"
  def apply(amt:Double):Angle = new Angle(amt)
  def apply():Angle = new Angle(0)

  //Constants
  val TWO_PI = Angle(math.Pi * 2)
  val HALF_PI = Angle(math.Pi / 2)
  val PI = Angle(math.Pi)
  val ZERO = Angle()

  //Main method (with a little bit of tester code)
  def main(args:Array[String]):Unit = {
    val x = Angle(3*math.Pi/2)
    println(x)
    println(x + Angle.HALF_PI)
    println(-x)
    println(Angle.PI - x)
    println(x * 4)
  }

}







