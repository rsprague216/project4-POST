package edu.acc.project4;

/**
 * @author Ryan Sprague
 */
public class RPSLS {
    private int userIndex, computerIndex;
    private final String[][] plays = {{"rock", "lizard", "scissors"},
        {"lizard", "spock", "paper"},
        {"spock", "rock", "scissors"},
        {"scissors", "paper", "lizard"},
        {"paper", "rock", "spock"}};
    private int tiedGuessNum = 0;
    private int correctGuessNum = 0;
    private int wrongGuessNum = 0;
    private int totalGuessNum = 0;
    private String gameResult;
    
    public String getHand() {
        return this.plays[computerIndex][0];
    }
    
    public String getUserHand() {
        return this.plays[userIndex][0];
    }
    
    public int getTiedCount() {
        return this.tiedGuessNum;
    }
    
    public int getWrongCount() {
        return this.wrongGuessNum;
    }
    
    public int getCorrectCount() {
        return this.correctGuessNum;
    }
    
    public int getTotalCount() {
        return this.totalGuessNum;
    }
    
    public double getWinPercent() {
        return ((double)this.correctGuessNum / (double)this.totalGuessNum) * 100;
    }
    
    public void incrementCounters() {
        this.totalGuessNum++;
        if (checkIfWon().equals("tied"))
            this.tiedGuessNum++;
        else if (checkIfWon().equals("won"))
            this.correctGuessNum++;
        else
            this.wrongGuessNum++;
    }
    
    public void playHand() {
        hand();
    }
    
    private void hand() {
        computerIndex = (int)(Math.random() * 5);
    }
    
    public String checkIfWon() {
        String gameResult;
        if (userIndex == computerIndex)
            gameResult = "tied";
        else if (plays[computerIndex][0].equals(plays[userIndex][1]) || plays[computerIndex][0].equals(plays[userIndex][2]))
            gameResult = "won";
        else
            gameResult = "lost";
        
        return gameResult;
    }
    
    public void getIndexOf(String userPlay) {
        for (int index = 0; index < plays.length; index++) {
            if (userPlay.equalsIgnoreCase(plays[index][0]))
                this.userIndex = index;
        }
    }
}
