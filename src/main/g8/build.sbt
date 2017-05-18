lazy val SparkVersion = "2.0.2"
lazy val FramelessVersion = "0.3.0"

def makeColorConsole() = {
  val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
  if (ansi) System.setProperty("scala.color", "true")
}

lazy val root = project.in(file(".")).
  settings(
    name := "$name$",
    organization := "$organization$",
    scalaVersion := "2.11.11",
    version := "$version$",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "frameless-dataset" % FramelessVersion,
      "org.apache.spark" %% "spark-core" % SparkVersion,
      "org.apache.spark" %% "spark-sql"  % SparkVersion
    ),
    initialize ~= { _ => makeColorConsole() },
    initialCommands in console :=
      """
        |import org.apache.spark.{SparkConf, SparkContext}
        |import org.apache.spark.sql.SparkSession
        |import frameless.functions.aggregate._
        |
        |val conf = new SparkConf().setMaster("local[*]").setAppName("frameless-repl").set("spark.ui.enabled", "false")
        |val spark = SparkSession.builder().config(conf).appName("$name$").getOrCreate()
        |
        |import spark.implicits._
        |
        |spark.sparkContext.setLogLevel("WARN")
        |
        |import frameless.TypedDataset
        |implicit val sqlContenxt = spark.sqlContext
      """.stripMargin,
    cleanupCommands in console :=
      """
        |spark.stop()
      """.stripMargin
  )