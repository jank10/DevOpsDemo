package ch.zhaw.iwi.devops.lernjournal_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreboardTest {
   
    private Scoreboard scoreboard;

    //Create a @BeforeEach test to initialize a new Scoreboard every time the test is run
    @BeforeEach
    public void initializeScoreboard(){
        scoreboard = new Scoreboard();
    }
    
    @Test
    // Test if the initial score is 0:0
    public void initialscoreTest(){
        // Assert that the initial score is "0:0"
        assertEquals(0, scoreboard.getScoreteamA()+scoreboard.getScoreteamB());
    }

    @Test
    // Test that the programm can give back the score of both teams in the format "000:000"
    public void getFormattedscoreTest(){

        // Assert that the initial score is "0:0"
        assertEquals("000:000", scoreboard.getFormattedScore());
    }

    @Test
    // Test if the the programm can correctly record scores for team A
    public void scoreTeamATest(){
       
        scoreboard.scoreTeamA1();
        scoreboard.scoreTeamA2();
        scoreboard.scoreTeamA3();
        assertEquals("006:000", scoreboard.getFormattedScore());

    }

    @Test
    // Test if the the programm can correctly record scores for team A
    public void scoreTeamBTest(){
       
        scoreboard.scoreTeamB1();
        scoreboard.scoreTeamB2();
        scoreboard.scoreTeamB3();
        assertEquals("000:006", scoreboard.getFormattedScore());

    }
}
