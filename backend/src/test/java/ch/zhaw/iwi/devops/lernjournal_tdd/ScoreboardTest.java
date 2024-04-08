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

    @Test
    // Test if the the programm can undo the last score that has been entered
    public void undoLastscoreTest(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB2();
        scoreboard.scoreTeamB1();

        scoreboard.undoLastscore();
        assertEquals("003:002", scoreboard.getFormattedScore());

    }

    @Test
    // Test if the the programm can undo the last score that has been entered
    public void undoLastscoreTestteamA(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB2();
        scoreboard.scoreTeamA1();

        scoreboard.undoLastscore();
        assertEquals("003:002", scoreboard.getFormattedScore());
    }


    @Test
    // Test if the the programm can change any amount of points from the scoreboard
    public void deductPointsTest(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB2();
        scoreboard.scoreTeamB1();

        scoreboard.deductPointsTeamX("A",-2);
        scoreboard.deductPointsTeamX("B",-3);
        scoreboard.deductPointsTeamX("B",2);

        assertEquals("001:002", scoreboard.getFormattedScore());

    }

    @Test
    // Test that the deductPoints function can't make the total score negative
    public void notNegativeTest(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB2();
        scoreboard.scoreTeamB1();

        scoreboard.deductPointsTeamX("A", -4);
        scoreboard.deductPointsTeamX("B",-4);

        assertEquals("003:003", scoreboard.getFormattedScore());

    }

    @Test
    // Test boundary cases: extreme values. The score cannot be 4 digits
    public void extremeValuesTest(){
        
        while(scoreboard.getScoreteamA() < 1001 || scoreboard.getScoreteamB() < 1001){
            scoreboard.scoreTeamA1();
            scoreboard.scoreTeamB1();
        }

        assertEquals("scores are bound to 3 digits", scoreboard.getFormattedScore());

    }  

    @Test
    // Test if the the programm can correctly spot Team A as the winner
    public void winnerTeamATest(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB2();

        assertEquals("Team A", scoreboard.getWinner());

    }

    @Test
    // Test if the the programm can correctly spot Team B as the winner
    public void winnerTeamBTest(){
        
        scoreboard.scoreTeamA2();
        scoreboard.scoreTeamB3();

        assertEquals("Team B", scoreboard.getWinner());

    }

    @Test
    // Test if the the programm can correctly spot a tie
    public void tieTest(){
        
        scoreboard.scoreTeamA3();
        scoreboard.scoreTeamB3();

        assertEquals("it's a tie!", scoreboard.getWinner());

    }    

}
