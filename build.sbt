name := "BayesianP"

version := "0.3"

//scalaVersion := "2.11.8"
//scalaVersion := "2.9.3"
//scalaVersion := "2.12.0"
scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "junit" % "junit" % "4.11",
//  "com.google.guava" % "guava" % "18.0",
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.apache.spark" %% "spark-core" % "2.0.2" exclude("org.slf4j","slf4j-log4j12") exclude("log4j", "log4j"),
  "org.springframework.boot" % "spring-boot-starter-web" % "1.4.2.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-test" % "1.4.2.RELEASE"
)

excludeDependencies := Seq(
  "org.slf4j" %% "slf4j-log4j12",
  "org.slf4j" %% "log4j-over-slf4j",
  "log4j" %% "log4j"
)

mainClass in (Compile,run) := Some("com.github.atomic77.poker.PokerRestApplication")

