import org.junit.Assert;
import org.junit.Test;

public class RotateQueueTest {
    @Test
    public void rotateTestEmptyQueue() {
        Queue<Integer> que = new Queue<Integer>();

        RotateQueue.rotate(que, 4);

        Assert.assertEquals(que.size(), 0);
    }

    @Test
    public void rotateTestOnZeroElements() {
        Queue<Integer> que = new Queue<Integer>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);

        RotateQueue.<Integer>rotate(que, 0);

        Assert.assertEquals(que.size(), 5);
        Assert.assertEquals(que.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(3));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(4));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(5));
    }

    @Test
    public void rotateTestOnLowerThanQueueLength() {
        Queue<Integer> que = new Queue<Integer>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);

        RotateQueue.rotate(que, 3);

        Assert.assertEquals(que.size(), 5);
        Assert.assertEquals(que.dequeue(), Integer.valueOf(4));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(5));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(3));
    }

    @Test
    public void rotateTestOnBiggerThanQueueLength() {
        Queue<Integer> que = new Queue<Integer>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);

        RotateQueue.rotate(que, 18);

        Assert.assertEquals(que.size(), 5);
        Assert.assertEquals(que.dequeue(), Integer.valueOf(4));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(5));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(3));
    }

    @Test
    public void rotateTestOnQueueLength() {
        Queue<Integer> que = new Queue<Integer>();
        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);

        RotateQueue.rotate(que, 5);

        Assert.assertEquals(que.size(), 5);
        Assert.assertEquals(que.dequeue(), Integer.valueOf(1));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(2));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(3));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(4));
        Assert.assertEquals(que.dequeue(), Integer.valueOf(5));
    }
}
