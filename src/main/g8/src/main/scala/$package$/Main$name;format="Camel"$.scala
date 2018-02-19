package $package$

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import frameless.functions.aggregate._
import frameless.syntax._

object Main$name;format="Camel"$ extends App {
  val conf = new SparkConf().setMaster("local[*]").setAppName("frameless-first-example").set("spark.ui.enabled", "false")
  implicit val spark = SparkSession.builder().config(conf).appName("$name$").getOrCreate()

  import spark.implicits._

  spark.sparkContext.setLogLevel("WARN")

  import frameless.TypedDataset

  case class Bar(b: String, a: Long)
  case class Foo(f: Long, o: Bar)

  val fTypedDataset = TypedDataset.create(Foo(1,Bar("a",2)) :: Foo(10,Bar("b",20)) :: Nil)

  fTypedDataset.show().run()

  // Closing
  spark.stop()
}
