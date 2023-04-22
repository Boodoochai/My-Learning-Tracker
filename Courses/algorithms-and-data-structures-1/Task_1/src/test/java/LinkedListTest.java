import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LinkedListTest {
    @Test
    public void simpleAddInTailTest() {
        LinkedList list = new LinkedList();
        Node node = new Node(15);

        list.addInTail(node);

        Assert.assertEquals(list.head, node);
        Assert.assertEquals(list.tail, node);
    }

    @Test
    public void manyAddInTailTest() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(15);
        Node node2 = new Node(17);
        Node node3 = new Node(89);

        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.tail, node3);
    }

    @Test
    public void findTest() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);

        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        Assert.assertEquals(list.find(1), node1);
        Assert.assertEquals(list.find(2), node2);
        Assert.assertEquals(list.find(3), node3);
    }

    @Test
    public void findAllTest() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        ArrayList<Node> ans1 = new ArrayList<Node>();
        ans1.add(node1);
        ans1.add(node4);
        ArrayList<Node> ans2 = new ArrayList<Node>();
        ans2.add(node2);
        ArrayList<Node> ans3 = new ArrayList<Node>();
        ans3.add(node3);

        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        Assert.assertEquals(list.findAll(1), ans1);
        Assert.assertEquals(list.findAll(2), ans2);
        Assert.assertEquals(list.findAll(3), ans3);
    }

    @Test
    public void removeTest1()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean ans = list.remove(1);

        Assert.assertEquals(ans, true);
        Assert.assertEquals(list.head, node2);
        Assert.assertEquals(list.head.next, node3);
        Assert.assertEquals(list.head.next.next, node4);
    }

    @Test
    public void removeTest2()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean ans = list.remove(2);

        Assert.assertEquals(ans, true);
        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node3);
        Assert.assertEquals(list.head.next.next, node4);
    }

    @Test
    public void removeTest3()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean ans = list.remove(3);

        Assert.assertEquals(ans, true);
        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node4);
    }

    @Test
    public void removeTest4()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean ans1 = list.remove(1);
        boolean ans2 = list.remove(1);

        Assert.assertEquals(ans1, true);
        Assert.assertEquals(ans2, true);
        Assert.assertEquals(list.head, node2);
        Assert.assertEquals(list.head.next, node3);
    }

    @Test
    public void removeThatNotExistTest()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean ans = list.remove(5);

        Assert.assertEquals(ans, false);
        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
    }

    @Test
    public void removeAllTest1()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(1);

        Assert.assertEquals(list.head, node2);
        Assert.assertEquals(list.head.next, node3);
    }

    @Test
    public void removeAllTest2()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(2);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node3);
        Assert.assertEquals(list.head.next.next, node4);
    }

    @Test
    public void removeAllTestRemoveSomethingThatNotExist()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(4);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
    }

    @Test
    public void clearTestEmptyList()
    {
        LinkedList list = new LinkedList();

        list.clear();

        Assert.assertEquals(list.head, null);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void clearTestNotEmptyList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.clear();

        Assert.assertEquals(list.head, null);
        Assert.assertEquals(list.tail, null);
    }

    @Test
    public void countTestEmptyList()
    {
        LinkedList list = new LinkedList();

        int ans = list.count();

        Assert.assertEquals(ans, 0);
    }


    @Test
    public void countTestNotEmptyList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        int ans = list.count();

        Assert.assertEquals(ans, 4);
    }

    @Test
    public void insertAfterTestInsertInMiddleOfList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node4);

        list.insertAfter(node2, node3);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
        Assert.assertEquals(list.tail, node4);
    }

    @Test
    public void insertAfterTestInsertInHeadOfNotEmptyList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.addInTail(node2);

        list.insertAfter(null, node1);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail, node2);
    }

    @Test
    public void insertAfterTestInsertInTailOfNotEmptyList()
    {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.addInTail(node1);

        list.insertAfter(node1, node2);

        Assert.assertEquals(list.head, node1);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail, node2);
    }

    @Test
    public void insertAfterTestInsertInEmptyList() {
        LinkedList list = new LinkedList();
        Node node = new Node(1);

        list.insertAfter(null, node);

        Assert.assertEquals(list.head, node);
        Assert.assertEquals(list.tail, node);
    }
}
