package hangman;

import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerBonusScore;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {
    private final OriginalScore originalScore = new OriginalScore();
    private final BonusScore bonusScore = new BonusScore();
    private final PowerBonusScore powerBonusScore = new PowerBonusScore();

 //OriginalScore

    // Start score should be 100
    @Test
    public void validateOriginalScoreStartScore(){
        int score = originalScore.calculateScore(0,0);

        Assert.assertEquals(100,score);
    }

    // Score should be correctly calculated
    // startScore = 100, incorrectCount = 5, penalizationScore = incorrectCount * 10, score = 50
    @Test
    public void validateOriginalScoreCalculateScore(){
        int score = originalScore.calculateScore(0,5);

        Assert.assertEquals(50,score);
    }

    // Score shouldn't be negative, minimum is 0
    @Test
    public void validateOriginalScoreNegativeScore(){
        int score = originalScore.calculateScore(0,15);

        Assert.assertEquals(0,score);
    }

    // Score should not give bonus for correctCount
    @Test
    public void validateOriginalScoreNoCorrectCountBonus(){
        int score = originalScore.calculateScore(20,1);

        Assert.assertEquals(90,score);
    }


  //BonusScore

    // Start score should be 0
    @Test
    public void validateBonusScoreStartScore(){
        int score = bonusScore.calculateScore(0,0);

        Assert.assertEquals(0,score);
    }

    // Score should be correctly calculated
    // startScore = 0, incorrectCount = 5, correctCount = 4, bonus = correctCount * 10, penalty = incorrectCount * 5,  score = bonus-penalty = 15
    @Test
    public void validateBonusScoreCalculateScore(){
        int score = bonusScore.calculateScore(4,5);

        Assert.assertEquals(15,score);
    }

    // Score shouldn't be negative, minimum is 0
    @Test
    public void validatebonusScoreNegativeScore(){
        int score = bonusScore.calculateScore(0,15);

        Assert.assertEquals(0,score);
    }


  //PowerScore

    // Start score should be 0
    @Test
    public void validatePowerBonusScoreStartScore(){
        int score = powerBonusScore.calculateScore(0,0);

        Assert.assertEquals(0,score);
    }

    // Score should be correctly calculated
    // startScore = 0, incorrectCount = 2, correctCount = 2, bonus = 5 ** correctCount, penalty = incorrectCount * 8,  score = bonus-penalty = 9
    @Test
    public void validatePowerBonusScoreCalculateScore(){
        int score = powerBonusScore.calculateScore(2,2);

        Assert.assertEquals(9,score);
    }

    // Score shouldn't be negative, minimum is 0
    @Test
    public void validatePowerBonusScoreNegativeScore(){
        int score = powerBonusScore.calculateScore(0,15);

        Assert.assertEquals(0,score);
    }

    // Maximum score should be 500
    @Test
    public void validatePowerBonusScoreMaxScore(){
        int score = powerBonusScore.calculateScore(20,0);

        Assert.assertEquals(500,score);
    }
}
