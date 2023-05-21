import java.util.*;

import org.junit.Test;
import org.junit.Assert;

public class SolutionTest {
  @Test
  public void testCalcEquationTwoNodesQueriTwoSameNodes() {
    Solution solution = new Solution();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<String>());
    equations.get(0).add("a");
    equations.get(0).add("b");
    List<List<String>> queris = new ArrayList<>();
    queris.add(new ArrayList<String>());
    queris.get(0).add("a");
    queris.get(0).add("a");
    queris.add(new ArrayList<String>());
    queris.get(1).add("b");
    queris.get(1).add("b");
    double[] values = { 2 };
    double[] ans = { 1.0, 1.0 };

    double[] res = solution.calcEquation(equations, values, queris);

    Assert.assertEquals(ans[0], res[0], 0.1);
    Assert.assertEquals(ans[1], res[1], 0.1);
  }

  @Test
  public void test4() {
    Solution solution = new Solution();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<String>());
    equations.get(0).add("a");
    equations.get(0).add("b");
    List<List<String>> queris = new ArrayList<>();
    queris.add(new ArrayList<String>());
    queris.get(0).add("a");
    queris.get(0).add("b");
    queris.add(new ArrayList<String>());
    queris.get(1).add("b");
    queris.get(1).add("a");
    queris.add(new ArrayList<String>());
    queris.get(2).add("a");
    queris.get(2).add("a");
    queris.add(new ArrayList<String>());
    queris.get(3).add("b");
    queris.get(3).add("b");
    queris.add(new ArrayList<String>());
    queris.get(4).add("x");
    queris.get(4).add("r");
    double[] values = { 2 };
    double[] ans = { 2.0, 0.5, 1.0, 1.0, -1.0 };

    double[] res = solution.calcEquation(equations, values, queris);

    Assert.assertEquals(ans[0], res[0], 0.1);
    Assert.assertEquals(ans[1], res[1], 0.1);
    Assert.assertEquals(ans[2], res[2], 0.1);
    Assert.assertEquals(ans[3], res[3], 0.1);
    Assert.assertEquals(ans[4], res[4], 0.1);
  }

  @Test
  public void test1() {
    Solution solution = new Solution();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<String>());
    equations.get(0).add("a");
    equations.get(0).add("b");
    equations.add(new ArrayList<String>());
    equations.get(1).add("b");
    equations.get(1).add("c");
    List<List<String>> queris = new ArrayList<>();
    queris.add(new ArrayList<String>());
    queris.get(0).add("a");
    queris.get(0).add("c");
    queris.add(new ArrayList<String>());
    queris.get(1).add("b");
    queris.get(1).add("a");
    queris.add(new ArrayList<String>());
    queris.get(2).add("a");
    queris.get(2).add("e");
    queris.add(new ArrayList<String>());
    queris.get(3).add("a");
    queris.get(3).add("a");
    queris.add(new ArrayList<String>());
    queris.get(4).add("x");
    queris.get(4).add("x");
    double[] values = { 2, 3 };
    double[] ans = { 6, 0.5, -1, 1, -1 };

    double[] res = solution.calcEquation(equations, values, queris);

    Assert.assertEquals(ans[0], res[0], 0.1);
    Assert.assertEquals(ans[1], res[1], 0.1);
    Assert.assertEquals(ans[2], res[2], 0.1);
    Assert.assertEquals(ans[3], res[3], 0.1);
    Assert.assertEquals(ans[4], res[4], 0.1);
  }

  @Test
  public void test2() {
    Solution solution = new Solution();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<String>());
    equations.get(0).add("a");
    equations.get(0).add("b");
    equations.add(new ArrayList<String>());
    equations.get(1).add("b");
    equations.get(1).add("c");
    equations.add(new ArrayList<String>());
    equations.get(2).add("bc");
    equations.get(2).add("cd");
    List<List<String>> queris = new ArrayList<>();
    queris.add(new ArrayList<String>());
    queris.get(0).add("a");
    queris.get(0).add("c");
    queris.add(new ArrayList<String>());
    queris.get(1).add("c");
    queris.get(1).add("b");
    queris.add(new ArrayList<String>());
    queris.get(2).add("bc");
    queris.get(2).add("cd");
    queris.add(new ArrayList<String>());
    queris.get(3).add("cd");
    queris.get(3).add("bc");
    double[] values = { 1.5, 2.5, 5 };
    double[] ans = { 3.75, 0.4, 5, 0.2 };

    double[] res = solution.calcEquation(equations, values, queris);

    Assert.assertEquals(ans[0], res[0], 0);
    Assert.assertEquals(ans[1], res[1], 0);
    Assert.assertEquals(ans[2], res[2], 0);
    Assert.assertEquals(ans[3], res[3], 0);
  }

  @Test
  public void test3() {
    Solution solution = new Solution();
    List<List<String>> equations = new ArrayList<>();
    equations.add(new ArrayList<String>());
    equations.get(0).add("a");
    equations.get(0).add("b");
    List<List<String>> queris = new ArrayList<>();
    queris.add(new ArrayList<String>());
    queris.get(0).add("a");
    queris.get(0).add("b");
    queris.add(new ArrayList<String>());
    queris.get(1).add("b");
    queris.get(1).add("a");
    queris.add(new ArrayList<String>());
    queris.get(2).add("a");
    queris.get(2).add("c");
    queris.add(new ArrayList<String>());
    queris.get(3).add("x");
    queris.get(3).add("y");
    double[] values = { 0.5 };
    double[] ans = { 0.5, 2, -1, -1 };

    double[] res = solution.calcEquation(equations, values, queris);

    Assert.assertEquals(ans[0], res[0], 0);
    Assert.assertEquals(ans[1], res[1], 0);
    Assert.assertEquals(ans[2], res[2], 0);
    Assert.assertEquals(ans[3], res[3], 0);
  }
}
