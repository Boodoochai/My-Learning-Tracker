import org.junit.Test;
import org.junit.Assert;

public class OrderedListTest {
    @Test
    public void addTestInEmptyList() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        list.add(1);

        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next, null);
        Assert.assertEquals(list.head.prev, null);
    }

    @Test
    public void addTestInListWithOneElementAscending() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        list.add(3);
        list.add(1);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next, list.tail);
        Assert.assertEquals(list.tail.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void addTestInNotEmptyListAscending() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        list.add(3);
        list.add(1);
        list.add(5);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(5));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void addTestInListWithOneElementNotAscending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);

        list.add(1);
        list.add(3);

        Assert.assertEquals(list.head.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next, list.tail);
        Assert.assertEquals(list.tail.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void addTestInNotEmptyListNotAscending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);

        list.add(3);
        list.add(1);
        list.add(5);

        Assert.assertEquals(list.head.value, Integer.valueOf(5));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void countTestEmptyList() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        Assert.assertEquals(list.count(), 0);
        Assert.assertEquals(list.tail, list.head);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void countTestListWithOneElement() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);

        Assert.assertEquals(list.count(), 1);
        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void countTestListWithManyElements() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(3);
        list.add(1);
        list.add(5);

        Assert.assertEquals(list.count(), 3);
        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(5));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void clearTestEmptyList() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        list.clear(true);

        Assert.assertEquals(list.tail, list.head);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void clearTestListWithOneElement() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);

        list.clear(true);

        Assert.assertEquals(list.tail, list.head);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void clearTestListWithManyElements() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(3);
        list.add(1);
        list.add(5);

        list.clear(true);

        Assert.assertEquals(list.tail, list.head);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void compareTest() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        Assert.assertEquals(list.compare(1, 2), -1);
        Assert.assertEquals(list.compare(2, 1), 1);
        Assert.assertEquals(list.compare(1, 1), 0);

        Assert.assertEquals(list.tail, list.head);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void findTestEmptyList() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        Assert.assertEquals(list.find(1), null);
        Assert.assertEquals(list.find(2), null);
        Assert.assertEquals(list.find(3), null);

        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void findTestListWithOneElement() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);

        Assert.assertEquals(list.find(1), list.head);

        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void findTestListWithManyElementsFromHead() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(3);
        list.add(2);

        Assert.assertEquals(list.find(2), list.head.next);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void findTestListWithManyElementsFromTail() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(3);
        list.add(2);

        Assert.assertEquals(list.find(3), list.tail);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void findTestListWithManyElementsFromMiddle() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(3);
        list.add(2);

        Assert.assertEquals(list.find(2), list.tail.prev);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void findTestListWithManyElementsNotExisted() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(3);
        list.add(2);

        Assert.assertEquals(list.find(4), null);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void deleteTestEmptyList() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);

        list.delete(4);

        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void deleteTestListWithOneElement() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);

        list.delete(1);

        Assert.assertEquals(list.head, list.tail);
        Assert.assertEquals(list.tail, null);
    }
    @Test
    public void deleteTestListWithManyElementsFromHead() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        list.delete(1);

        Assert.assertEquals(list.head.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(4));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void deleteTestListWithManyElementsFromTail() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        list.delete(4);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void deleteTestListWithManyElementsFromMiddle() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        list.delete(2);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(3));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(4));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }

    @Test
    public void deleteTestListWithManyElementsWithTwoSameElements() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(2);

        list.delete(4);

        Assert.assertEquals(list.head.value, Integer.valueOf(1));
        Assert.assertEquals(list.head.next.value, Integer.valueOf(2));
        Assert.assertEquals(list.head.next.next.value, Integer.valueOf(4));
        Assert.assertEquals(list.head.next.next, list.tail);
        Assert.assertEquals(list.tail.prev.prev, list.head);
        Assert.assertEquals(list.head.prev, null);
        Assert.assertEquals(list.tail.next, null);
    }
}
