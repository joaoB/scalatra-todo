import java.util.concurrent.ConcurrentHashMap

import controller._
import org.scalatra._
import javax.servlet._

import model.Todo

import scala.collection.JavaConverters._
import scala.collection.concurrent.{Map => ConcurrentMap}


class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    val todos: ConcurrentMap[Integer, Todo] = new ConcurrentHashMap[Integer, Todo].asScala
    context.mount(new IndexController(todos), "/")
  }
}
