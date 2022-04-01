package cs2.adt

import java.util.EmptyStackException

class ArrayStack[A : Manifest] extends Stack[A] {
  var arr:Array[A] = Array.ofDim[A](10)
  var len:Int = 0

  def push(elem:A):Unit = {
    if(len == arr.length) {
      val tmp = Array.ofDim[A](len * 2)
      for(i <- 0 until len) {
        tmp(i) = arr(i)
      }
      arr = tmp
    }
    arr(len) = elem
    len += 1
  }
  def pop():A = {
    if(isEmpty()) {
      throw new EmptyStackException()
    }
    val ret = arr(len-1)
    len -= 1
    ret
  }
  def peek():A = { 
    if(isEmpty()) {
      throw new EmptyStackException()
    }
    arr(len - 1)
  }
  def isEmpty():Boolean = { len == 0 }
}
