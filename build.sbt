
testFrameworks += new TestFramework("scalaprops.ScalapropsFramework")

version := "0.4.0"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.5", "2.11.6")

scalacOptions ++= Seq("-feature")

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "com.github.scalaprops" %% "scalaprops" % "0.1.6" % "test"
)

scalapropsSettings
scalapropsVersion := "0.1.6"

