package edu.acc.project4;

/**
 * @author Ryan Sprague
 */
public class Coin {
    String face;
    int correctGuessNum;
    int wrongGuessNum;
    int totalGuessNum;
    
    public Coin() {
        this.face = "";
        this.correctGuessNum = 0;
        this.wrongGuessNum = 0;
        this.totalGuessNum = 0;
    }
    
    public String getSideUp() {
        return this.face;
    }
    
    public int getWrongCount() {
        return this.wrongGuessNum;
    }
    
    public int getRightCount() {
        return this.correctGuessNum;
    }
    
    public int getTotalCount() {
        return this.totalGuessNum;
    }
    
    /**
     *
     * @return
     */
    public double getWinPercent() {
        return ((double)this.correctGuessNum / (double)this.totalGuessNum) * 100;
    }
    
    /**
     *
     * @param guess
     */
    public void incrementCounters(String guess) {
        this.totalGuessNum++;
        if (guess.equalsIgnoreCase(this.face)) {
            this.correctGuessNum++;
        } else {
            this.wrongGuessNum++;
        }
    }
    
    public void flip() {
        tossCoin();
    }
    
    private void tossCoin() {
        int coin;
        coin = (int)(1 + Math.random() * 2);
        if (coin == 1)
            this.face = "heads";
        else
            this.face = "tails";
    }
    
    
}
