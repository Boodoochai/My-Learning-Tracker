import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WideAllNodesTest {
    @Test
    public void EmptyTree() {
        BST<Integer> tree = new BST<>(null);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(0, ans.size());
    }

    @Test
    public void OneNodeTree() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(1, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
    }

    @Test
    public void TwoNodesTree() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(2, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
    }

    @Test
    public void ThreeNodesTree() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(2, ans.get(0).NodeValue);
        Assertions.assertEquals(1, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    @Test
    public void ThreeNodesTree2() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals(1, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(3, ans.get(2).NodeValue);
    }

    @Test
    public void FourNodesTree() {
        BST<Integer> tree = new BST<>(null);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        List<BSTNode> ans = tree.WideAllNodes();

        Assertions.assertEquals(4, ans.size());
        Assertions.assertEquals(4, ans.get(0).NodeValue);
        Assertions.assertEquals(2, ans.get(1).NodeValue);
        Assertions.assertEquals(1, ans.get(2).NodeValue);
        Assertions.assertEquals(3, ans.get(3).NodeValue);
    }
}
