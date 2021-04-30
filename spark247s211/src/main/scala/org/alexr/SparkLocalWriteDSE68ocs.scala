package org.alexr

import org.alexr.data.Data.people
import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkLocalWriteDSE68ocs {

  def cassandraHosts(env: String) = (1 to 3)
    .map(h => s"dse-$h.$env.sdw.ocs").mkString(",")

  val cassandraDriver = "org.apache.spark.sql.cassandra"

  val cassandraConnection = Map(
//    "spark.cassandra.connection.host" -> "10.104.2.83",
//    "spark.cassandra.connection.host" -> "dse-1.staging.sdw.ocs",
//    "spark.cassandra.connection.host" -> "dse-1.staging.sdw.ocs,dse-2.staging.sdw.ocs,dse-3.staging.sdw.ocs",
    "spark.cassandra.connection.host" -> cassandraHosts("staging"),
    "spark.cassandra.connection.port" -> "9042",
    "spark.cassandra.auth.username"-> "...",
    "spark.cassandra.auth.password" -> "..."
  )

  val cassandraTableDetails = Map(
    "keyspace" -> "space68",
    "table" -> "person"
  )

  val line = "=" * 50

  def debug(message: String) = {
    println(line)
    println(message)
    println(line)
  }

  def code = {

    debug(" cassandra:  ")
    debug(cassandraHosts("staging"))
    debug("  session builder  ")

    val spark = SparkSession.builder
      .appName("Example #2")
      .master("local")
      .getOrCreate()

    val df = spark
      .createDataFrame(people)

    df.printSchema()

    debug("  writing...  ")

    df.write
      .format(cassandraDriver)
      .options(cassandraConnection)
      .options(cassandraTableDetails)
      .mode(SaveMode.Append)
      .save()

    debug("  closing...  ")

    spark.close()

    debug("  done.  ")
  }

  def main(args: Array[String]): Unit = code

}
