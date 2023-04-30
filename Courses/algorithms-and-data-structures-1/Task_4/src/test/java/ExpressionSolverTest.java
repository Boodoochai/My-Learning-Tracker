import org.junit.Assert;
import org.junit.Test;

public class ExpressionSolverTest {
    @Test
    public void solveTestSimpleExpression() {
        String expr = "1 =";
        Integer ans = 1;

        Integer res = ExpressionSolver.solve(expr);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void solveTestEquals() {
        String expr = "23 =";
        int ans = 23;

        int res = ExpressionSolver.solve(expr);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void solveTestAddition() {
        String expr = "23 36 + =";
        int ans = 59;

        int res = ExpressionSolver.solve(expr);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void solveTestMultiplication() {
        String expr = "71 -38 * =";
        int ans = -2698;

        int res = ExpressionSolver.solve(expr);

        Assert.assertEquals(res, ans);
    }

    @Test
    public void solveTestLongExpression() {
        String expr = "7 5 + 3 * 4 5 + * =";
        int ans = 324;

        int res = ExpressionSolver.solve(expr);

        Assert.assertEquals(res, ans);
    }
}
