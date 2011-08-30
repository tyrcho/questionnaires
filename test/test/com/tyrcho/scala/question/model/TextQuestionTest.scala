package test.com.tyrcho.scala.question.model

import org.junit.Assert._
import com.tyrcho.scala.question.model._
import org.junit.Test

class TextQuestionTest {
  @Test
  def simpleQuestionTest() {
    val question = new TextQuestion("q", "a")
    assertTrue("valid answer", question.isValid("a"))
    assertFalse("invalid answer", question.isValid("else"))
  }
}