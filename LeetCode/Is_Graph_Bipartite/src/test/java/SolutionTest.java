import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void testNotBipartite() {
    Solution solution = new Solution();
    Assert.assertFalse(solution.isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }));
  }

  @Test
  public void testBipartite() {
    Solution solution = new Solution();
    Assert.assertTrue(solution.isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));
  }

  @Test
  public void testConnectedBipartite() {
    Solution solution = new Solution();
    Assert.assertFalse(solution.isBipartite(new int[][] { {}, { 2, 4, 6 }, { 1, 4, 8, 9 }, { 7, 8 }, { 1, 2, 8, 9 },
        { 6, 9 }, { 1, 5, 7, 8, 9 }, { 3, 6, 9 }, { 2, 3, 4, 6, 9 }, { 2, 4, 5, 6, 7, 8 } }));
  }
}
