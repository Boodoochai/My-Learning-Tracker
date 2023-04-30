import org.junit.Assert;
import org.junit.Test;

public class BracketSequenceTest {
    @Test
    public void isCorrectTestOnCorrectSequence() {
        String seq = "()";

        boolean res = BracketSequence.isCorrect(seq);

        Assert.assertTrue(res);
    }

    @Test
    public void isCorrectTestOnEmptySequence() {
        String seq = "";

        boolean res = BracketSequence.isCorrect(seq);

        Assert.assertTrue(res);
    }

    @Test
    public void isCorrectTestOnIncorrectSequence() {
        String seq = "((";

        boolean res = BracketSequence.isCorrect(seq);

        Assert.assertFalse(res);
    }

    @Test
    public void isCorrectTestOnLongCorrectSequence() {
        String seq = "(())(()())()()()((()())())";

        boolean res = BracketSequence.isCorrect(seq);

        Assert.assertTrue(res);
    }


    @Test
    public void isCorrectTestOnLongIncorrectSequence() {
        String seq = "()(((((()))))))";

        boolean res = BracketSequence.isCorrect(seq);

        Assert.assertFalse(res);
    }
}
