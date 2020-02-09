object q {

  def main(args: Array[String]) {
    println(sort(List(9, 2, 4, 1, 3)))
  }

  def sort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => 
      val (low, hight) = tail.partition(_<head)
      sort(low) ::: head :: sort(hight)
  }

}
