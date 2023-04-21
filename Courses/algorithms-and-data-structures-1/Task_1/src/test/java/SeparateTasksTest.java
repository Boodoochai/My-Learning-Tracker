import org.junit.Assert;
import org.junit.Test;

public class SeparateTasksTest {
    @Test
    public void addTwoListsTest() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(10));
        list1.addInTail(new Node(100));
        list1.addInTail(new Node(1000));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(4));
        list2.addInTail(new Node(5));
        list2.addInTail(new Node(6));

        LinkedList ans = SeparateTasks.addTwoLists(list1, list2);

        Assert.assertEquals(14, ans.head.value);
        Assert.assertEquals(105, ans.head.next.value);
        Assert.assertEquals(1006, ans.head.next.next.value);
        Assert.assertEquals(ans.tail, ans.head.next.next);
    }

    @Test
    public void addTwoListsTestGivenDifferentSizeLists() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(10));
        list1.addInTail(new Node(100));
        list1.addInTail(new Node(1000));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(4));
        list2.addInTail(new Node(5));
        LinkedList res = new LinkedList();

        LinkedList ans = SeparateTasks.addTwoLists(list1, list2);

        Assert.assertEquals(res.head, ans.head);
        Assert.assertEquals(res.tail, ans.tail);
    }

    @Test
    public void addTwoListsTestGivenEmptyLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList res = new LinkedList();

        LinkedList ans = SeparateTasks.addTwoLists(list1, list2);

        Assert.assertEquals(res.head, ans.head);
        Assert.assertEquals(res.tail, ans.tail);
    }
}
