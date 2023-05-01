import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    @Test
    public void enqueueTestInEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();

        que.enqueue(2);

        Assert.assertEquals(que.data.size(), 1);
        Assert.assertEquals(que.data.get(0), Integer.valueOf(2));
    }

    @Test
    public void enqueueTestInNotEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();

        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);

        Assert.assertEquals(que.data.size(), 3);
        Assert.assertEquals(que.data.get(0), Integer.valueOf(3));
        Assert.assertEquals(que.data.get(1), Integer.valueOf(2));
        Assert.assertEquals(que.data.get(2), Integer.valueOf(1));
    }

    @Test
    public void dequeueTestFromEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();

        Integer res = que.dequeue();

        Assert.assertEquals(que.data.size(), 0);
        Assert.assertEquals(res, null);
    }

    @Test
    public void dequeueTestFromNotEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();
        que.data.addFirst(4);
        que.data.addFirst(5);
        que.data.addFirst(6);

        Integer res1 = que.dequeue();

        Assert.assertEquals(que.data.size(), 2);
        Assert.assertEquals(res1, Integer.valueOf(4));
        Assert.assertEquals(que.data.get(0), Integer.valueOf(6));
        Assert.assertEquals(que.data.get(1), Integer.valueOf(5));
    }

    @Test
    public void dequeueTestFromNotEmptyQueueMakeItEmpty() {
        Queue<Integer> que = new Queue<Integer>();
        que.data.addFirst(4);
        que.data.addFirst(5);
        que.data.addFirst(6);

        Integer res1 = que.dequeue();
        Integer res2 = que.dequeue();
        Integer res3 = que.dequeue();

        Assert.assertEquals(que.data.size(), 0);
        Assert.assertEquals(res1, Integer.valueOf(4));
        Assert.assertEquals(res2, Integer.valueOf(5));
        Assert.assertEquals(res3, Integer.valueOf(6));
    }

    @Test
    public void sizeTestEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();

        int res = que.size();

        Assert.assertEquals(que.data.size(), 0);
        Assert.assertEquals(res, 0);
    }

    @Test
    public void sizeTestNotEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();
        que.data.addFirst(4);
        que.data.addFirst(5);
        que.data.addFirst(6);

        int res = que.size();

        Assert.assertEquals(que.data.size(), 3);
        Assert.assertEquals(res, 3);
    }
}
