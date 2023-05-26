import org.junit.Test;
import org.junit.Assert;

public class PowerSetTest {
  @Test
  public void sizeTestEmptySet() {
    PowerSet set = new PowerSet();

    Assert.assertEquals(set.size(), 0);
    Assert.assertEquals(set.size(), 0);
    Assert.assertEquals(set.size(), 0);
  }

  @Test
  public void sizeTestSetWithOneElement() {
    PowerSet set = new PowerSet();
    set.put("a");

    Assert.assertEquals(set.size(), 1);
    Assert.assertEquals(set.size(), 1);
    Assert.assertEquals(set.size(), 1);
  }

  @Test
  public void sizeTestSetWithManyElements() {
    PowerSet set = new PowerSet();
    set.put("a");
    set.put("b");
    set.put("c");

    Assert.assertEquals(set.size(), 3);
    Assert.assertEquals(set.size(), 3);
    Assert.assertEquals(set.size(), 3);
  }

  @Test
  public void putTestInEmptySet() {
    PowerSet set = new PowerSet();
    set.put("a");

    Assert.assertEquals(set.size(), 1);
    Assert.assertEquals(set.get("a"), true);
  }

  @Test
  public void putTestInNotEmptySet() {
    PowerSet set = new PowerSet();
    set.put("a");
    set.put("b");
    set.put("c");

    Assert.assertEquals(set.size(), 3);
    Assert.assertEquals(set.get("a"), true);
    Assert.assertEquals(set.get("b"), true);
    Assert.assertEquals(set.get("c"), true);
  }

  @Test
  public void putTestInEmptySetExistedElement() {
    PowerSet set = new PowerSet();
    set.put("a");
    set.put("a");
    set.put("a");

    Assert.assertEquals(set.size(), 1);
    Assert.assertEquals(set.get("a"), true);
  }

  @Test
  public void putTestInNotEmptySetExistedElement() {
    PowerSet set = new PowerSet();
    set.put("b");
    set.put("c");
    set.put("b");
    set.put("a");
    set.put("a");
    set.put("c");
    set.put("c");
    set.put("c");

    Assert.assertEquals(set.size(), 3);
    Assert.assertEquals(set.get("a"), true);
    Assert.assertEquals(set.get("b"), true);
    Assert.assertEquals(set.get("c"), true);
  }

  @Test
  public void getTestFromEmptySet() {
    PowerSet set = new PowerSet();

    Assert.assertEquals(set.get("a"), false);
    Assert.assertEquals(set.get("b"), false);
    Assert.assertEquals(set.get("c"), false);
    Assert.assertEquals(set.get("cdjskfdjs"), false);
    Assert.assertEquals(set.get("3124"), false);
  }

  @Test
  public void getTestFromNotEmptySetNotExistElements() {
    PowerSet set = new PowerSet();
    set.put("1");
    set.put("2");
    set.put("3");
    set.put("4");
    set.put("5");
    set.put("6");
    set.put("7");
    set.put("8");
    set.put("9");
    set.put("0");
    set.put("g");
    set.put("fjdklf");

    Assert.assertEquals(set.get("a"), false);
    Assert.assertEquals(set.get("b"), false);
    Assert.assertEquals(set.get("c"), false);
    Assert.assertEquals(set.get("cdjskfdjs"), false);
    Assert.assertEquals(set.get("3124"), false);
    Assert.assertEquals(set.get("11"), false);
    Assert.assertEquals(set.get("sgfsg"), false);
    Assert.assertEquals(set.get("ll"), false);
  }

  @Test
  public void getTestExistElement() {
    PowerSet set = new PowerSet();
    set.put("1");
    set.put("2");
    set.put("3");
    set.put("4");
    set.put("5");
    set.put("6");
    set.put("7");
    set.put("8");
    set.put("9");
    set.put("0");
    set.put("a");
    set.put("bghl");

    Assert.assertEquals(set.get("1"), true);
    Assert.assertEquals(set.get("2"), true);
    Assert.assertEquals(set.get("3"), true);
    Assert.assertEquals(set.get("4"), true);
    Assert.assertEquals(set.get("5"), true);
    Assert.assertEquals(set.get("6"), true);
    Assert.assertEquals(set.get("7"), true);
    Assert.assertEquals(set.get("8"), true);
    Assert.assertEquals(set.get("9"), true);
    Assert.assertEquals(set.get("0"), true);
    Assert.assertEquals(set.get("a"), true);
    Assert.assertEquals(set.get("bghl"), true);
  }

