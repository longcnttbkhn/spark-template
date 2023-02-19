package job

import java.util.Properties

import org.apache.spark.sql.SparkSession

trait JobInf {
  def run(spark: SparkSession, properties: Properties): Unit
}
