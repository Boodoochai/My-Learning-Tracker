import org.junit.Test;
import org.junit.Assert;

public class DequeTest {
    @Test
    public void addFrontTestInEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        deq.addFront(1);

        Assert.assertEquals(deq.data.size(), 1);
        Assert.assertEquals(deq.data.get(0), Integer.valueOf(1));
    }

    @Test
    public void addFrontTestInNotEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        deq.addFront(1);
        deq.addFront(2);
        deq.addFront(3);

        Assert.assertEquals(deq.data.size(), 3);
        Assert.assertEquals(deq.data.get(0), Integer.valueOf(3));
        Assert.assertEquals(deq.data.get(1), Integer.valueOf(2));
        Assert.assertEquals(deq.data.get(2), Integer.valueOf(1));
    }

    @Test
    public void addTailTestInEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        deq.addTail(1);

        Assert.assertEquals(deq.data.size(), 1);
        Assert.assertEquals(deq.data.get(0), Integer.valueOf(1));
    }

    @Test
    public void addTailTestInNotEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        deq.addTail(1);
        deq.addTail(2);
        deq.addTail(3);

        Assert.assertEquals(deq.data.size(), 3);
        Assert.assertEquals(deq.data.get(0), Integer.valueOf(1));
        Assert.assertEquals(deq.data.get(1), Integer.valueOf(2));
        Assert.assertEquals(deq.data.get(2), Integer.valueOf(3));
    }

    @Test
    public void removeFrontTestFromEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        Integer res = deq.removeFront();

        Assert.assertEquals(deq.data.size(), 0);
        Assert.assertEquals(res, null);
    }

    @Test
    public void removeFrontTestFromNotEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();
        deq.data.addFirst(1);
        deq.data.addFirst(2);
        deq.data.addFirst(3);

        Integer res1 = deq.removeFront();
        Integer res2 = deq.removeFront();
        Integer res3 = deq.removeFront();

        Assert.assertEquals(deq.data.size(), 0);
        Assert.assertEquals(res1, Integer.valueOf(3));
        Assert.assertEquals(res2, Integer.valueOf(2));
        Assert.assertEquals(res3, Integer.valueOf(1));
    }

    @Test
    public void removeTailTestFromEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        Integer res = deq.removeTail();

        Assert.assertEquals(deq.data.size(), 0);
        Assert.assertEquals(res, null);
    }

    @Test
    public void removeTailTestFromNotEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();
        deq.data.addFirst(1);
        deq.data.addFirst(2);
        deq.data.addFirst(3);

        Integer res1 = deq.removeTail();
        Integer res2 = deq.removeTail();
        Integer res3 = deq.removeTail();

        Assert.assertEquals(deq.data.size(), 0);
        Assert.assertEquals(res1, Integer.valueOf(1));
        Assert.assertEquals(res2, Integer.valueOf(2));
        Assert.assertEquals(res3, Integer.valueOf(3));
    }

    @Test
    public void sizeTestEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();

        int res = deq.size();

        Assert.assertEquals(deq.data.size(), 0);
        Assert.assertEquals(res, 0);
    }

    @Test
    public void sizeTestNotEmptyDeque() {
        Deque<Integer> deq = new Deque<Integer>();
        deq.data.addFirst(1);
        deq.data.addFirst(1);
        deq.data.addFirst(1);

        int res = deq.size();

        Assert.assertEquals(deq.data.size(), 3);
        Assert.assertEquals(res, 3);
    }
}
