package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
  private class Node (var data:A, var next:Node)
  private var head:Node = null

  def add(elem:A):Unit = {
    if(head == null || elem > head.data) {
      head = new Node(elem, head)
    } else {
      var rover:Node = head
      while(rover.next != null && rover.next.data >= elem) {
        rover = rover.next
      }
      rover.next = new Node(elem, rover.next)
    }
  }
  def get():A = { 
    val ret = head.data
    head = head.next
    ret
  }
  def peek():A = { head.data }

  /*
  def add(elem:A):Unit = {
    head = new Node(elem, head)
  }
  def get():A = {
    var rover = head
    var roversTail:Node = null
    var biggest = head.data
    var obb:Node = null

    while(rover != null) {
      if(rover.data > biggest) {
        biggest = rover.data
        obb = roversTail
      }
      roversTail = rover
      rover = rover.next
    }
    if(obb == null) {
      head = head.next
    } else {
      obb.next = obb.next.next
    }
    biggest
  }
  def peek():A = {
    var biggest:A = head.data
    var rover:Node = head
    while(rover != null) {
      if(rover.data > biggest) biggest = rover.data
      rover = rover.next
    }
    biggest
  }
  */
  def isEmpty():Boolean = { head == null }
}

