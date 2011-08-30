package com.tyrcho.scala.question.model

class Question[Q, A](val question: Q, val answer: A, val label: String = "") {
  def isValid(prop: A) = answer.equals(prop)
}