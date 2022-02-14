package hangman.model.dictionary;

import hangman.model.GameScore;

public class PowerBonusScore implements GameScore {
    /**
     * Method for calculating the power bonus score
     * @param correctCount Amount of correct letters given by the user
     * @param incorrectCount Amount of incorrect letters given by the user
     * @return Final Score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount){
        int score = 0;
        double bonus = 0;
        for (int i=0; i <= correctCount; i++){
            bonus = Math.pow(5, i);
        }

        double penalty = 8 * incorrectCount;
        score += bonus;
        score -= penalty;

        if (score < 0){
            score = 0;
        }

        if (score > 500){
            score = 500;
        }

        return score;
    }
}
