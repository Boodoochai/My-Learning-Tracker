import org.junit.Assert;
import org.junit.Test;

public class StackQueueTest {
    @Test
    public void enqueueTestInEmptyQueue() {
        StackQueue<Integer> que = new StackQueue<Integer>();

        que.enqueue(2);

        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), null);
    }

    @Test
    public void enqueueTestInNotEmptyQueue() {
        StackQueue<Integer> que = new StackQueue<Integer>();

        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);

        Assert.assertEquals(que.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(3));
        Assert.assertEquals(que.dequeue(), null);
    }

    @Test
    public void dequeueTestFromEmptyQueue() {
        StackQueue<Integer> que = new StackQueue<Integer>();

        Integer res = que.dequeue();

        Assert.assertEquals(que.dequeue(), null);
    }

    @Test
    public void dequeueTestFromNotEmptyQueue() {
        StackQueue<Integer> que = new StackQueue<Integer>();
        que.enqueue(4);
        que.enqueue(5);
        que.enqueue(6);

        Assert.assertEquals(que.dequeue(), Integer.valueOf(4));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(5));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(6));
        Assert.assertEquals(que.dequeue(), null);
    }
}
