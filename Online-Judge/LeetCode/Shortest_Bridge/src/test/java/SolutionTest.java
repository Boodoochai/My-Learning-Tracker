import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test1() {
    Solution solution = new Solution();
    Assert.assertEquals(solution.shortestBridge(new int[][] { { 0, 1 }, { 1, 0 } }), 1);
  }

  @Test
  public void test2() {
    Solution solution = new Solution();
    Assert.assertEquals(solution.shortestBridge(new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } }), 2);
  }

  @Test
  public void test3() {
    Solution solution = new Solution();
    Assert.assertEquals(solution.shortestBridge(
        new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } }),
        1);
  }
}
