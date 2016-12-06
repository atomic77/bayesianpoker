package ch.usi.tomica.poker.hand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by atomic on 12/5/16.
 */
class CardTest {
    @BeforeEach
    void setUp() {
        System.out.printf("Before");
    }

    @AfterEach
    void tearDown() {
        System.out.printf("After");

    }

    @Test
    void isSameSuit() {
        Card c1 = new Card(40);
        Card c2 = new Card(40);
        assertTrue(c1.isSameSuit(c2));
    }

    @Test
    void isSameRank() {

    }

}