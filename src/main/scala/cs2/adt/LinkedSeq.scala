package cs2.adt

class LinkedSeq[A] extends Seq[A] {
  private class Node (var data:A, var next:Node)
  private var hed:Node = null
  private var len:Int = 0

  private def getNode(idx:Int):Node = {
    var rover:Node = hed
    for(ctr <- 0 until idx) {
      rover = rover.next
    }
    rover
  }

  def get(idx:Int):A = {
    getNode(idx).data
  }
  def set(idx:Int, elem:A) = {
    getNode(idx).data = elem
  }
  def insert(idx:Int, elem:A) = {
    if(idx == 0) {
      hed = new Node(elem, hed)
    } else {
      val oneBefore = getNode(idx-1)
      oneBefore.next = new Node(elem, oneBefore.next)
    }
    len += 1
  }
  def remove(idx:Int) = {
    if(idx == 0) {
      hed = hed.next
    } else {
      val oneBefore = getNode(idx - 1)
      oneBefore.next = oneBefore.next.next
    }
    len -= 1
  }
  def length():Int = len

  def iterator:Iterator[A] = {
    new Iterator[A]() {
      private var current:Node = hed

      def hasNext:Boolean = { current != null }
      def next():A = {
        val ret = current.data
        current = current.next
        ret
      }
    }
  }
}



