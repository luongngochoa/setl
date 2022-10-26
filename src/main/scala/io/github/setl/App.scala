package io.github.setl.extension

import io.github.setl.Setl
import java.nio.file.Paths
import io.github.setl.{SparkSessionBuilder}
import org.apache.spark.sql.{SaveMode, SparkSession}
import io.github.setl.config.ConfigLoader
import io.github.setl.storage.connector.HudiConnector
import io.github.setl.config.Properties
import io.github.setl.factory.ProcessFactory

object App {
  def main(args: Array[String]): Unit = {
    println("Logs for: setl0")
    val setl: Setl = Setl.builder()
      .withDefaultConfigLoader("application.conf")
      .getOrCreate()

    setl
      .setConnector("hudiReader", deliveryId = "hudiReader")
      .setConnector("hudiWriter", deliveryId = "hudiWriter")

    setl
      .newPipeline()
      .addStage[ProcessFactory]()
      .run()
  }
}