package ch.zhaw.iwi.devops.lernjournal_tdd;

public class Scorekeeper {
    private int scoreTeamA;
    private int scoreTeamB;
    private int lastScorerecorded;
    private String lastTeamscored;

    public Scorekeeper() {
        // Initialize scores to 0
        scoreTeamA = 0;
        scoreTeamB = 0;
    }
    // Methods to record points for Team A
    public void scoreTeamA1(){
        scoreTeamA += 1;
        lastScorerecorded = 1;
        lastTeamscored = "A";
    }
    public void scoreTeamA2(){
        scoreTeamA += 2;
        lastScorerecorded = 2;
        lastTeamscored = "A";
    }
    public void scoreTeamA3(){
        scoreTeamA += 3;
        lastScorerecorded = 3;
        lastTeamscored = "A";
    }

    // Methods to record points for Team B
    public void scoreTeamB1(){
        scoreTeamB += 1;
        lastScorerecorded = 1;
        lastTeamscored = "B";
    }
    public void scoreTeamB2(){
        scoreTeamB += 2;
        lastScorerecorded = 2;
        lastTeamscored = "B";
    }
    public void scoreTeamB3(){
        scoreTeamB += 3;
        lastScorerecorded = 3;
        lastTeamscored = "B";
    }    

    // Method to get the current score in the format "000:000"
    public String getScore(){
        if(scoreTeamA < 1000 && scoreTeamB < 1000){
            return String.format("%03d:%03d", scoreTeamA, scoreTeamB);
        } else {
            return "scores are bound to 3 digits";
        }
    }

    //Methods to get the scores of the individual teams in data type int
    public int getScoreteamA(){
        return scoreTeamA;
    }
    public int getScoreteamB(){
        return scoreTeamB;
    }

    //Method to undo the last score that has been entered independent of which team has scored
    public void undoLastscore(){
        if(lastTeamscored.equals("A")){
            scoreTeamA -= lastScorerecorded;
        } else{
            scoreTeamB -= lastScorerecorded;
        }
    }

    //Methods to deduct points from the scoreboard
    public void deductPointsTeamX(String team ,int points){
        if(team.equals("A")){
            if(points > scoreTeamA){
                System.out.println("Error: score can't be negative.");
            }else{
                scoreTeamA -= points;
            } 
        } else if(team.equals("B")){
            if(points > scoreTeamB){
                System.out.println("Error: score can't be negative.");
            }else{
                scoreTeamB -= points;
            } 
        } else{
            System.out.println("Team not valid. Try again.");
        }
    }
    

    //Method to determine the winner
    public String getWinner(){
        if(scoreTeamA > scoreTeamB){
            return "Team A";
        } else if(scoreTeamA < scoreTeamB){
            return "Team B";
        } else{
            return "it's a tie!";
        }
    }
}
