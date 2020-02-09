object p {

  def main(args: Array[String]): Unit = {
    println(permutations(List(1, 2, 3)))
  }

  def permutations(ls: List[Int]): List[List[Int]] = ls match {
    case Nil => List(List())
    case _ => for {
      e <- ls
      r <- permutations(ls diff List(e))
    } yield e :: r
  }


}
