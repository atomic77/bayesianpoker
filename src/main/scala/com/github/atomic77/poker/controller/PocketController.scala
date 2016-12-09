package com.github.atomic77.poker.controller

import com.github.atomic77.poker.hand.{Card, Pocket}
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
  * Created by atomic on 12/7/16.
  */
@RestController
class PocketController {

  @RequestMapping(Array("/pocket"))
  def pocket() : Pocket = {

    val p = new Pocket()
    p.addCard(new Card("9_c"))
    p.addCard(new Card("9_h"))
    return p
  }
}
