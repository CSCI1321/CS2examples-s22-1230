package cs2.adt

abstract class Stack[A] {
  def push(elem:A):Unit
  def pop():A
  def peek():A
  def isEmpty():Boolean
}

object Stack {
  def apply[A:Manifest]():Stack[A] = {
    new LinkedStack[A]()
  }
}