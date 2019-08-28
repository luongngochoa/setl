package com.jcdecaux.datacorp.spark.workflow

import com.jcdecaux.datacorp.spark.internal.HasDescription

import scala.reflect.runtime

/**
  * Flow is a representation of the data transfer in a Pipeline.
  *
  * @param payload type of the transferred data
  * @param from    origin node of the transfer
  * @param to      destination node of the transfer
  * @param stage   stage where the transfer occurs
  */
private[workflow] case class Flow(payload: runtime.universe.Type,
                                  from: Node,
                                  to: Node, stage: Int) extends HasDescription {
  override def describe(): this.type = {
    println("Flow")
    println(s"Stage     : $stage")
    println(s"Direction : ${from.getPrettyName} ==> ${to.getPrettyName}")
    println(s"PayLoad   : ${getPrettyName(payload)}")
    println("--------------------------------------")
    this
  }
}
