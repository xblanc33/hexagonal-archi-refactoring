package app;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import app.Player;


public class AppTest {

    @Test
    public void testPlayer() {
        Player alice = new Player("winner");
        Player bob = new Player("bob");
        assertFalse(alice.equals(bob));

        Player bobAgain = new Player("bob");
        assertTrue(bob.equals(bobAgain));

        Set<Player> playerSet = new HashSet<Player>();
        playerSet.add(alice);
        playerSet.add(bob);
        playerSet.add(bobAgain);
        assertTrue(playerSet.size() == 2);
    }

    @Test
    public void 

}