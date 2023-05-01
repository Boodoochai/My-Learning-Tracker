import java.util.*;

public class StackQueue<T>
{
    public Stack<T> stack1;
    public Stack<T> stack2;

    public StackQueue()
    {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void enqueue(T item)
    {
        stack2.push(item);
    }

    public T dequeue()
    {
        if (stack1.empty()) {
            while (!stack2.empty())
                stack1.push(stack2.pop());
        }
        if (stack1.empty())
            return null;
        return stack1.pop();
    }
}
