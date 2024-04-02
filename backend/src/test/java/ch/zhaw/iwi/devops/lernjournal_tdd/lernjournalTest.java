package ch.zhaw.iwi.devops.lernjournal_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lernjournalTest {
    
    private Scorekeeper scorekeeper;
    
    @BeforeEach
    //Initial Scorekeeper class
    public void initializeScorekeeper(){
        scorekeeper = new Scorekeeper();
    }
    
    @Test
    // Test if the initial score is 000:000
    public void initialscoreTest(){
        // Get the initial score
        String initialScore = scorekeeper.getScore();

        // Assert that the initial score is "000:000"
        assertEquals("000:000", initialScore);
    }
  
    @Test
    // Test if the the programm can correctly record scores for team A
    public void scoreTeamATest(){
       
        scorekeeper.scoreTeamA1();
        scorekeeper.scoreTeamA2();
        scorekeeper.scoreTeamA3();
        assertEquals("006:000", scorekeeper.getScore());

    }

    @Test
    // Test if the the programm can correctly record scores for team B
    public void scoreTeamBTest(){
        
        scorekeeper.scoreTeamB1();
        scorekeeper.scoreTeamB2();
        scorekeeper.scoreTeamB3();
        assertEquals("000:006", scorekeeper.getScore());

    }

    @Test
    // Test if the the programm can undo the last score that has been entered
    public void undoLastscoreTest(){
        
        scorekeeper.scoreTeamA3();
        scorekeeper.scoreTeamB2();
        scorekeeper.scoreTeamB1();

        scorekeeper.undoLastscore();
        assertEquals("003:002", scorekeeper.getScore());

    }

    @Test
    // Test if the the programm can deduct points from the scoreboard
    public void deductPointsTest(){
        
        scorekeeper.scoreTeamA3();
        scorekeeper.scoreTeamB2();
        scorekeeper.scoreTeamB1();

        scorekeeper.deductPointsTeamX("A",2);
        scorekeeper.deductPointsTeamX("B",3);

        assertEquals("001:000", scorekeeper.getScore());

    }

    @Test
    // Test that the deductPoints function is limited by to non-negative numbers
    public void notNegativeTest(){
        
        scorekeeper.scoreTeamA3();
        scorekeeper.scoreTeamB2();
        scorekeeper.scoreTeamB1();

        scorekeeper.deductPointsTeamX("A", 4);
        scorekeeper.deductPointsTeamX("B",4);

        assertEquals("003:003", scorekeeper.getScore());

    }

    @Test
    // Test if the the programm can correctly spot Team A as the winner
    public void winnerTeamATest(){
        
        scorekeeper.scoreTeamA3();
        scorekeeper.scoreTeamB2();

        assertEquals("Team A", scorekeeper.getWinner());

    }

    @Test
    // Test if the the programm can correctly spot Team B as the winner
    public void winnerTeamBTest(){
        
        scorekeeper.scoreTeamA2();
        scorekeeper.scoreTeamB3();

        assertEquals("Team B", scorekeeper.getWinner());

    }  
    
    @Test
    // Test if the the programm can correctly spot a tie
    public void tieTest(){
        
        scorekeeper.scoreTeamA3();
        scorekeeper.scoreTeamB3();

        assertEquals("it's a tie!", scorekeeper.getWinner());

    }    

    @Test
    // Test boundary cases: extreme values
    public void extremeValuesTest(){
        
        while(scorekeeper.getScoreteamA() < 1001 || scorekeeper.getScoreteamB() < 1001){
            scorekeeper.scoreTeamA1();
            scorekeeper.scoreTeamB1();
        }

        assertEquals("scores are bound to 3 digits", scorekeeper.getScore());

    }      
}
