package test.com.tyrcho.scala.question.view

import org.junit.Test
import com.tyrcho.scala.question.view.RunQuestionnaireView
import org.junit.Assert._
import com.tyrcho.scala.question.model.Questionnaire
import com.tyrcho.scala.question.model.Question
import org.junit.Before
import scala.collection.mutable.ListBuffer

class TestRunQestionnaireView {
  var view: RunQuestionnaireView[String, String] = null
  var answers = ListBuffer[String]()

  @Before
  def setup() {
    view = new RunQuestionnaireView[String, String]() {
      def displayQuestion(q: Question[String, String]) {
        println(q.question)
        answers.append(q.answer)
      }
    }
    answers.clear
  }

  @Test
  def testListener() {
    var done = false
    view.registerQuestionnaireFinishedListener(() => { done = true })
    view.start(new Questionnaire[String, String](Seq(new Question("q", "a"))))
    assertTrue("listener called", done)
  }

  @Test
  def testPrinter() {
    val questions = Seq(new Question("q1", "a1"), new Question("q2", "a2"))
    view.start(new Questionnaire[String, String](questions))
    assertEquals(Seq("a1", "a2"), answers.toSeq)
  }
}