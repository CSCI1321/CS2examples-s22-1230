package cs2.adt

class BSTSet[A <% Ordered[A]] extends Set[A] {
  private var bst = new BinarySearchTree[A]()
  private var len = 0

  def add(elem:A):Unit = { 
    if(!bst.contains(elem)) {
      bst.insert(elem)
      len += 1
    }
  }
  def remove(elem:A):Unit = {
    if(bst.contains(elem)) {
      bst.remove(elem)
      len -= 1
    }
  }
  def contains(elem:A):Boolean = bst.contains(elem)
  override def size:Int = len

  def iterator:Iterator[A] = bst.iterator

}