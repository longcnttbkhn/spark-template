ThisBuild / scalaVersion := "2.12.15"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  "spark_template_dev.jar"
}

lazy val root = (project in file("."))
  .settings(
    name := "SparkTemplate",
    assembly / assemblyJarName := "spark_template_assembly.jar",
    assemblyPackageDependency / assemblyJarName := "spark_template_deps.jar",
    assemblyPackageScala / assembleArtifact := false,

    assemblyPackageDependency / assemblyOption ~= {
      _.withIncludeScala(false)
    },
  )

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test
ThisBuild / assemblyMergeStrategy := {
  case PathList("org", "apache", "spark", "unused", "UnusedStubClass.class", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}

Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated

