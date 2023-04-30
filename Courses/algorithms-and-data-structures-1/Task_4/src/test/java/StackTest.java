import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StackTest {
    @Test
    public void pushTestInEmptyStack() {
        Stack stack = new Stack<Integer>();

        stack.push(1);

        Assert.assertEquals(stack.data.size(), 1);
        Assert.assertEquals(stack.data.get(0), Integer.valueOf(1));
    }

    @Test
    public void pushTestInNotEmptyStack() {
        Stack stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.data.size(), 3);
        Assert.assertEquals(stack.data.get(0), Integer.valueOf(1));
        Assert.assertEquals(stack.data.get(1), Integer.valueOf(2));
        Assert.assertEquals(stack.data.get(2), Integer.valueOf(3));
    }

    @Test
    public void popTestFromEmptyStack() {
        Stack stack = new Stack<Integer>();

        Integer res = (Integer)stack.pop();

        Assert.assertEquals(stack.data.size(), 0);
        Assert.assertEquals(res, null);
    }

    @Test
    public void popTestFromNotEmptyStack() {
        Stack stack = new Stack<Integer>();
        stack.push(1);

        Integer res = (Integer)stack.pop();

        Assert.assertEquals(stack.data.size(), 0);
        Assert.assertEquals(res, Integer.valueOf(1));
    }

    @Test
    public void popTestFromNotEmptyStackMakeItEmpty() {
        Stack stack = new Stack<Integer>();
        stack.push(1);

        Integer res1 = (Integer)stack.pop();
        Integer res2 = (Integer)stack.pop();

        Assert.assertEquals(stack.data.size(), 0);
        Assert.assertEquals(res1, Integer.valueOf(1));
        Assert.assertEquals(res2, null);
    }

    @Test
    public void peekTestFromEmptyStack() {
        Stack stack = new Stack<Integer>();

        Integer res1 = (Integer)stack.peek();
        Integer res2 = (Integer)stack.peek();

        Assert.assertEquals(stack.data.size(), 0);
        Assert.assertEquals(res1, null);
        Assert.assertEquals(res2, null);
    }

    @Test
    public void peekTestFromNotEmptyStack() {
        Stack stack = new Stack<Integer>();
        stack.push(1);

        Integer res1 = (Integer)stack.peek();
        Integer res2 = (Integer)stack.peek();

        Assert.assertEquals(stack.data.size(), 1);
        Assert.assertEquals(res1, Integer.valueOf(1));
        Assert.assertEquals(res2, Integer.valueOf(1));
    }

    @Test
    public void peekTestFromNotEmptyStack2() {
        Stack stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);

        Integer res1 = (Integer)stack.peek();
        Integer res2 = (Integer)stack.peek();

        Assert.assertEquals(stack.data.size(), 2);
        Assert.assertEquals(res1, Integer.valueOf(2));
        Assert.assertEquals(res2, Integer.valueOf(2));
    }

    @Test
    public void sizeTestEmptyStack() {
        Stack stack = new Stack<Integer>();

        int res = stack.size();

        Assert.assertEquals(stack.data.size(), 0);
        Assert.assertEquals(res, 0);
    }

    @Test
    public void sizeTestNotEmptyStack() {
        Stack stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int res = stack.size();

        Assert.assertEquals(stack.data.size(), 3);
        Assert.assertEquals(res, 3);
    }
}
