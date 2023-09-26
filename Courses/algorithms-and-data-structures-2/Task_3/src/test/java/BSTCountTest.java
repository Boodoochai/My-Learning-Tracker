import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTCountTest {
    @Test
    void EmptyTree(){
        BST<Integer> tree = new BST<>(null);

        int res = tree.Count();

        Assertions.assertEquals(0, res);
    }

    @Test
    void OnlyRootTree(){
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> tree = new BST<>(root);

        int res = tree.Count();

        Assertions.assertEquals(1, res);
    }

    @Test
    void EightNodeTree(){
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> tree = new BST<>(root);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 1);
        tree.AddKeyValue(3, 1);
        tree.AddKeyValue(4, 1);
        tree.AddKeyValue(5, 1);
        tree.AddKeyValue(6, 1);
        tree.AddKeyValue(7, 1);

        int res = tree.Count();

        Assertions.assertEquals(8, res);
    }

    @Test
    void TwoNodeTree(){
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> tree = new BST<>(root);
        tree.AddKeyValue(1, 1);

        int res = tree.Count();

        Assertions.assertEquals(2, res);
    }
}
