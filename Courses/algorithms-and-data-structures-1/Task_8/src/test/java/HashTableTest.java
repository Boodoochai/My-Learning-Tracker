import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {
    @Test
    public void hashFunTestOneSymbol() {
        HashTable table = new HashTable(17, 3);

        int res1 = table.hashFun("a");
        int res2 = table.hashFun("z");
        int res3 = table.hashFun("A");

        Assert.assertEquals(res1, 12);
        Assert.assertEquals(res2, 3);
        Assert.assertEquals(res3, 14);
    }

    @Test
    public void hashFunTestLongString() {
        HashTable table = new HashTable(17, 3);

        int res1 = table.hashFun("abc");
        int res2 = table.hashFun("zDe");
        int res3 = table.hashFun("kOOl");

        Assert.assertEquals(res1, 5);
        Assert.assertEquals(res2, 2);
        Assert.assertEquals(res3, 16);
    }

    @Test
    public void seekSlotTestInEmptyTable() {
        HashTable table = new HashTable(17, 3);

        int res1 = table.seekSlot("abc");
        int res2 = table.seekSlot("zDe");
        int res3 = table.seekSlot("kOOl");

        Assert.assertEquals(res1, 5);
        Assert.assertEquals(res2, 2);
        Assert.assertEquals(res3, 16);
    }

    @Test
    public void seekSlotTestWithCollisions() {
        HashTable table = new HashTable(17, 3);

        table.slots[1] = "a";
        table.slots[4] = "a";
        table.slots[7] = "a";

        int res1 = table.seekSlot("g");
        int res2 = table.seekSlot("H");
        int res3 = table.seekSlot("DDN");

        Assert.assertEquals(res1, 10);
        Assert.assertEquals(res2, 10);
        Assert.assertEquals(res3, 10);
    }

    @Test
    public void seekSlotTestInFullTable() {
        HashTable table = new HashTable(17, 3);
        for (int i = 0; i < 17; i++)
            table.put("a");

        int res1 = table.seekSlot("g");
        int res2 = table.seekSlot("H");
        int res3 = table.seekSlot("DDN");

        Assert.assertEquals(res1, -1);
        Assert.assertEquals(res2, -1);
        Assert.assertEquals(res3, -1);
    }

    @Test
    public void putTestInEmptyTable() {
        HashTable table = new HashTable(17, 3);

        int res1 = table.put("g");

        Assert.assertEquals(res1, 1);
    }

    @Test
    public void putTestWithoutCollisions() {
        HashTable table = new HashTable(17, 3);

        int res1 = table.put("g");
        int res2 = table.put("H");
        int res3 = table.put("DDN");

        Assert.assertEquals(res1, 1);
        Assert.assertEquals(res2, 4);
        Assert.assertEquals(res3, 10);
    }

    @Test
    public void putTestWithCollisions() {
        HashTable table = new HashTable(17, 3);
        table.put("g");
        table.put("H");
        table.put("m");

        int res1 = table.put("g");
        int res2 = table.put("H");
        int res3 = table.put("DDN");

        Assert.assertEquals(res1, 10);
        Assert.assertEquals(res2, 13);
        Assert.assertEquals(res3, 16);
    }

    @Test
    public void putTestInFullTable() {
        HashTable table = new HashTable(17, 3);
        for (int i = 0; i < 17; i++)
            table.put("a");

        int res1 = table.put("g");
        int res2 = table.put("H");
        int res3 = table.put("DDN");

        Assert.assertEquals(res1, -1);
        Assert.assertEquals(res2, -1);
        Assert.assertEquals(res3, -1);
    }

    @Test
    public void findTestWithCollisions() {
        HashTable table = new HashTable(17, 3);
        table.put("g");
        table.put("H");
        table.put("m");
        table.put("x");

        int res1 = table.find("x");

        Assert.assertEquals(res1, 10);
    }

    @Test
    public void findTestWithOutCollisions() {
        HashTable table = new HashTable(17, 3);

        Assert.assertEquals(table.put("a"), table.find("a"));
        Assert.assertEquals(table.put("v"), table.find("v"));
        Assert.assertEquals(table.put("c"), table.find("c"));
    }
}
