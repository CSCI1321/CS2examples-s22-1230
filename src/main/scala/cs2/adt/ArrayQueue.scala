package cs2.adt

class ArrayQueue[A:Manifest] extends Queue[A] {
  var arr:Array[A] = Array.ofDim[A](10)
  var len = 0
  var beg = 0

  def enqueue(elem:A):Unit = {
    if(len == arr.length) {
      val tmp = Array.ofDim[A](len * 2)
      for(i <- 0 until len) {
        tmp(i) = arr((beg + i) % arr.length)
      }
      arr = tmp
      beg = 0
    }
    arr((beg+len) % arr.length) = elem
    len += 1
  }
  def dequeue():A = {
    if(isEmpty()) {
      throw new Exception("Queue is empty, cannot dequeue")
    }
    val ret = arr(beg)
    beg = (beg + 1) % arr.length
    len -= 1
    ret
  }
  
  def peek():A = {
    if(isEmpty()) {
      throw new EmptyQueueException()
    }
    arr(beg)
  }
  def isEmpty():Boolean = { len == 0 }
}