import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddKeyValueTest {
    @Test
    void InEmptyTree() {
        BST<Integer> tree = new BST<Integer>(null);

        boolean res1 = tree.AddKeyValue(1, 1);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);

        Assertions.assertTrue(res1);
        Assertions.assertEquals(tree.Root, ans1.Node);
        Assertions.assertTrue(ans1.NodeHasKey);
        Assertions.assertEquals(1, tree.Count());
    }

    @Test
    void InOnlyRootTree() {
        BST<Integer> tree = new BST<Integer>(null);

        boolean res1 = tree.AddKeyValue(1, 1);
        boolean res2 = tree.AddKeyValue(2, 2);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);

        Assertions.assertEquals(2, tree.Count());
        Assertions.assertTrue(res1);
        Assertions.assertEquals(1, ans1.Node.NodeValue);
        Assertions.assertTrue(ans1.NodeHasKey);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(2, ans2.Node.NodeValue);
        Assertions.assertTrue(ans2.NodeHasKey);
    }

    @Test
    void InNormalTree() {
        BST<Integer> tree = new BST<Integer>(null);

        boolean res1 = tree.AddKeyValue(1, 1);
        boolean res2 = tree.AddKeyValue(2, 2);
        boolean res3 = tree.AddKeyValue(3, 3);
        boolean res4 = tree.AddKeyValue(4, 4);
        boolean res5 = tree.AddKeyValue(5, 5);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);
        BSTFind<Integer> ans3 = tree.FindNodeByKey(3);
        BSTFind<Integer> ans4 = tree.FindNodeByKey(4);
        BSTFind<Integer> ans5 = tree.FindNodeByKey(5);

        Assertions.assertEquals(5, tree.Count());
        Assertions.assertTrue(res1);
        Assertions.assertEquals(1, ans1.Node.NodeValue);
        Assertions.assertTrue(ans1.NodeHasKey);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(2, ans2.Node.NodeValue);
        Assertions.assertTrue(ans2.NodeHasKey);
        Assertions.assertTrue(res3);
        Assertions.assertEquals(3, ans3.Node.NodeValue);
        Assertions.assertTrue(ans3.NodeHasKey);
        Assertions.assertTrue(res4);
        Assertions.assertEquals(4, ans4.Node.NodeValue);
        Assertions.assertTrue(ans4.NodeHasKey);
        Assertions.assertTrue(res5);
        Assertions.assertEquals(5, ans5.Node.NodeValue);
        Assertions.assertTrue(ans5.NodeHasKey);
    }
}
