object ts {

  def main(args: Array[String]): Unit = {
    println(s(List(1, 2, 3, 4, 5), 8))

  }

  def s(list: List[Int], target: Int) = 
    list.combinations(2).find(_.sum==target)

}
