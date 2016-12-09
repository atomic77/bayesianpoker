package com.github.atomic77.poker.controller

import java.util.concurrent.atomic.AtomicInteger

import com.github.atomic77.poker.hand.Game
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestParam, RestController}

import scala.collection.mutable.HashMap

@RestController
class GameController {

  val seq = new AtomicInteger()
  val games = new HashMap[Int, Game]

  @RequestMapping(Array("/game"))
  def game() : Game = {
    val id = seq.incrementAndGet()
    val g = new Game(2, id);
    games += (id -> g)
    return g
  }

  @RequestMapping(Array("/game/{id}"))
  def nextRound(@RequestParam("nextRound") nextRound : Boolean,
                @PathVariable id : Int) : Game = {
    val g = games(id)
    if (nextRound) {
      g.nextRound()
    }

    return g
  }
}
