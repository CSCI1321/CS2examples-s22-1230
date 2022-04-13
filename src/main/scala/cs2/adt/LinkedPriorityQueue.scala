package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node (var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def get():A = ???
  def peek():A = {
    var biggest:A = head.data
    var rover:Node = head
    while(rover != null) {
      if(rover.data > biggest) biggest = rover.data
      rover = rover.next
    }
    biggest
  }
  def isEmpty():Boolean = { head == null }
}

