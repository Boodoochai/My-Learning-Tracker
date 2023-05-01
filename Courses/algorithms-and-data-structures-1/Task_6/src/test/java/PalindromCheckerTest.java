import org.junit.Test;
import org.junit.Assert;

public class PalindromCheckerTest {
    @Test
    public void isPalindromTestNotPalindrom() {
        String str = "qwe";
        boolean ans = false;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestPalindromWithSingleLetterInMiddle() {
        String str = "qwewq";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestPalindromwithDoubleLetterInMIddle() {
        String str = "qweewq";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestEmptyString() {
        String str = "";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestLongPalindrom() {
        String str = "qwwwrttyttrwwwq";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestStringWithOneLetter() {
        String str = "q";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindromTestStringWithSameLetters() {
        String str = "gggg";
        boolean ans = true;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void isPalindomTestLongNotPalindrom() {
        String str = "qwrrrtrwq";
        boolean ans = false;

        boolean res = PalindromChecker.isPalindrom(str);

        Assert.assertEquals(res, ans);
    }
}
