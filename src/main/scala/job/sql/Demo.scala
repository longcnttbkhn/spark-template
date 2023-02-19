package job.sql

import java.util.Properties

import job.JobInf
import org.apache.spark.sql.{SaveMode, SparkSession}

object Demo extends JobInf {
   def run(spark: SparkSession, properties: Properties): Unit = {
     val logData = spark.read.textFile(properties.getProperty("input")).cache()
     val numAs = logData.filter(line => line.contains("a")).count()
     val numBs = logData.filter(line => line.contains("b")).count()
     val df = spark.createDataFrame(Seq((numAs, numBs))).toDF("Num a", "Num b")
     df.write.mode(SaveMode.Overwrite).json(properties.getProperty("output"))
  }
}
