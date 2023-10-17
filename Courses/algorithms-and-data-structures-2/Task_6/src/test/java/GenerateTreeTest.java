import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenerateTreeTest {
    @Test
    public void EmptyTree() {
        BalancedBST tree = new BalancedBST();
        int[] a = {};
        tree.GenerateTree(a);
        Assertions.assertNull(tree.Root);
    }

    @Test
    public void OneNodeTree() {
        BalancedBST tree = new BalancedBST();
        int[] a = {1};
        tree.GenerateTree(a);
        Assertions.assertEquals(1, tree.Root.NodeKey);
        Assertions.assertEquals(0, tree.Root.Level);
        Assertions.assertNull(tree.Root.LeftChild);
        Assertions.assertNull(tree.Root.RightChild);
        Assertions.assertTrue(tree.IsBalanced(tree.Root));
    }

    @Test
    public void TwoNodeTree() {
        BalancedBST tree = new BalancedBST();
        int[] a = {2, 1};
        tree.GenerateTree(a);
        Assertions.assertEquals(2, tree.Root.NodeKey);
        Assertions.assertEquals(0, tree.Root.Level);
        Assertions.assertNull(tree.Root.RightChild);
        Assertions.assertEquals(1, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.LeftChild.Level);
        Assertions.assertTrue(tree.IsBalanced(tree.Root));
    }

    @Test
    public void ThreeNodeTree() {
        BalancedBST tree = new BalancedBST();
        int[] a = {1, 2, 3};
        tree.GenerateTree(a);
        Assertions.assertEquals(2, tree.Root.NodeKey);
        Assertions.assertEquals(0, tree.Root.Level);
        Assertions.assertEquals(1, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.LeftChild.Level);
        Assertions.assertEquals(3, tree.Root.RightChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.RightChild.Level);
        Assertions.assertTrue(tree.IsBalanced(tree.Root));
    }

    @Test
    public void FourNodeTree() {
        BalancedBST tree = new BalancedBST();
        int[] a = {1, 2, 3, 8};
        tree.GenerateTree(a);
        Assertions.assertEquals(3, tree.Root.NodeKey);
        Assertions.assertEquals(0, tree.Root.Level);
        Assertions.assertEquals(2, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.LeftChild.Level);
        Assertions.assertEquals(8, tree.Root.RightChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.RightChild.Level);
        Assertions.assertEquals(1, tree.Root.LeftChild.LeftChild.NodeKey);
        Assertions.assertEquals(2, tree.Root.LeftChild.LeftChild.Level);
        Assertions.assertTrue(tree.IsBalanced(tree.Root));
    }
}
