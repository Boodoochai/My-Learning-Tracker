package LinkedList2Dummy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LinkedList2DummyTest
{
    @Test
    public void findTestFindThatExistInMiddle()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        Node res = list.find(2);

        Assert.assertEquals(res, node2);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findTestFindThatExistInHead()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        Node res = list.find(1);

        Assert.assertEquals(res, node1);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findTestFindThatExistInTail()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        Node res = list.find(3);

        Assert.assertEquals(res, node3);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findTestFindThatNotExist()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        Node res = list.find(5);

        Assert.assertEquals(res, null);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findTestFindThatExistTwice()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        Node res = list.find(2);

        Assert.assertEquals(res, node2);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    // findAll Tests
    @Test
    public void findAllTestFindThatExistInHead()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> ans = new ArrayList<Node>();
        ans.add(node1);

        ArrayList<Node> res = list.findAll(1);

        Assert.assertEquals(res, ans);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findAllTestFindThatExistInMiddle()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> ans = new ArrayList<Node>();
        ans.add(node3);

        ArrayList<Node> res = list.findAll(3);

        Assert.assertEquals(res, ans);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findAllTestFindThatExistInTail()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> ans = new ArrayList<Node>();
        ans.add(node2);
        ans.add(node4);

        ArrayList<Node> res = list.findAll(2);

        Assert.assertEquals(res, ans);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findAllTestFindThatNotExist()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> ans = new ArrayList<Node>();

        ArrayList<Node> res = list.findAll(6);

        Assert.assertEquals(res, ans);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void findAllTestFindThatExistMultiple()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        ArrayList<Node> ans = new ArrayList<Node>();
        ans.add(node2);
        ans.add(node3);
        ans.add(node4);

        ArrayList<Node> res = list.findAll(2);

        Assert.assertEquals(res, ans);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    // remove Tests
    @Test
    public void removeTestRemoveFromHead()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res = list.remove(1);

        Assert.assertEquals(res, true);
        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void removeTestRemoveFromMiddle()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res = list.remove(2);

        Assert.assertEquals(res, true);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void removeTestRemoveFromTail()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res = list.remove(4);

        Assert.assertEquals(res, true);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void removeTestRemoveTwoSameValues()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res1 = list.remove(2);
        boolean res2 = list.remove(2);

        Assert.assertEquals(res1, true);
        Assert.assertEquals(res2, true);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveTestRemoveThatNotExist()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res = list.remove(5);

        Assert.assertEquals(res, false);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveTestRemoveEveryNode()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        boolean res1 = list.remove(1);
        boolean res2 = list.remove(2);
        boolean res3 = list.remove(3);
        boolean res4 = list.remove(2);

        Assert.assertEquals(res1, true);
        Assert.assertEquals(res2, true);
        Assert.assertEquals(res3, true);
        Assert.assertEquals(res4, true);
        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    // removeAll Tests

    @Test
    public void reomveAllTestRemoveFromHead()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(1);

        Assert.assertEquals(list.head.next, node2);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveAllTestRemoveFromMiddle()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(3);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveAllTestRemoveFromTail()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(2);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node3);
        Assert.assertEquals(list.tail.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveAllTestRemoveThatNotExist()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(6);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void reomveAllTestRemoveThatExistMultiple()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(2);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev, null);
    }

    @Test
    public void reomveAllTestRemoveThatRemoveEveryNode()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.removeAll(1);
        list.removeAll(2);
        list.removeAll(3);

        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    // clear Tests

    @Test
    public void clearTestClearNotEmptyList()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.clear();

        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    @Test
    public void clearTestClearListWithOneNode()
    {
        Node node1 = new Node(1);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);

        list.clear();

        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    @Test
    public void clearTestClearEmptyList()
    {
        LinkedList2Dummy list = new LinkedList2Dummy();

        list.clear();

        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    // count Tests

    @Test
    public void countTestCountNotEmptyList()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        int res = list.count();

        Assert.assertEquals(res, 4);
        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void countTestCountEmptyList()
    {
        LinkedList2Dummy list = new LinkedList2Dummy();

        int res = list.count();

        Assert.assertEquals(res, 0);
        Assert.assertEquals(list.head.next.next, null);
        Assert.assertEquals(list.tail.prev.prev, null);
    }

    // insertAfter Tests

    @Test
    public void insertAfterTestInsertInHead()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.insertAfter(null, node1);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void insertAfterTestInsertInMiddle()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node3);
        list.addInTail(node4);

        list.insertAfter(node1, node2);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

    @Test
    public void insertAfterTestInsertInTail()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        list.insertAfter(node3, node4);

        Assert.assertEquals(list.head.next, node1);
        Assert.assertEquals(list.head.next.next, node2);
        Assert.assertEquals(list.head.next.next.next, node3);
        Assert.assertEquals(list.head.next.next.next.next, node4);
        Assert.assertEquals(list.head.next.next.next.next.next.next, null);
        Assert.assertEquals(list.tail.prev, node4);
        Assert.assertEquals(list.tail.prev.prev, node3);
        Assert.assertEquals(list.tail.prev.prev.prev, node2);
        Assert.assertEquals(list.tail.prev.prev.prev.prev, node1);
        Assert.assertEquals(list.tail.prev.prev.prev.prev.prev.prev, null);
    }

}
