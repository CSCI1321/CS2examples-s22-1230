package cs2.adt

class ArrayStack[A : Manifest] extends Stack[A] {
  var arr:Array[A] = Array()

  def push(elem:A):Unit = {
    val tmp:Array[A] = Array.ofDim[A](arr.length + 1)
    tmp(arr.length) = elem
    for(i <- 0 until arr.length) {
      tmp(i) = arr(i)
    }
    arr = tmp
  }
  def pop():A = {
    val tmp:Array[A] = Array.ofDim[A](arr.length -1)
    for(i <- 0 until tmp.length) {
      tmp(i) = arr(i)
    }
    val ret = arr(arr.length-1)
    arr = tmp
    ret
  }
  def peek():A = { arr(arr.length - 1) }
  def isEmpty():Boolean = { arr.length == 0 }
}
