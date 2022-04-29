package cs2.adt

abstract class PriorityQueue[A <% Ordered[A]] {
  def add(elem:A):Unit
  def get():A
  def peek():A
  def isEmpty():Boolean
}

object PriorityQueue {
  def apply[A <% Ordered[A] : Manifest]():PriorityQueue[A] = {
    new HeapPriorityQueue[A]()
  }
}

