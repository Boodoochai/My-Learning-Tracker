import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeByKeyTest {
    @Test
    void FromEmptyTree() {
        BST<Integer> tree = new BST<Integer>(null);

        boolean res = tree.DeleteNodeByKey(1);

        Assertions.assertFalse(res);
    }

    @Test
    void FromOnlyRootTree() {
        BSTNode<Integer> root = new BSTNode<>(1, 2, null);
        BST<Integer> tree = new BST<Integer>(root);

        boolean res = tree.DeleteNodeByKey(1);

        Assertions.assertTrue(res);
        Assertions.assertNull(tree.Root);
    }

    @Test
    void FromNormalTree() {
        BSTNode<Integer> root = new BSTNode<>(1, 1, null);
        BST<Integer> tree = new BST<Integer>(root);

        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);

        boolean res1 = tree.DeleteNodeByKey(1);
        boolean res2 = tree.DeleteNodeByKey(2);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);
        BSTFind<Integer> ans3 = tree.FindNodeByKey(3);
        BSTFind<Integer> ans4 = tree.FindNodeByKey(4);

        BST<Integer> resTree = new BST<>(null);
        resTree.AddKeyValue(3, 3);
        resTree.AddKeyValue(4, 4);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(resTree.Count(), tree.Count());
        Assertions.assertFalse(ans1.NodeHasKey);
        Assertions.assertFalse(ans2.NodeHasKey);
        Assertions.assertTrue(ans3.NodeHasKey);
        Assertions.assertTrue(ans4.NodeHasKey);
        Assertions.assertNull(ans2.Node.Parent);
    }

    @Test
    void FromNormalTree2() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);

        boolean res1 = tree.DeleteNodeByKey(1);
        boolean res2 = tree.DeleteNodeByKey(2);
        boolean res3 = tree.DeleteNodeByKey(3);
        boolean res4 = tree.DeleteNodeByKey(4);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);
        BSTFind<Integer> ans3 = tree.FindNodeByKey(3);
        BSTFind<Integer> ans4 = tree.FindNodeByKey(4);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertTrue(res3);
        Assertions.assertTrue(res4);
        Assertions.assertEquals(0, tree.Count());
        Assertions.assertNull(ans1);
        Assertions.assertNull(ans2);
        Assertions.assertNull(ans3);
        Assertions.assertNull(ans4);
        Assertions.assertNull(tree.Root);
    }

    @Test
    void FromNormalTree3() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);

        boolean res1 = tree.DeleteNodeByKey(4);
        boolean res2 = tree.DeleteNodeByKey(2);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);
        BSTFind<Integer> ans3 = tree.FindNodeByKey(3);
        BSTFind<Integer> ans4 = tree.FindNodeByKey(4);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(2, tree.Count());
        Assertions.assertTrue(ans1.NodeHasKey);
        Assertions.assertFalse(ans2.NodeHasKey);
        Assertions.assertTrue(ans3.NodeHasKey);
        Assertions.assertFalse(ans4.NodeHasKey);
    }

    @Test
    void FromNormalTree4() {
        BST<Integer> tree = new BST<Integer>(null);

        int nodesToTest = 20;
        int nodesToDelete = 10;

        for (int i = 0; i < nodesToTest; i ++) {
            tree.AddKeyValue(i, i);
        }

        List<Boolean> results = new ArrayList<>(nodesToTest);

        for (int i = 0; i < nodesToDelete; i ++) {
            results.add(tree.DeleteNodeByKey(i));
        }

        List<BSTFind<Integer>> answers = new ArrayList<>(nodesToTest);

        for (int i = 0; i < nodesToTest; i ++) {
            answers.add(tree.FindNodeByKey(i));
        }

        for (int i = 0; i < nodesToTest; i ++) {
            if (i < nodesToDelete) {
                Assertions.assertEquals(true, results.get(i));
                Assertions.assertFalse(answers.get(i).NodeHasKey);
            } else {
                Assertions.assertEquals(i, answers.get(i).Node.NodeValue);
                Assertions.assertEquals(i, answers.get(i).Node.NodeKey);
                Assertions.assertTrue(answers.get(i).NodeHasKey);
            }
        }

    }

    @Test
    void FromNormalTree5() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(100, 100);

        boolean res1 = tree.DeleteNodeByKey(100);
        boolean res2 = tree.DeleteNodeByKey(2);

        BSTFind<Integer> ans1 = tree.FindNodeByKey(1);
        BSTFind<Integer> ans2 = tree.FindNodeByKey(2);
        BSTFind<Integer> ans3 = tree.FindNodeByKey(3);
        BSTFind<Integer> ans4 = tree.FindNodeByKey(4);
        BSTFind<Integer> ans5 = tree.FindNodeByKey(10);
        BSTFind<Integer> ans6 = tree.FindNodeByKey(100);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(4, tree.Count());
        Assertions.assertTrue(ans1.NodeHasKey);
        Assertions.assertFalse(ans2.NodeHasKey);
        Assertions.assertTrue(ans3.NodeHasKey);
        Assertions.assertTrue(ans4.NodeHasKey);
        Assertions.assertTrue(ans5.NodeHasKey);
        Assertions.assertFalse(ans6.NodeHasKey);
    }
}
