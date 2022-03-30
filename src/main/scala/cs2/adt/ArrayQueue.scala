package cs2.adt

class ArrayQueue[A:Manifest] extends Queue[A] {
  var arr:Array[A] = Array.ofDim[A](10)
  var len = 0
  var beg = 0

  def enqueue(elem:A):Unit = {
    if(len == arr.length) {
      val tmp = Array.ofDim[A](len * 2)
      
      arr = tmp
    }
    arr((len+beg) % arr.length) = elem
    len += 1
  }
  def dequeue():A = {
    val ret = arr(beg)
    beg += 1
    len -= 1
    ret
  }
  def peek():A = { arr(beg) }
  def isEmpty():Boolean = { len == 0 }
}