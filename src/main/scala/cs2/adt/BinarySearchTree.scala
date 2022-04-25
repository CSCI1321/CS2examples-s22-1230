package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
  private class Node(var data:A, var left:Node, var right:Node) {
    def contains(elem:A):Boolean = {
      if(data <= elem && data >= elem) true //data.compareTo(elem) == 0
      else {
        if(elem > data) {
          if(right != null) right.contains(elem) else false
        } else {
          if(left != null) left.contains(elem) else false
        }
      }
    }
    def insert(elem:A):Unit = {
      if(elem > data) { //Go right
        if(right == null) right = new Node(elem, null, null)
        else right.insert(elem)
      } else { //Go left
        if(left == null) left = new Node(elem, null, null)
        else left.insert(elem)
      }
    }
    def passUpMax():(Node,A) = {
      if(right == null) {
        (left, data)
      }
      else {
        val (n,v) = right.passUpMax()
        right = n
        (this, v)
      }
    }

    def remove(elem:A):Node = {
      if(data >= elem && data <= elem) { //We are at the node to remove
        if(right == null) left
        else if(left == null) right
        else { //Two children
          val (n,v) = left.passUpMax()
          left = n
          data = v
          this
        }
      } else {
        if(elem > data) right = right.remove(elem)
        else left = left.remove(elem)
        this
      }
    }
  }
  private var root:Node = null

  def insert(elem:A):Unit = {
    if(root == null) root = new Node(elem, null, null)
    else root.insert(elem)
  }
  def remove(elem:A):Unit = {
    root = root.remove(elem)
  }

  def contains(elem:A):Boolean = {
    if(root == null) false else root.contains(elem)
    /*
    var curr:Node = root
    while(curr != null) {
      if(curr.data == elem) return true
      else {
        if(elem > curr.data) {
          curr = curr.right
        } else {
          curr = curr.left
        }
      }
    }
    false*/
  }

  def printInOrder():Unit = {
    def workOnNode(n:Node):Unit = {
      if(n.left != null) workOnNode(n.left)
      print(n.data)
      if(n.right != null) workOnNode(n.right)
    }
    workOnNode(root)
  }

  def printPreOrder():Unit = {
    def workOnNode(n:Node):Unit = {
      print(n.data)
      if(n.left != null) workOnNode(n.left)
      if(n.right != null) workOnNode(n.right)
    }
    workOnNode(root)
  }



}