import java.io.FileInputStream
import java.util.Properties

import job.JobFactory
import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]) {
    val properties = new Properties
    properties.load(new FileInputStream(args(0)))
    val spark = SparkSession.builder
      .appName(properties.getProperty("app_name"))
      .getOrCreate()
    JobFactory.createJob(properties.getProperty("app_name")).run(spark, properties)
    spark.stop()
  }
}
