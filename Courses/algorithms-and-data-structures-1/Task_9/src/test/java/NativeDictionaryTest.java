import org.junit.Test;
import org.junit.Assert;

public class NativeDictionaryTest {
  @Test
  public void isKeyTestInEmptyDict() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);

    Assert.assertEquals(dict.isKey("q"), false);
    Assert.assertEquals(dict.isKey("2"), false);
    Assert.assertEquals(dict.isKey("rwt"), false);
    Assert.assertEquals(dict.isKey("dsgjlk"), false);
    Assert.assertEquals(dict.isKey("237881"), false);
  }

  @Test
  public void isKeyTestExistKey() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);
    dict.put("hgf", 4);

    Assert.assertEquals(dict.isKey("q"), true);
    Assert.assertEquals(dict.isKey("hgf"), true);
  }

  @Test
  public void isKeyTestExistKey2() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);
    dict.put("hgf", 4);
    dict.put("akl", 4);
    dict.put("729", 4);

    Assert.assertEquals(dict.isKey("q"), true);
    Assert.assertEquals(dict.isKey("hgf"), true);
    Assert.assertEquals(dict.isKey("729"), true);
    Assert.assertEquals(dict.isKey("akl"), true);
  }

  @Test
  public void putTestInEmptyDict() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);

    Assert.assertEquals(dict.get("q"), Integer.valueOf(1));
  }

  @Test
  public void putTestInEmptyDict2() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("hjsd", 1);

    Assert.assertEquals(dict.get("hjsd"), Integer.valueOf(1));
  }

  @Test
  public void putTestInNotEmptyDict() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);
    dict.put("w", 2);
    dict.put("e", 3);
    dict.put("561", 4);
    dict.put("fhdj", 5);

    Assert.assertEquals(dict.get("q"), Integer.valueOf(1));
    Assert.assertEquals(dict.get("w"), Integer.valueOf(2));
    Assert.assertEquals(dict.get("e"), Integer.valueOf(3));
    Assert.assertEquals(dict.get("561"), Integer.valueOf(4));
    Assert.assertEquals(dict.get("fhdj"), Integer.valueOf(5));
  }

  @Test
  public void putTestRewritingExistKey() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);
    dict.put("q", 5);

    Assert.assertEquals(dict.get("q"), Integer.valueOf(5));
  }

  @Test
  public void putTestComplexExistKey() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("q", 1);
    dict.put("q", 5);
    dict.put("ad", 2);
    dict.put("kqi", 5);
    dict.put("kqi", 3);
    dict.put("kkkk", 4);

    Assert.assertEquals(dict.get("q"), Integer.valueOf(5));
    Assert.assertEquals(dict.get("ad"), Integer.valueOf(2));
    Assert.assertEquals(dict.get("kqi"), Integer.valueOf(3));
    Assert.assertEquals(dict.get("kkkk"), Integer.valueOf(4));
  }

  @Test
  public void getTestEmptyTable() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);

    Assert.assertEquals(dict.get("q"), null);
    Assert.assertEquals(dict.get("qdsdgg"), null);
    Assert.assertEquals(dict.get("7"), null);
  }

  @Test
  public void getTestNotExistKey() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("w", 3);
    dict.put("sdgdt", 9);

    Assert.assertEquals(dict.get("q"), null);
    Assert.assertEquals(dict.get("ww"), null);
    Assert.assertEquals(dict.get("fdskj"), null);
    Assert.assertEquals(dict.get("184"), null);
  }

  @Test
  public void getTestExistKey() {
    NativeDictionary<Integer> dict = new NativeDictionary<Integer>(19, Integer.class);
    dict.put("w", 3);
    dict.put("sdgdt", 9);

    Assert.assertEquals(dict.get("w"), Integer.valueOf(3));
    Assert.assertEquals(dict.get("sdgdt"), Integer.valueOf(9));
  }
}
