import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EvenTreeTest {
    @Test
    public void FirstTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(5, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(7, node1);

        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(4, node4);

        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<>(6, root);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<>(8, node6);
        SimpleTreeNode<Integer> node8 = new SimpleTreeNode<>(9, node7);
        SimpleTreeNode<Integer> node9 = new SimpleTreeNode<>(10, node7);

        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node1, node3);
        tree.AddChild(root, node4);
        tree.AddChild(node4, node5);
        tree.AddChild(root, node6);
        tree.AddChild(node6, node7);
        tree.AddChild(node7, node8);
        tree.AddChild(node7, node9);

        ArrayList<Integer> answer = tree.EvenTrees();

        Assertions.assertEquals(1, answer.get(0));
        Assertions.assertEquals(3, answer.get(1));
        Assertions.assertEquals(1, answer.get(2));
        Assertions.assertEquals(6, answer.get(3));
    }
}
