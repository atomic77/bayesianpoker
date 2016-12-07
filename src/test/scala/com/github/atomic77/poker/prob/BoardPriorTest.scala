package com.github.atomic77.poker.prob

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterEach, FunSuite}


/**
  * Created by atomic on 12/6/16.
  */
class BoardPriorTest extends FunSuite with BeforeAndAfterEach {

  val NUM_SAMPLES = 1000

  def fixture =
    new {
      val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
      val conf = new SparkConf().setAppName("Test Application").setMaster("local")
      val sc = new SparkContext(conf)
    }

  test("testHuy") {
    val o = new BoardPrior(10)
    o.huy()
    assert(true)
  }

  test("testSpark") {

    val count = fixture.sc.parallelize(1 to NUM_SAMPLES).map{i =>
      val x = Math.random()
      val y = Math.random()
      if (x*x + y*y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / NUM_SAMPLES)
  }

}
