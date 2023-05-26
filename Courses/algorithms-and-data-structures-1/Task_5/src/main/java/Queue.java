import java.util.LinkedList;

public class Queue<T> {
    public LinkedList<T> data;

    public Queue() {
        data = new LinkedList<T>();
    }

    public void enqueue(T item) {
        data.addFirst(item);
    }

    public T dequeue() {
        return data.pollLast();
    }

    public int size() {
        return data.size();
    }
}
