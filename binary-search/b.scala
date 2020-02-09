object b {

  def main(args: Array[String]): Unit = {
    println(search(List(1, 2, 3, 4, 5), 6))
  }

  def search(list: List[Int], target: Int) = {
    def _s(start: Int, end: Int): Int = {
      if(start > end) -1 else {
        val mid = start + (end - start)/ 2 
        list(mid) match {
          case m if m == target => mid 
          case m if m <= target => _s(mid+1, end)
          case m if target < m =>  _s(start, mid-1)
        }
      }
    }
    _s(0, list.length - 1)
  }


}
