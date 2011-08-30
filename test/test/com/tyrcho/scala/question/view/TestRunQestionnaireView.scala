package test.com.tyrcho.scala.question.view

import org.junit.Test
import com.tyrcho.scala.question.view.RunQuestionnaireView
import org.junit.Assert._

class TestRunQestionnaireView {
  @Test
  def testListener() {
    val view = new RunQuestionnaireView() {
      def start() { fireQuestionnaireFinished() }
    }
    var done = false
    view.registerQuestionnaireFinishedListener(() => { done = true })
    view.start
    assertTrue("listener called", done)
  }
}