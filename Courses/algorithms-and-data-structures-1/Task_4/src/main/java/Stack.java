import java.util.*;

public class Stack<T>
{
    public LinkedList<T> data;

    public Stack()
    {
        data = new LinkedList<T>();
    }

    public int size()
    {
        return data.size();
    }

    public T pop()
    {
        return data.pollLast();
    }

    public void push(T val)
    {
        data.addLast(val);
    }

    public T peek()
    {
        return data.peekLast();
    }
}
