//https://stackoverflow.com/questions/45678000/maximum-depth-of-binary-tree-in-scala
object m {

  sealed trait Node
  case object Empty extends Node
  case class Leaf(value: Int, left: Node = Empty, right: Node = Empty) extends Node

  def main(args: Array[String]) {
    val root = Leaf(
      value = 3,
      left = Leaf(value = 5, right = Leaf(value = 6)),
      right = Leaf(value = 8, left = Leaf(value = 10, right = Leaf(value = 11)))
    )
    println(depth(root))
  }

  def depth(node: Node): Int = node match {
    case Empty => 0
    case Leaf(value, left, right) => 
      Math.max(depth(left), depth(right)) + 1
  }

}
