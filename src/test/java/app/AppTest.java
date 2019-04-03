package app;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import app.Player;
import app.PlayerDB;


public class AppTest {

    @Test
    public void testPlayer() {
        Player alice = new Player("alice");
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
    public void testPlayerDB() {
        try {
            Player alice = new Player("alice");
            PlayerDB db = new PlayerDB();
            Set<Player> playerSetBefore = db.getPlayerSet();
            db.add(alice);
            Set<Player> playerSet = db.getPlayerSet();
            System.out.println(playerSet.size());
            assertTrue(playerSet.size() == 15);
        } catch (ClassNotFoundException ex) {
            assertFalse(true);
        } catch (SQLException ex) {
            assertFalse(true);
        }
        
    }

}