name := "jubatus"

version := "0.1"

scalaVersion := "2.11.8"

mainClass in (Compile, run) := Some("org.mephys.jubatus.Jubatus")

publishMavenStyle := true

assemblyJarName in assembly := "something.jar"