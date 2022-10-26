package io.github.setl.factory

import io.github.setl.transformation.Factory
import org.apache.spark.sql.DataFrame
import io.github.setl.util.HasSparkSession
import io.github.setl.storage.connector.HudiConnector
import io.github.setl.config.Properties
import io.github.setl.annotation.Delivery
import org.apache.spark.sql.functions.lit

class ProcessFactory extends Factory[DataFrame] with HasSparkSession {

  @Delivery(id = "hudiReader")
  val hudiReaderConnector: HudiConnector = new HudiConnector(Properties.hudiReader)

  @Delivery(id = "hudiWriter")
  val hudiWriterConnector: HudiConnector = new HudiConnector(Properties.hudiWriter)

  var testObject: DataFrame = spark.emptyDataFrame
  var result: DataFrame = spark.emptyDataFrame

  override def read(): ProcessFactory.this.type = {
      testObject = hudiReaderConnector.read()

    this
  }
  
  override def process(): ProcessFactory.this.type = {
    result = testObject

    this
  }

  override def write(): ProcessFactory.this.type = {
    hudiWriterConnector.write(result)

    this
  }

  override def get(): DataFrame = spark.emptyDataFrame
}