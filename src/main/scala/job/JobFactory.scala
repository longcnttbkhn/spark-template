package job

import job.sql.Demo

object JobFactory {
  def createJob(name: String): JobInf = {
    name match {
      case "Demo" => Demo
    }
  }
}
