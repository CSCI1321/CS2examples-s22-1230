package cs2.algorithms

object ParametricSorting {

  def bubbleSort[A <% Ordered[A]] (arr:Array[A]):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1 ) {
        if(arr(i) > arr(i+1)) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  def bubbleSort[A] (arr:Array[A], gt:(A,A)=>Boolean):Unit = {
    for(j <- 0 until arr.length) {
      for(i <- 0 until arr.length-1 ) {
        if(gt(arr(i), arr(i+1))) {
          val tmp = arr(i)
          arr(i) = arr(i+1)
          arr(i+1) = tmp
        }
      }
    }
  }

  class Student(var first:String, var last:String, var gpa:Double) 
                extends Ordered[Student] {
    override def toString():String = last + ", " + first + ":" + gpa
    override def compare(other:Student):Int = {
      gpa.compare(other.gpa)
    }
  }


  def main(args:Array[String]):Unit = {
    val a = Array(4,2,6,5,0)
    val b = Array("Goodbye","Alice","Hello","Bob")
    val c = Array(new Student("Alice","Smith",4.0),
                  new Student("Bob","Walker", 3.8),
                  new Student("Arya","Stark", 4.2))
    bubbleSort(a)
    bubbleSort(b)
    bubbleSort(c)
    println(a.mkString(","))
    println(b.mkString(","))
    println(c.mkString(","))
  }

}