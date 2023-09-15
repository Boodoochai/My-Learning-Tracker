import SimpleTree.SimpleTree;
import SimpleTree.SimpleTreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleTreeTest {
    @Test
    void AddChildTestAddInOnlyRootTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);

        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);

        tree.AddChild(root, node1);

        List<SimpleTreeNode<Integer>> list = tree.FindNodesByValue(2);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.get(0), node1);
        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    void AddChildTestAddManyNodesToRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);

        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, root);

        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);
        List<SimpleTreeNode<Integer>> list2 = tree.FindNodesByValue(3);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 1);
        Assertions.assertEquals(list2.size(), 2);
        Assertions.assertEquals(list1.get(0), node1);
        if (list2.get(0) != node2) {
            Assertions.assertEquals(list2.get(0), node3);
            Assertions.assertEquals(list2.get(1), node2);
        } else {
            Assertions.assertEquals(list2.get(0), node2);
            Assertions.assertEquals(list2.get(1), node3);
        }
    }

    @Test
    void AddChildTestAddManyNodesNotToRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, node1);

        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node4);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);
        List<SimpleTreeNode<Integer>> list2 = tree.FindNodesByValue(3);
        List<SimpleTreeNode<Integer>> list3 = tree.FindNodesByValue(4);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 1);
        Assertions.assertEquals(list2.size(), 2);
        Assertions.assertEquals(list3.size(), 1);
        Assertions.assertEquals(list1.get(0), node1);
        Assertions.assertEquals(list3.get(0), node4);
        if (list2.get(0) != node2) {
            Assertions.assertEquals(list2.get(0), node3);
            Assertions.assertEquals(list2.get(1), node2);
        } else {
            Assertions.assertEquals(list2.get(0), node2);
            Assertions.assertEquals(list2.get(1), node3);
        }
    }

    @Test
    void DeleteNodeTestDeleteRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);

        tree.DeleteNode(root);

        Assertions.assertNull(tree.Root);
    }

    @Test
    void DeleteNodeTestDeleteLeaf() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, root);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);

        tree.DeleteNode(node2);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);
        List<SimpleTreeNode<Integer>> list2 = tree.FindNodesByValue(3);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 1);
        Assertions.assertEquals(list2.size(), 1);
        Assertions.assertEquals(list1.get(0), node1);
        Assertions.assertEquals(list2.get(0), node3);
    }

    @Test
    void DeleteNodeTestDeleteTheOnlyLeaf() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        tree.AddChild(root, node1);

        tree.DeleteNode(node1);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 0);
    }

    @Test
    void DeleteNodeTestDeleteSubTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(5, node1);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node1, node4);

        tree.DeleteNode(node1);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);
        List<SimpleTreeNode<Integer>> list2 = tree.FindNodesByValue(3);
        List<SimpleTreeNode<Integer>> list3 = tree.FindNodesByValue(4);
        List<SimpleTreeNode<Integer>> list4 = tree.FindNodesByValue(5);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 0);
        Assertions.assertEquals(list2.size(), 0);
        Assertions.assertEquals(list3.size(), 0);
        Assertions.assertEquals(list4.size(), 0);
    }

    @Test
    void DeleteNodeTestDeleteSubTree2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(5, node2);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node2, node4);

        tree.DeleteNode(node2);

        List<SimpleTreeNode<Integer>> list1 = tree.FindNodesByValue(2);
        List<SimpleTreeNode<Integer>> list2 = tree.FindNodesByValue(3);
        List<SimpleTreeNode<Integer>> list3 = tree.FindNodesByValue(4);
        List<SimpleTreeNode<Integer>> list4 = tree.FindNodesByValue(5);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list1.size(), 1);
        Assertions.assertEquals(list1.get(0), node1);
        Assertions.assertEquals(list2.size(), 0);
        Assertions.assertEquals(list3.size(), 0);
        Assertions.assertEquals(list4.size(), 0);
    }

    @Test
    void GetAllNodesTestEmptyTree() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);

        List<SimpleTreeNode<Integer>> list = tree.GetAllNodes();

        Assertions.assertNull(tree.Root);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void GetAllNodesTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(5, node2);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node4);

        List<SimpleTreeNode<Integer>> list = tree.GetAllNodes();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 5);
        Assertions.assertTrue(list.contains(root));
        Assertions.assertTrue(list.contains(node1));
        Assertions.assertTrue(list.contains(node2));
        Assertions.assertTrue(list.contains(node3));
        Assertions.assertTrue(list.contains(node4));
    }

    @Test
    void GetAllNodesTest2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(5, node3);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node4);

        List<SimpleTreeNode<Integer>> list = tree.GetAllNodes();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 5);
        Assertions.assertTrue(list.contains(root));
        Assertions.assertTrue(list.contains(node1));
        Assertions.assertTrue(list.contains(node2));
        Assertions.assertTrue(list.contains(node3));
        Assertions.assertTrue(list.contains(node4));
    }

    @Test
    void GetAllNodesTestOnlyRootTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);

        List<SimpleTreeNode<Integer>> list = tree.GetAllNodes();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 1);
        Assertions.assertTrue(list.contains(root));
    }

    @Test
    void FindNodesByValueTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node4);

        List<SimpleTreeNode<Integer>> list = tree.FindNodesByValue(3);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertTrue(list.contains(node2));
        Assertions.assertTrue(list.contains(node4));
    }

    @Test
    void FindNodesByValueTestAllNodesRight() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        List<SimpleTreeNode<Integer>> list = tree.FindNodesByValue(3);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 5);
        Assertions.assertTrue(list.contains(root));
        Assertions.assertTrue(list.contains(node1));
        Assertions.assertTrue(list.contains(node2));
        Assertions.assertTrue(list.contains(node3));
        Assertions.assertTrue(list.contains(node4));
    }

    @Test
    void FindNodesByValueTestEmptyTree() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);

        List<SimpleTreeNode<Integer>> list = tree.FindNodesByValue(4);

        Assertions.assertNull(tree.Root);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void FindNodesByValueTestNoRightNodes() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        List<SimpleTreeNode<Integer>> list = tree.FindNodesByValue(4);

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    void CountTestEmptyTree() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);

        int count = tree.Count();

        Assertions.assertNull(tree.Root);
        Assertions.assertEquals(0, count);
    }

    @Test
    void CountTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        int count = tree.Count();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(5, count);
    }

    @Test
    void CountTestOnlyRootTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);

        int count = tree.Count();

        Assertions.assertEquals(root, tree.Root);
        Assertions.assertEquals(1, count);
    }

    @Test
    void LeafCountTest1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node4);

        int count = tree.LeafCount();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(4, count);
    }

    @Test
    void LeafCountTest2() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        int count = tree.LeafCount();

        Assertions.assertEquals(tree.Root, root);
        Assertions.assertEquals(1, count);
    }

    @Test
    void LeafCountTestEmptyTree() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);

        int count = tree.LeafCount();

        Assertions.assertNull(tree.Root);
        Assertions.assertEquals(0, count);
    }

    @Test
    void MoveNodeTestMoveLeaf() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        tree.MoveNode(node4, root);

        Assertions.assertEquals(root, tree.Root);
        Assertions.assertEquals(tree.Root, node4.Parent);
        Assertions.assertFalse(node3.Children.contains(node4));
    }

    @Test
    void MoveNodeTestMoveSubTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(3, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(3, node3);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node2, node3);
        tree.AddChild(node3, node4);

        tree.MoveNode(node2, root);

        Assertions.assertEquals(root, tree.Root);
        Assertions.assertEquals(tree.Root, node2.Parent);
        Assertions.assertFalse(node1.Children.contains(node2));
    }
}