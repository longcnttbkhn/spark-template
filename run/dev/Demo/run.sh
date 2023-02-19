spark-submit --class Main \
    --master local[*] \
    --deploy-mode client \
    --driver-memory 2g \
    --executor-memory 2g \
    --executor-cores 2 \
    --num-executors 1 \
    --conf spark.dynamicAllocation.enabled=false \
    --conf spark.scheduler.mode=FAIR \
    --files ./application.properties \
    ../spark_template_dev.jar \
    application.properties &