scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.6", "2.11.7")

scalacOptions ++= Seq("-feature")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

scalapropsSettings
scalapropsVersion := "0.2.1"
