package hangman.model;

public class BonusScore implements GameScore{
    /**
     * Method for calculating the bonus score
     * @param correctCount Amount of correct letters given by the user
     * @param incorrectCount Amount of incorrect letters given by the user
     * @return Final Score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount){
        int score = 0;
        int bonus = 10 * correctCount;
        int penalty = 5 * incorrectCount;

        score = bonus - penalty;

        if (score < 0){
            score = 0;
        }

        return score;
    }
}
