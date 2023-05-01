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
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(item);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue()
    {
        if (stack1.empty())
            return null;
        return stack1.pop();
    }
}
