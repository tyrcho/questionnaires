package com.tyrcho.scala.question.view
import com.tyrcho.scala.question.model.Question

trait QuestionView[Q, A] {
  def displayQuestion(q: Question[Q, A])
  def captureAnswer(): A
}