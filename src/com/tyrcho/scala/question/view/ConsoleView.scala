package com.tyrcho.scala.question.view
import com.tyrcho.scala.question.model.Question

class ConsoleView[Q] extends QuestionView[Q, String] {
  def displayQuestion(q: Question[Q, String]) = printf("%s ?%n", q.question)

  def captureAnswer() = readLine
}