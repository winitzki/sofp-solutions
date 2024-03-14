/** author: Andreas Röhler */

/** 
  Exercise 2.1.7.10
  Given a Seq[List[Int]], compute a new Seq[List[Int]] where each list contains three largest elements from the initial list (or fewer than three if the initial list is
  shorter). So, for the input:

  Seq(List(0, 50, 5, 10, 30), List(100), List(1, 2, 200, 20))

  the output must be:

  Seq(List(50, 30, 10), List(100), List(200, 20, 2))
  
Hint: use map, sortBy, take.
 */

object LargestTree {
  def largestTree(a: Seq[List[Int]]): Seq[List[Int]] = {
    val x = a.map{ k=>k.sortBy(k=>(-k))}.map{ k => k.take(3) }
    printf("largestTree %s:\n", x)
    x
  }
  def main(args: Array[String]) = {
    val expected = Seq(List(50, 30, 10), List(100), List(200, 20, 2))
    val result =  this.largestTree(Seq(List(50, 30, 10), List(100), List(200, 20, 2)))
    assert(result == expected)
    if (result == expected) println("solution2.1.7.10_object_main result: %s\n".format(result))
  }
  LargestTree.main(Array())
}

// IntelliJ:

// /usr/lib/jvm/java-1.11.0-openjdk-amd64/bin/java -javaagent:/snap/intellij-idea-community/491/lib/idea_rt.jar=38493:/snap/intellij-idea-community/491/bin -Dfile.encoding=UTF-8 -classpath /home/speck/IdeaProjects/aktuell/out/production/aktuell:/usr/share/scala-2.11/lib/scala-library.jar:/usr/share/scala-2.11/lib/scala-actors.jar:/usr/share/scala-2.11/lib/scala-reflect.jar:/usr/share/scala-2.11/lib/scala-parser-combinators.jar:/usr/share/scala-2.11/lib/scala-xml.jar LargestTree
// largestTree List(List(50, 30, 10), List(100), List(200, 20, 2)):
// solution2.1.7.10_object_main result: List(List(50, 30, 10), List(100), List(200, 20, 2))

// largestTree List(List(50, 30, 10), List(100), List(200, 20, 2)):
// solution2.1.7.10_object_main result: List(List(50, 30, 10), List(100), List(200, 20, 2))
