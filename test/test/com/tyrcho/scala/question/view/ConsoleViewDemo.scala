package test.com.tyrcho.scala.question.view
import com.tyrcho.scala.question.view.ConsoleView
import com.tyrcho.scala.question.model.TextQuestion

object ConsoleViewDemo {
  def main(args: Array[String]) {
    val view = new ConsoleView[String]
    val q1 = new TextQuestion("q1", "a1")
    val q2 = new TextQuestion("q2", "a2")
    for (q <- Seq(q1, q2)) {
      view.displayQuestion(q)
      val a = view.captureAnswer
      println(if (q.isValid(a)) "OK" else "KO")
    }
  }
}