  @Test
  public void removeTestInEmptySet() {
    PowerSet set = new PowerSet();

    boolean res1 = set.remove("a");
    boolean res2 = set.remove("adgsdg");
    boolean res3 = set.remove("12");

    Assert.assertEquals(set.size(), 0);
    Assert.assertEquals(res1, false);
    Assert.assertEquals(res2, false);
    Assert.assertEquals(res2, false);
  }

  @Test
  public void removeTestInNotEmptySetNotExistElements() {
    PowerSet set = new PowerSet();
    set.put("b");
    set.put("c");
    set.put("sfdg");

    boolean res1 = set.remove("a");
    boolean res2 = set.remove("adgsdg");
    boolean res3 = set.remove("12");

    Assert.assertEquals(set.size(), 3);
    Assert.assertEquals(res1, false);
    Assert.assertEquals(res2, false);
    Assert.assertEquals(res2, false);
  }

  @Test
  public void removeTestExistElements() {
    PowerSet set = new PowerSet();
    set.put("b");
    set.put("c");
    set.put("sfdg");

    boolean res1 = set.remove("b");
    boolean res2 = set.remove("c");

    Assert.assertEquals(set.size(), 1);
    Assert.assertEquals(res1, true);
    Assert.assertEquals(res2, true);
    Assert.assertEquals(set.get("b"), false);
    Assert.assertEquals(set.get("c"), false);
    Assert.assertEquals(set.get("sfdg"), true);
  }

  @Test
  public void removeTestExistElementsMakeSetEmpty() {
    PowerSet set = new PowerSet();
    set.put("b");
    set.put("c");
    set.put("sfdg");

    boolean res1 = set.remove("b");
    boolean res2 = set.remove("c");
    boolean res3 = set.remove("sfdg");

    Assert.assertEquals(set.size(), 0);
    Assert.assertEquals(res1, true);
    Assert.assertEquals(res2, true);
    Assert.assertEquals(res3, true);
    Assert.assertEquals(set.get("b"), false);
    Assert.assertEquals(set.get("c"), false);
    Assert.assertEquals(set.get("sfdg"), false);
  }

