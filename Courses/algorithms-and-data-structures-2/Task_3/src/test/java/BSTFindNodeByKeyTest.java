import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTFindNodeByKeyTest {
    @Test
    void FindLeafEmptyTree(){
        BST<Integer> tree = new BST<>(null);

        BSTFind<Integer> res = tree.FindNodeByKey(1);

        Assertions.assertNull(res);
    }

    @Test
    void FindInOnlyRootTree(){
        BSTNode<Integer> root = new BSTNode<>(1, 10, null);
        BST<Integer> tree = new BST<>(root);
        BSTFind<Integer> ans = new BSTFind<>();
        ans.Node = root;
        ans.NodeHasKey = true;

        BSTFind<Integer> res = tree.FindNodeByKey(1);

        Assertions.assertEquals(ans.Node, res.Node);
    }

    @Test
    void FindInNormalTree(){
        BSTNode<Integer> root = new BSTNode<>(1, 10, null);
        BST<Integer> tree = new BST<>(root);
        BSTFind<Integer> ans1 = new BSTFind<>();
        ans1.Node = root;
        ans1.NodeHasKey = true;
        tree.AddKeyValue(2, 11);
        tree.AddKeyValue(3, 12);
        tree.AddKeyValue(4, 13);
        tree.AddKeyValue(5, 14);

        BSTFind<Integer> res1 = tree.FindNodeByKey(1);
        BSTFind<Integer> res2 = tree.FindNodeByKey(2);
        BSTFind<Integer> res3 = tree.FindNodeByKey(3);
        BSTFind<Integer> res4 = tree.FindNodeByKey(4);
        BSTFind<Integer> res5 = tree.FindNodeByKey(5);

        Assertions.assertEquals(ans1.Node, res1.Node);
        Assertions.assertTrue(res2.NodeHasKey);
        Assertions.assertTrue(res3.NodeHasKey);
        Assertions.assertTrue(res4.NodeHasKey);
        Assertions.assertTrue(res5.NodeHasKey);
        Assertions.assertEquals(11, res2.Node.NodeValue);
        Assertions.assertEquals(12, res3.Node.NodeValue);
        Assertions.assertEquals(13, res4.Node.NodeValue);
        Assertions.assertEquals(14, res5.Node.NodeValue);
    }

}
