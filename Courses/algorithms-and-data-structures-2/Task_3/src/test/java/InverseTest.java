import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InverseTest {
    @Test
    public void EmptyTree() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.Inverse();

        Assertions.assertNull(tree.Root);
    }

    @Test
    public void OnlyRootTree() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(1, 1);

        tree.Inverse();

        Assertions.assertEquals(1, tree.Count());
        Assertions.assertEquals(1, tree.Root.NodeValue);
    }

    @Test
    public void TwoNodesTree() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);

        tree.Inverse();

        Assertions.assertEquals(2, tree.Count());
        Assertions.assertEquals(1, tree.Root.NodeValue);
        Assertions.assertEquals(2, tree.Root.LeftChild.NodeKey);
    }

    @Test
    public void TwoNodesTree2() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);

        tree.Inverse();

        Assertions.assertEquals(2, tree.Count());
        Assertions.assertEquals(2, tree.Root.NodeValue);
        Assertions.assertEquals(1, tree.Root.RightChild.NodeKey);
    }

    @Test
    public void ThreeNodesTree() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);

        tree.Inverse();

        Assertions.assertEquals(3, tree.Count());
        Assertions.assertEquals(1, tree.Root.NodeValue);
        Assertions.assertEquals(2, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(3, tree.Root.LeftChild.LeftChild.NodeKey);
    }

    @Test
    public void ThreeNodesTree2() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);

        tree.Inverse();

        Assertions.assertEquals(3, tree.Count());
        Assertions.assertEquals(2, tree.Root.NodeValue);
        Assertions.assertEquals(3, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.RightChild.NodeKey);
    }

    @Test
    public void FourNodesTree() {
        BST<Integer> tree = new BST<Integer>(null);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);

        tree.Inverse();

        Assertions.assertEquals(4, tree.Count());
        Assertions.assertEquals(2, tree.Root.NodeValue);
        Assertions.assertEquals(3, tree.Root.LeftChild.NodeKey);
        Assertions.assertEquals(4, tree.Root.LeftChild.LeftChild.NodeKey);
        Assertions.assertEquals(1, tree.Root.RightChild.NodeKey);
    }
}
