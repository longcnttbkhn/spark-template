# Spark template

## Author
[Long Nguyen](longcnttbkhn.github.io)

## Requirement

- Scala 2.12.15
- Spark 3.1.2
- sbt: 1.8.3

## Build

```bash
$ sbt package
```

## Run dev

```bash
$ cp target/scala-2.12/spark_template_dev.jar run/dev/
$ cd run/dev/<JobName>
$ ./run.sh
```

## Run production

```bash
$ cp run/dev/spark_template_dev.jar run/product/spark_template.jar
$ cd run/product/<JobName>
$ ./run.sh
```