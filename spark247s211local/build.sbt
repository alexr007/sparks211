val sparkVersion = "2.4.7"

version := "0.0.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql"  % sparkVersion,
//  "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.2", // 2.11, DOESN'T WORK with 6.8
//  "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.3", // 2.11, DOESN'T WORK with 6.8
//  "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.0", // 2.11, DOESN'T WORK with 6.8
//  "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.1", // 2.11, DOESN'T WORK with 6.8
//  "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.2", // 2.11 + 2.12, works with DSE 6.8
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.4.3", // 2.11 + 2.12, works with DSE 6.8
)

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "_" + sv.binary + "-" + sparkVersion + "_" + module.revision + "." + artifact.extension
}

// do not put scala standard library into fat JAR
//assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)
//assembly / assemblyMergeStrategy := { (old) => MergeStrategy.rename }
