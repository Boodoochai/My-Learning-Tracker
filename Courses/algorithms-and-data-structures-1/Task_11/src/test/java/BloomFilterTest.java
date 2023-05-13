import org.junit.Assert;
import org.junit.Test;

public class BloomFilterTest {
  @Test
  public void hash1Test() {
    BloomFilter filter = new BloomFilter(32);

    Assert.assertEquals(filter.hash1("a"), 1);
    Assert.assertEquals(filter.hash1("b"), 2);
    Assert.assertEquals(filter.hash1("G"), 7);
    Assert.assertEquals(filter.hash1("aa"), 18);
    Assert.assertEquals(filter.hash1("jd"), 14);
  }

  @Test
  public void hash2Test() {
    BloomFilter filter = new BloomFilter(32);

    Assert.assertEquals(filter.hash2("a"), 1);
    Assert.assertEquals(filter.hash2("b"), 2);
    Assert.assertEquals(filter.hash2("G"), 7);
    Assert.assertEquals(filter.hash2("aa"), 0);
    Assert.assertEquals(filter.hash2("Ha"), 25);
  }

  @Test
  public void isValueTestOneValue() {
    BloomFilter filter = new BloomFilter(32);

    filter.add("0123456789");

    Assert.assertTrue(filter.isValue("0123456789"));
  }

  @Test
  public void isValueTestManyValues() {
    BloomFilter filter = new BloomFilter(32);

    filter.add("0123456789");
    filter.add("1234567890");
    filter.add("2345678901");
    filter.add("3456789012");
    filter.add("4567890123");
    filter.add("5678901234");
    filter.add("6789012345");
    filter.add("7890123456");
    filter.add("8901234567");
    filter.add("9012345678");

    Assert.assertTrue(filter.isValue("0123456789"));
    Assert.assertTrue(filter.isValue("1234567890"));
    Assert.assertTrue(filter.isValue("2345678901"));
    Assert.assertTrue(filter.isValue("3456789012"));
    Assert.assertTrue(filter.isValue("4567890123"));
    Assert.assertTrue(filter.isValue("5678901234"));
    Assert.assertTrue(filter.isValue("6789012345"));
    Assert.assertTrue(filter.isValue("7890123456"));
    Assert.assertTrue(filter.isValue("8901234567"));
    Assert.assertTrue(filter.isValue("9012345678"));
  }
}
