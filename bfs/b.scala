import scala.collection.immutable.Queue

/**
 * https://stackoverflow.com/questions/41347337/how-to-implement-breadth-first-search-in-scala-with-fp
 */
object b {

  case class Node(value: Int, children: List[Node] = List.empty[Node])

  def main(args: Array[String]) {
    val root = Node(
      value = 3,
      children = List(
        Node(value = 4, children = List(Node(value = 5))), 
        Node(value = 6), 
        Node(value = 8)
      )
    )      
    val result = bfs(root, { (node: Node) =>
      Queue.empty[Node] ++ node.children
    }).find(_.value==5) 
    println(result)
  }

  def bfs[Node](node: Node, f: Node => Queue[Node]): Stream[Node] = {
    def _bfs(queue: Queue[Node]): Stream[Node] = queue match {
      case q if q.isEmpty => Stream.Empty
      case _ =>
        val (head, rest) = queue.dequeue
        head #:: _bfs(rest ++ f(head))
    }
    node #:: _bfs(Queue.empty[Node] ++ f(node))
  }

}
