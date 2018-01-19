name := "how_to_mock_a_java_static_class_from_scala"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.5",
  "org.apache.commons" % "commons-lang3" % "3.6",
  "org.apache.logging.log4j" % "log4j-api" % "2.8.2",
  "org.apache.logging.log4j" % "log4j-core" % "2.8.2"
)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.4" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test,
  "org.powermock" % "powermock-api-mockito" % "1.7.3" % Test,
  "org.powermock" % "powermock-module-junit4" % "1.7.3" % Test
)
