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

}
