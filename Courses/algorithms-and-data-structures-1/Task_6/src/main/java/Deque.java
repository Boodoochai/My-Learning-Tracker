import java.util.*;

public class Deque<T>
{
    LinkedList<T> data;

    public Deque()
    {
        data = new LinkedList<T>();
    }

    public void addFront(T item)
    {
        data.addFirst(item);
    }

    public void addTail(T item)
    {
        data.addLast(item);
    }

    public T removeFront()
    {
        return data.pollFirst();
    }

    public T removeTail()
    {
        return data.pollLast();
    }

    public int size()
    {
        return data.size();
    }
}
