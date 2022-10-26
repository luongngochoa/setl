package io.github.setl.config

import com.typesafe.config.Config

object Properties {
  val cl: ConfigLoader = ConfigLoader
    .builder()
    .setProperty("myvalue", "test-my-value")
    .setConfigPath("application.conf")
    .getOrCreate()

  val hudiReader: Config = cl.getConfig("hudiReader")
  val hudiWriter: Config = cl.getConfig("hudiWriter")
}