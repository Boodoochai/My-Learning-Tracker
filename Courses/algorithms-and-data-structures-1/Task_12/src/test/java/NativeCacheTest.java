import org.junit.Assert;
import org.junit.Test;

public class NativeCacheTest {
  @Test
  public void putTestInEmptyCahe() {
    NativeCache<String> cache = new NativeCache(32, String.class);

    cache.put("123", "qwe");

    Assert.assertEquals(cache.get("123"), "qwe");
  }

  @Test
  public void putTestInNotEmptyCahe() {
    NativeCache<String> cache = new NativeCache(32, String.class);

    cache.put("123", "qwe");
    cache.put("1234", "qwe");
    cache.put("12345", "qwe");
    cache.put("123456", "qwe");

    Assert.assertEquals(cache.get("123"), "qwe");
    Assert.assertEquals(cache.get("1234"), "qwe");
    Assert.assertEquals(cache.get("12345"), "qwe");
    Assert.assertEquals(cache.get("123456"), "qwe");
  }

  @Test
  public void putTestOverrideValue() {
    NativeCache<String> cache = new NativeCache(32, String.class);

    cache.put("123", "qwe");
    cache.put("123", "fds");

    Assert.assertEquals(cache.get("123"), "fds");
  }

  @Test
  public void putTestInFullCache() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("12", "qwe");
    cache.put("123", "qwe");
    cache.put("1234", "qwe");
    cache.put("12345", "qwe");

    cache.get("1");
    cache.get("12");
    cache.get("123");
    cache.get("1234");

    cache.put("123456", "qwe");

    Assert.assertEquals(cache.get("1"), "qwe");
    Assert.assertEquals(cache.get("12"), "qwe");
    Assert.assertEquals(cache.get("123"), "qwe");
    Assert.assertEquals(cache.get("1234"), "qwe");
    Assert.assertEquals(cache.get("12345"), null);
    Assert.assertEquals(cache.get("123456"), "qwe");
  }

  @Test
  public void putTestInFullCache2() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("12", "qwe");
    cache.put("123", "qwe");
    cache.put("1234", "qwe");
    cache.put("12345", "qwe");

    cache.isKey("1");
    cache.isKey("12");
    cache.isKey("12345");
    cache.isKey("1234");

    cache.put("123456", "qwe");

    Assert.assertEquals(cache.get("1"), "qwe");
    Assert.assertEquals(cache.get("12"), "qwe");
    Assert.assertEquals(cache.get("123"), null);
    Assert.assertEquals(cache.get("1234"), "qwe");
    Assert.assertEquals(cache.get("12345"), "qwe");
    Assert.assertEquals(cache.get("123456"), "qwe");
  }

  @Test
  public void isKeyTestInEmptyCache() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    Assert.assertFalse(cache.isKey("123"));
    Assert.assertFalse(cache.isKey("a"));
    Assert.assertFalse(cache.isKey("afd"));
    Assert.assertFalse(cache.isKey("fsdhkjafdas"));
  }

  @Test
  public void isKeyTestInNotEmptyCacheNotExistKey() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("2", "qwe");
    cache.put("sdf", "qwe");

    Assert.assertEquals(cache.isKey("123"), false);
    Assert.assertEquals(cache.isKey("a"), false);
    Assert.assertEquals(cache.isKey("fsd"), false);
    Assert.assertEquals(cache.isKey("fdjsalg"), false);
  }

  @Test
  public void isKeyTestInNotEmptyCacheExistKey() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("2", "qwe");
    cache.put("sdf", "qwe");

    Assert.assertTrue(cache.isKey("1"));
    Assert.assertTrue(cache.isKey("2"));
    Assert.assertTrue(cache.isKey("sdf"));
  }

  @Test
  public void getTestInEmptyCache() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    Assert.assertEquals(cache.get("1ads"), null);
    Assert.assertEquals(cache.get("22"), null);
    Assert.assertEquals(cache.get("sfd"), null);
  }

  @Test
  public void getTestInNotEmptyCacheNotExistKey() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("2", "qw");
    cache.put("sdf", "q");

    Assert.assertEquals(cache.get("1ads"), null);
    Assert.assertEquals(cache.get("22"), null);
    Assert.assertEquals(cache.get("sfd"), null);
  }

  @Test
  public void getTestInNotEmptyCacheExistKey() {
    NativeCache<String> cache = new NativeCache(5, String.class);

    cache.put("1", "qwe");
    cache.put("2", "qw");
    cache.put("sdf", "q");

    Assert.assertEquals(cache.get("1"), "qwe");
    Assert.assertEquals(cache.get("2"), "qw");
    Assert.assertEquals(cache.get("sdf"), "q");
  }
}
