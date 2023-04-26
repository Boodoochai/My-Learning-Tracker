import org.junit.Assert;
import org.junit.Test;

public class DynArrayTest {
    @Test
    public void constructorTest() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 0);
        Assert.assertArrayEquals(arr.array, new Integer[16]);
    }

    @Test
    public void makeArrayTestEmptyArray() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);

        arr.makeArray(32);

        Assert.assertEquals(arr.capacity, 32);
        Assert.assertEquals(arr.count, 0);
        Assert.assertArrayEquals(arr.array, new Integer[32]);
    }

    @Test
    public void makeArrayTestNotEmptyArray() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        Integer[] ans = new Integer[32];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.makeArray(32);

        Assert.assertEquals(arr.capacity, 32);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void makeArrayTestNotEmptyArray2() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        Integer[] ans = new Integer[17];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.makeArray(17);

        Assert.assertEquals(arr.capacity, 17);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void getItemTestGetExistIndex() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;

        Integer res1 = arr.getItem(0);
        Integer res2 = arr.getItem(1);
        Integer res3 = arr.getItem(2);
        Integer res4 = arr.getItem(3);
        Integer res5 = arr.getItem(4);

        Assert.assertEquals(res1.intValue(), 1);
        Assert.assertEquals(res2.intValue(), 2);
        Assert.assertEquals(res3.intValue(), 3);
        Assert.assertEquals(res4.intValue(), 0);
        Assert.assertEquals(res5.intValue(), 4);
        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getItemTestIndexLowerThanZero() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.getItem(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getItemTestIndexBiggerThanCount() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.getItem(5);
    }


    @Test
    public void appendTestAppendInEmptyList() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void appendTestAppendInFullArray() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(1);
        }
        Integer[] ans = new Integer[32];
        for (int i = 0; i < 17; i++) {
            ans[i] = Integer.valueOf(1);
        }

        arr.append(1);

        Assert.assertEquals(arr.capacity, 32);
        Assert.assertEquals(arr.count, 17);
        Assert.assertArrayEquals(arr.array, ans);
    }


    @Test
    public void insertTestInsertInExistIndex() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;

        arr.insert(0, 3);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void insertTestInsertInZeroIndex() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;

        arr.insert(1, 0);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void insertTestInsertInEnd() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = 4;

        arr.insert(4, 4);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 5);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void insertTestInsertInEndWithRealocation() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(1);
        }
        Integer[] ans = new Integer[32];
        for (int i = 0; i < 16; i++) {
            ans[i] = 1;
        }
        ans[16] = 4;

        arr.insert(4, 16);

        Assert.assertEquals(arr.capacity, 32);
        Assert.assertEquals(arr.count, 17);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertTestInsertInIndexLowerThanZero() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.insert(4, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertTestInsertInIndexBiggerThanCount() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.insert(4, 6);
    }

    @Test
    public void removeTestRemoveIndexInMiddle() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 4;
        ans[4] = null;

        arr.remove(3);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 4);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void removeTestRemoveIndexZero() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 2;
        ans[1] = 3;
        ans[2] = 0;
        ans[3] = 4;
        ans[4] = null;

        arr.remove(0);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 4);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void removeTestRemoveIndexInEnd() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);
        Integer[] ans = new Integer[16];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        ans[3] = 0;
        ans[4] = null;

        arr.remove(4);

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 4);
        Assert.assertEquals(arr.array, ans);
    }

    @Test
    public void removeTestRemoveWithReallocationEvenCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            arr.append(1);
        }
        Integer[] ans = new Integer[21];
        for (int i = 0; i < 15; i++) {
            ans[i] = Integer.valueOf(1);
        }
        ans[15] = null;
        ans[16] = null;

        arr.remove(15);
        arr.remove(15);

        Assert.assertEquals(arr.capacity, 21);
        Assert.assertEquals(arr.count, 15);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test
    public void removeTestRemoveWithReallocationOddCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 65; i++) {
            arr.append(1);
        }
        Integer[] ans = new Integer[56];
        for (int i = 0; i < 42; i++) {
            ans[i] = Integer.valueOf(1);
        }
    for (int i = 42; i < 56; i++) {
            ans[i] = null;
        }

        for (int i = 0; i < 23; i++) {
            arr.remove(0);
        }

        Assert.assertEquals(arr.capacity, 56);
        Assert.assertEquals(arr.count, 42);
        Assert.assertArrayEquals(arr.array, ans);
    }


    @Test
    public void removeTestRemoveWithReallocationLower16() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            arr.append(1);
        }
        Integer[] ans = new Integer[16];
        for (int i = 0; i < 10; i++) {
            ans[i] = Integer.valueOf(1);
        }
        for (int i = 10; i < 16; i++) {
            ans[i] = null;
        }

        for (int i = 0; i < 7; i++) {
            arr.remove(0);
        }

        Assert.assertEquals(arr.capacity, 16);
        Assert.assertEquals(arr.count, 10);
        Assert.assertArrayEquals(arr.array, ans);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTestRemoveIndexLowerZero() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTestRemoveIndexBiggerThanCount() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(0);
        arr.append(4);

        arr.remove(5);
    }
}
