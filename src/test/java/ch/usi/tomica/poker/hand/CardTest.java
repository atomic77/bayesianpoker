package ch.usi.tomica.poker.hand;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by atomic on 12/5/16.
 */
public class CardTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isSameSuit() throws Exception {
        Card c1 = new Card(40);
        Card c2 = new Card(40);
        assertTrue(c1.isSameSuit(c2));
    }

    @Test
    public void testStringBasedCreation() throws Exception {
        Card c = new Card("9_c");
        assertEquals(c.toString(), "9_c");
        c = new Card("T_s");
        assertEquals(c.toString(), "T_s");
        c = new Card("A_s");
        assertEquals(c.toString(), "A_s");
        c = new Card("3_h");
        assertEquals(c.toString(), "3_h");
    }

    @Test
    public void isSameRank() throws Exception {

    }


}