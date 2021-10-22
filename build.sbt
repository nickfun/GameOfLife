name := "Game of life"
version := "0.1"
organization := "game.life"

// javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.11", "-g:lines")

crossPaths := false // drop off Scala suffix from artifact names.
autoScalaLibrary := false // exclude scala-library from dependencies


// set the main class for packaging the main jar
mainClass in (Compile, packageBin) := Some("game.life.GameOfLifeFrame")

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("game.life.GameOfLifeFrame")
