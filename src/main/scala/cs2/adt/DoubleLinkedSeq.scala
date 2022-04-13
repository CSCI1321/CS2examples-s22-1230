package cs2.adt

class DoubleLinkedSeq[A : Manifest] extends Seq[A] {
  private class Node(var data:A, var prev:Node, var next:Node)
  private var len:Int = 0
  private var sent:Node = new Node(Array.ofDim[A](1).apply(0), null, null)
  sent.prev = sent
  sent.next = sent

  class BidirectionalIterator extends Iterator[A] {
    private var current:Node = sent.next
    def hasNext:Boolean = {
      current != sent
    }
    def next():A = {
      val ret = current.data
      current = current.next
      ret
    }
    def hasPrevious:Boolean = {
      current != sent
    }
    def previous():A = {
      val ret = current.data
      current = current.prev
      ret
    }

  }

  private def getNode(idx:Int):Node = {
    if(idx < 0) sent
    else if(idx >= length()-1) sent.prev
    else {
      var rover:Node = sent.next
      for(ctr <- 0 until idx) {
        rover = rover.next
      }
      rover
    }
  }

  def get(idx:Int):A = {
    if(idx >= length() || idx < 0) throw new IndexOutOfBoundsException()
    getNode(idx).data
  }
  def set(idx:Int, elem:A):Unit = {
    if(idx >= length() || idx < 0) throw new IndexOutOfBoundsException()
    getNode(idx).data = elem
  }
  def insert(idx:Int, elem:A):Unit = {
    len += 1
    val bef = getNode(idx-1)
    bef.next = new Node(elem, bef, bef.next)
    bef.next.next.prev = bef.next
  }
  def remove(idx:Int):Unit = {
    if(idx >= length() || idx < 0) throw new IndexOutOfBoundsException()
    len -= 1
    val rover = getNode(idx)
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
  }

  def length():Int = len
  def iterator:Iterator[A] = new BidirectionalIterator()
}