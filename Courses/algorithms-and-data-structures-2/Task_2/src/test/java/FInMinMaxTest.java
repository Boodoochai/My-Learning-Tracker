import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FInMinMaxTest {
    @Test
    void InOnlyRootTree() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.AddKeyValue(1, 1);

        BSTNode<Integer> max_node = tree.FinMinMax(tree.Root, true);
        BSTNode<Integer> min_node = tree.FinMinMax(tree.Root, false);

        Assertions.assertEquals(1, max_node.NodeKey);
        Assertions.assertEquals(1, max_node.NodeValue);
        Assertions.assertEquals(1, min_node.NodeKey);
        Assertions.assertEquals(1, min_node.NodeValue);
    }

    @Test
    void InNormalTree() {
        BST<Integer> tree = new BST<Integer>(null);

        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(5, 5);

        BSTNode<Integer> max_node = tree.FinMinMax(tree.Root, true);
        BSTNode<Integer> min_node = tree.FinMinMax(tree.Root, false);

        Assertions.assertEquals(5, max_node.NodeKey);
        Assertions.assertEquals(5, max_node.NodeValue);
        Assertions.assertEquals(1, min_node.NodeKey);
        Assertions.assertEquals(1, min_node.NodeValue);
    }


}
