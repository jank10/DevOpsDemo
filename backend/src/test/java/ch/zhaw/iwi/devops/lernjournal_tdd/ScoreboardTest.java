package ch.zhaw.iwi.devops.lernjournal_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ScoreboardTest {
   
    private Scoreboard scoreboard;
    
    @Test
    // Test if the initial score is 0:0
    public void initialscoreTest(){
        // Get the initial score
        scoreboard = new Scoreboard();

        // Assert that the initial score is "0:0"
        assertEquals(0, scoreboard.getScoreteamA()+scoreboard.getScoreteamB());
    }
}
