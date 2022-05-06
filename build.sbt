name         := "cs2inclass"
organization := "trinity"
version      := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scalafx"   %% "scalafx"   % "16.0.0-R24",
  "com.github.sbt" % "junit-interface" % "0.13.2" % Test,
  "org.scalatest" %% "scalatest" % "3.2.9" % "test"//, //http://www.scalatest.org/download
  //"org.scala-lang.modules" %% "scala-parallel-collections" % "2.13.5"
)
libraryDependencies ++= javaFXModules

// Add JavaFX dependencies
lazy val javaFXModules = {
  // Determine OS version of JavaFX binaries
  lazy val osName = System.getProperty("os.name") match {
    case n if n.startsWith("Linux")   => "linux"
    case n if n.startsWith("Mac")     => "mac"
    case n if n.startsWith("Windows") => "win"
    case _                            => throw new Exception("Unknown platform!")
  }
  Seq("base", "controls", "fxml", "graphics", "media", "swing", "web").map( m=>
    "org.openjfx" % s"javafx-$m" % "11" classifier osName
  )
}

// Fork a new JVM for 'run' and 'test:run' to avoid JavaFX double initialization problems
fork := true
// 
connectInput := true

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
//Compile / run / mainClass := Some("cs2.net.ChatProgram")
