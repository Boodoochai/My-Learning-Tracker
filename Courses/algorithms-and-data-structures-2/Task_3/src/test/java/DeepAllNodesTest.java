import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeepAllNodesTest {
    @Test
    public void EmptyTreeInOrder() {
        BST<Integer> tree = new BST<>(null);

        List<BSTNode> ans = tree.DeepAllNodes(0);

        Assertions.assertEquals(0, ans.size());
    }

    @Test
    public void EmptyTreePostOrder() {
        BST<Integer> tree = new BST<>(null);

        List<BSTNode> ans = tree.DeepAllNodes(1);

        Assertions.assertEquals(0, ans.size());
    }

    @Test
    public void EmptyTreePreOrder() {
        BST<Integer> tree = new BST<>(null);

        List<BSTNode> ans = tree.DeepAllNodes(2);

        Assertions.assertEquals(0, ans.size());
    }

    @Test
    public void OneNodeTree() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);

        List<BSTNode> ans1 = tree.DeepAllNodes(0);
        List<BSTNode> ans2 = tree.DeepAllNodes(1);
        List<BSTNode> ans3 = tree.DeepAllNodes(2);

        Assertions.assertEquals(1, ans1.size());
        Assertions.assertEquals(1, ans1.get(0).NodeValue);
        Assertions.assertEquals(1, ans2.size());
        Assertions.assertEquals(1, ans2.get(0).NodeValue);
        Assertions.assertEquals(1, ans3.size());
        Assertions.assertEquals(1, ans3.get(0).NodeValue);
    }

    @Test
    public void TwoNodesTreeInOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);

        List<BSTNode> ans = tree.DeepAllNodes(0);

        Assertions.assertEquals(2, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
    }

    @Test
    public void TwoNodesTreePostOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);

        List<BSTNode> ans = tree.DeepAllNodes(1);

        Assertions.assertEquals(2, ans.size());
        Assertions.assertEquals(2, ans.get(0).NodeValue);
        Assertions.assertEquals(1, ans.get(1).NodeValue);
    }

    @Test
    public void TwoNodesTreePreOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);

        List<BSTNode> ans = tree.DeepAllNodes(2);

        Assertions.assertEquals(2, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
    }

    @Test
    public void ThreeNodesTreeInOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(0);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTreePostOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(1);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(3, ans.get(1).NodeValue);
        Assertions.assertEquals(2, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTreePreOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(2);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(2, ans.get(0).NodeValue);
        Assertions.assertEquals(1, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTreeInOrder2() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(0);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTreePostOrder2() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(1);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(3, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(1, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTreePreOrder2() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(2);

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    /* tree in test:
     *
     *       4
     *      /
     *     2
     *    / \
     *   1   3
     *
     * */
    @Test
    public void FourNodesTreeInOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(0);

        Assertions.assertEquals(4, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
        Assertions.assertEquals(4, ans.get(3).NodeValue);
    }

    /* tree in test:
    *
    *       4
    *      /
    *     2
    *    / \
    *   1   3
    *
    * */
    @Test
    public void FourNodesTreePostOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(1);

        Assertions.assertEquals(4, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(3, ans.get(1).NodeValue);
        Assertions.assertEquals(2, ans.get(2).NodeValue);
        Assertions.assertEquals(4, ans.get(3).NodeValue);
    }

    /* tree in test:
     *
     *       4
     *      /
     *     2
     *    / \
     *   1   3
     *
     * */
    @Test
    public void FourNodesTreePreOrder() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.DeepAllNodes(2);

        Assertions.assertEquals(4, ans.size());
        Assertions.assertEquals(4, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(1, ans.get(2).NodeValue);
        Assertions.assertEquals(3, ans.get(3).NodeValue);
    }
}
