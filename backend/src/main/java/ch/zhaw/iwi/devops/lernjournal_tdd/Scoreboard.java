package ch.zhaw.iwi.devops.lernjournal_tdd;

public class Scoreboard {
    
    private int scoreTeamA;
    private int scoreTeamB;

    public Scoreboard() {
        // Initialize scores to 0
        scoreTeamA = 0;
        scoreTeamB = 0;
    }

    //Methods to get the scores of the individual teams in data type int
    public int getScoreteamA(){
        return scoreTeamA;
    }
    public int getScoreteamB(){
        return scoreTeamB;
    }

    // Method to get the current score of both teams in the format "000:000"
    public String getFormattedScore(){
            return String.format("%03d:%03d", scoreTeamA, scoreTeamB);
    }

    // Methods to record points for Team A
    public void scoreTeamA1(){
        scoreTeamA += 1;
    }
    public void scoreTeamA2(){
        scoreTeamA += 2;
    }
    public void scoreTeamA3(){
        scoreTeamA += 3;
    }

    // Methods to record points for Team B
     public void scoreTeamB1(){
        scoreTeamB += 1;
    }
    public void scoreTeamB2(){
        scoreTeamB += 2;
    }
    public void scoreTeamB3(){
        scoreTeamB += 3;
    }

}
