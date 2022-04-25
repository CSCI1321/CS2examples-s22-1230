package cs2.adt

abstract class Set[A <% Ordered[A]] extends Iterable[A] {
  //Abstract methods
  def add(elem:A):Unit
  def remove(elem:A):Unit
  def contains(elem:A):Boolean
  def size():Int
  //Need to define iterator():Iterator[A]

  //Concrete (derived) methods
  def intersect(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) {
      if(other.contains(x)) {
        result.add(x)
      }
    }
    result
  }
  def union(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) {
      result.add(x)
    }
    for(x <- other) {
      result.add(x)
    }
    result
  }
  def difference(other:Set[A]):Set[A] = {
    val result = Set[A]()
    for(x <- this) {
      if(!other.contains(x)) {
        result.add(x)
      }
    }
    result
  }
}

object Set {
  def apply[A <% Ordered[A]]():Set[A] = {
    new BSTSet[A]()
  }
}


