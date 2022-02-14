package hangman.model;

public class OriginalScore implements GameScore{
    /**
     * Method for calculating the original score
     * @param correctCount Amount of correct letters given by the user
     * @param incorrectCount Amount of incorrect letters given by the user
     * @return Final Score
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount){
        int score = 100;
        int penalty = 10 * incorrectCount;

        score -= penalty;

        if (score < 0){
            score = 0;
        }

        return score;
    }
}
