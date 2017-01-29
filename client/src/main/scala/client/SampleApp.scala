package client

import scala.scalajs.js.JSApp
import org.scalajs.dom
import org.scalajs.jquery.jQuery
import dom.ext.Ajax

import scala.concurrent.ExecutionContext.Implicits.global
import model.Todo
import upickle.default._

object SampleApp extends JSApp {
  def main(): Unit = {
    Ajax.get("/all").foreach{ xhr =>
      val todos = read[Seq[Todo]](xhr.responseText)
      val ul = jQuery("ul#todos")
      todos.map { todo =>
        ul.append(s"<li>${todo.id} - ${todo.body} - ${todo.isComplete} - ${todo.score}</li>")
      }
    }
  }
}
