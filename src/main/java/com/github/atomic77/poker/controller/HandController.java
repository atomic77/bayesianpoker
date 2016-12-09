package com.github.atomic77.poker.controller;


import java.util.concurrent.atomic.AtomicLong;

import com.github.atomic77.poker.hand.Hand;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by atomic on 12/7/16.
 */
@RestController
public class HandController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    static RandomDataGenerator randomData = new RandomDataGenerator();

    @RequestMapping("/hand")
    public Hand hand(@RequestParam(value="n", defaultValue="5") String n) {
        return Hand.generateRandomHand(Integer.parseInt(n), randomData);
    }

}
