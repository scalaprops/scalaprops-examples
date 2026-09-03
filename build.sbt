scalaVersion := "2.12.21"

crossScalaVersions := Seq("2.12.21", "2.13.18", "3.9.0")

scalacOptions ++= Seq("-feature")

scalacOptions ++= {
  scalaBinaryVersion.value match {
    case "3" =>
      Nil
    case _ =>
      Seq("-Xsource:3")
  }
}

scalapropsSettings
scalapropsVersion := "0.11.1"
