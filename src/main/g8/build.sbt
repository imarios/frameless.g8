lazy val SparkVersion = "2.0.2"
lazy val FramelessVersion = "0.2.0"

def makeColorConsole() = {
  val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
  if (ansi) System.setProperty("scala.color", "true")
}

lazy val root = project.in(file(".")).
  settings(
    name := "$name$",
    organization := "$organization$",
    scalaVersion := "2.11.8",
    version := "$version$",
    libraryDependencies ++= Seq(
      "io.github.adelbertc" %% "frameless-dataset" % FramelessVersion,
      "org.apache.spark" %% "spark-core" % SparkVersion % "provided",
      "org.apache.spark" %% "spark-sql"  % SparkVersion % "provided"
    ),
    initialize ~= { _ => makeColorConsole() },
    initialCommands in console := """ """
  )