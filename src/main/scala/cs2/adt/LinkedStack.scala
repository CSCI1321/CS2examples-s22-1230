package cs2.adt

import java.util.EmptyStackException

class LinkedStack[A] extends Stack[A] {
  private class Node (val data:A, val next:Node)
  private var head:Node = null

  def push(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def pop():A = {
    if(isEmpty()) throw new EmptyStackException()
    val ret = head.data
    head = head.next
    ret
  }
  def peek():A = { 
    if(isEmpty()) throw new EmptyStackException()
    head.data
  }
  def isEmpty():Boolean = { head == null }
}