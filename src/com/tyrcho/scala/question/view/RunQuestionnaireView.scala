package com.tyrcho.scala.question.view

import scala.collection.mutable.ListBuffer
import com.tyrcho.scala.question.model.Question
import com.tyrcho.scala.question.model.Questionnaire

trait RunQuestionnaireView[Q, A] {
  val listeners = ListBuffer[() => Unit]()

  def start(q: Questionnaire[Q, A]) {
    q.questions foreach (displayQuestion(_))
    fireQuestionnaireFinished
  }

  def displayQuestion(q: Question[Q, A])

  def registerQuestionnaireFinishedListener(listener: () => Unit) { listeners.append(listener) }

  protected def fireQuestionnaireFinished() { listeners foreach (_.apply()) }
}