  @Test
  public void intersectionTestNotEmptyWithEmpty() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("c");

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void intersectionTestTwoEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void intersectionTestTwoNotEmptySetsEmptyres() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("c");
    set2.put("d");
    set2.put("f");
    set2.put("g");

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void intersectionTestresHaveOneElement() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("c");
    set2.put("a");
    set2.put("f");
    set2.put("g");

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 1);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res2.size(), 1);
    Assert.assertEquals(res1.get("a"), true);
  }

  @Test
  public void intersectionTestresHaveMnyElements() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("c");
    set2.put("a");
    set2.put("b");
    set2.put("g");

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 2);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res2.size(), 2);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
  }

  @Test
  public void intersectionTestTwoEqualsSets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("c");
    set2.put("a");
    set2.put("b");
    set2.put("c");

    PowerSet res1 = set1.intersection(set2);
    PowerSet res2 = set2.intersection(set1);

    Assert.assertEquals(res1.size(), 3);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res1.get("c"), true);
    Assert.assertEquals(res2.size(), 3);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res1.get("c"), true);
  }

  @Test
  public void unionTestEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();

    PowerSet res1 = set1.union(set2);
    PowerSet res2 = set2.union(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void unionTestEmptySetAndNotEmptySet() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("1");
    set1.put("gh");

    PowerSet res1 = set1.union(set2);
    PowerSet res2 = set2.union(set1);

    Assert.assertEquals(res1.size(), 3);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("gh"), true);
    Assert.assertEquals(res1.get("1"), true);
    Assert.assertEquals(res2.size(), 3);
    Assert.assertEquals(res2.get("a"), true);
    Assert.assertEquals(res2.get("1"), true);
    Assert.assertEquals(res2.get("gh"), true);
  }

  @Test
  public void unionTestNotEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("1");
    set2.put("gh");

    PowerSet res1 = set1.union(set2);
    PowerSet res2 = set2.union(set1);

    Assert.assertEquals(res1.size(), 3);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("gh"), true);
    Assert.assertEquals(res1.get("1"), true);
    Assert.assertEquals(res2.size(), 3);
    Assert.assertEquals(res2.get("a"), true);
    Assert.assertEquals(res2.get("1"), true);
    Assert.assertEquals(res2.get("gh"), true);
  }

  @Test
  public void differenceTestEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();

    PowerSet res1 = set1.difference(set2);
    PowerSet res2 = set2.difference(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void differenceTestEmptySetAndNotEmptySet() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");

    PowerSet res1 = set1.difference(set2);
    PowerSet res2 = set2.difference(set1);

    Assert.assertEquals(res1.size(), 2);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void differenceTestNotEmptySetsWithoutSameElems() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set2.put("c");
    set2.put("d");

    PowerSet res1 = set1.difference(set2);
    PowerSet res2 = set2.difference(set1);

    Assert.assertEquals(res1.size(), 2);
    Assert.assertEquals(res1.get("a"), true);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res2.size(), 2);
    Assert.assertEquals(res2.get("c"), true);
    Assert.assertEquals(res2.get("d"), true);
  }

  @Test
  public void differenceTestNotEmptySetsWithSomeSameElems() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("1");
    set1.put("b");
    set1.put("c");
    set2.put("a");
    set2.put("1");
    set2.put("d");
    set2.put("e");

    PowerSet res1 = set1.difference(set2);
    PowerSet res2 = set2.difference(set1);

    Assert.assertEquals(res1.size(), 2);
    Assert.assertEquals(res1.get("b"), true);
    Assert.assertEquals(res1.get("c"), true);
    Assert.assertEquals(res2.size(), 2);
    Assert.assertEquals(res2.get("d"), true);
    Assert.assertEquals(res2.get("e"), true);
  }

  @Test
  public void differenceTestEqualsNotEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("b");
    set1.put("b");
    set2.put("b");
    set2.put("b");

    PowerSet res1 = set1.difference(set2);
    PowerSet res2 = set2.difference(set1);

    Assert.assertEquals(res1.size(), 0);
    Assert.assertEquals(res2.size(), 0);
  }

  @Test
  public void isSubsetTestEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();

    boolean res1 = set1.isSubset(set2);
    boolean res2 = set2.isSubset(set1);

    Assert.assertEquals(res1, true);
    Assert.assertEquals(res2, true);
  }

  @Test
  public void isSubsetTestnotEmptyAndEmptySets() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");

    boolean res1 = set1.isSubset(set2);
    boolean res2 = set2.isSubset(set1);

    Assert.assertEquals(res1, true);
    Assert.assertEquals(res2, false);
  }

  @Test
  public void isSubsetTestNotEmptyWithoutSameElements() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set2.put("c");
    set2.put("d");

    boolean res1 = set1.isSubset(set2);
    boolean res2 = set2.isSubset(set1);

    Assert.assertEquals(res1, false);
    Assert.assertEquals(res2, false);
  }

  @Test
  public void isSubsetTestNotEmptyWithSomeSameAndSomeDifferentElements() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("f");
    set2.put("a");
    set2.put("d");

    boolean res1 = set1.isSubset(set2);
    boolean res2 = set2.isSubset(set1);

    Assert.assertEquals(res1, false);
    Assert.assertEquals(res2, false);
  }

  @Test
  public void isSubsetTestNotEmptySetsOneIsSubsetOfAnother() {
    PowerSet set1 = new PowerSet();
    PowerSet set2 = new PowerSet();
    set1.put("a");
    set1.put("b");
    set1.put("f");
    set2.put("a");
    set2.put("f");

    boolean res1 = set1.isSubset(set2);
    boolean res2 = set2.isSubset(set1);

    Assert.assertEquals(res1, true);
    Assert.assertEquals(res2, false);
  }

  @Test(timeout = 1000)
  public void putTimeTest() {
    PowerSet set = new PowerSet();
    for (int i = 0; i < 10_000; i++) {
      set.put("abc");
    }
  }

  @Test(timeout = 1000)
  public void getTimeTest() {
    PowerSet set = new PowerSet();
    for (int i = 0; i < 10_000; i++) {
      set.put("abc");
    }
    for (int i = 0; i < 10_000; i++) {
      set.get("abc");
    }
  }

  @Test(timeout = 1000)
  public void removeTimeTest() {
    PowerSet set = new PowerSet();
    for (int i = 0; i < 20_000; i++) {
      set.put("abc");
    }
    for (int i = 0; i < 20_000; i++) {
      set.remove("abc");
    }
  }
}
