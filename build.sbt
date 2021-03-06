Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / organization := "org.alexr"
ThisBuild / scalaVersion := "2.11.12"
name := "sparks211"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
//  "-Ymacro-annotations",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Xfatal-warnings",
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.4",
  "com.lihaoyi"       %% "fansi"                    % "0.2.12",
  "com.lihaoyi"       %% "upickle"                  % "1.3.11",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.7",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.7",
  "org.scalacheck"    %% "scalacheck"               % "1.15.2", // due to 2.11
)

lazy val common = (project in file("common"))

/** spark 2.3.0 + scala 2.11 */
lazy val spark230s211 = (project in file("spark230s211"))
  .dependsOn(common)

/** spark 2.3.4 + scala 2.11 */
lazy val spark234s211 = (project in file("spark234s211"))
  .dependsOn(common)

/** spark 2.4.7 + scala 2.11 % Provided */
lazy val spark247s211 = (project in file("spark247s211"))
  .dependsOn(common)
  .enablePlugins(JavaAppPackaging)


/** spark 2.4.7 + scala 2.11 */
lazy val spark247s211local = (project in file("spark247s211local"))
  .dependsOn(common)

lazy val whole = (project in file("."))
  .aggregate(
    common,
    spark230s211,
    spark234s211,
    spark247s211,
    spark247s211local,
  )
