package com.tyrcho.scala.question.view

import scala.collection.mutable.ListBuffer

trait RunQuestionnaireView {
  val listeners = ListBuffer[() => Unit]()

  def start()
  def registerQuestionnaireFinishedListener(listener: () => Unit) { listeners.append(listener) }
  protected def fireQuestionnaireFinished() { listeners foreach (_.apply()) }
}