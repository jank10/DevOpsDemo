package ch.zhaw.iwi.devops.lernjournal_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ScoreboardTest {
    
        @Test
    // Test if the initial score is 000:000
    public void initialscoreTest(){
        // Get the initial score
        String initialScore = scorekeeper.getScore();

        // Assert that the initial score is "000:000"
        assertEquals("000:000", initialScore);
}
