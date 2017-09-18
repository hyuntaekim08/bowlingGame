public class Game {
    int[] rolls = new int[21];
    private int currentRoll = 0;


    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int firstRollInAFrame = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isSpare(firstRollInAFrame)){
                score += 10 + nextBallForSpare(firstRollInAFrame);
                firstRollInAFrame += 2;
            }else if(isStrike(firstRollInAFrame)){
                score += 10 + nextBallsForStrike(firstRollInAFrame);
                firstRollInAFrame +=1;
            } else {
                score += nextBallsForFrame(firstRollInAFrame);
                firstRollInAFrame += 2;
            }
        }
        return score;
    }

    private int nextBallsForFrame(int firstRollInAFrame) {
        return rolls[firstRollInAFrame] + rolls[firstRollInAFrame + 1];
    }

    private int nextBallsForStrike(int firstRollInAFrame) {
        return rolls[firstRollInAFrame + 1] + rolls[firstRollInAFrame + 2];
    }

    private int nextBallForSpare(int firstRollInAFrame) {
        return rolls[firstRollInAFrame + 2];
    }

    private boolean isStrike(int firstRollInAFrame) {
        return rolls[firstRollInAFrame] == 10;
    }

    private boolean isSpare(int firstRollInAFrame) {
        return rolls[firstRollInAFrame] + rolls[firstRollInAFrame+1] == 10;
    }
}
