import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddKeyTest {
    @Test
    public void TreeOverflowZeroDepth() {
        aBST tree = new aBST(0);

        int res2 = tree.AddKey(3);
        int res1 = tree.AddKey(6);

        Assertions.assertEquals(-1, res1);
    }

    @Test
    public void TreeOverflowOneDepth() {
        aBST tree = new aBST(1);

        for (int i = 0; i < 3; i++) {
            tree.AddKey(i);
        }

        int res2 = tree.AddKey(2);

        Assertions.assertEquals(-1, res2);
    }

    @Test
    public void TreeOverflowTwoDepth() {
        aBST tree = new aBST(2);

        for (int i = 0; i < 7; i++) {
            tree.AddKey(i);
        }

        int res1 = tree.AddKey(42);

        Assertions.assertEquals(-1, res1);
    }

    @Test
    public void TreeOverflowThreeDepth() {
        aBST tree = new aBST(3);

        for (int i = 0; i < 15; i++) {
            tree.AddKey(i);
        }

        int res1 = tree.AddKey(42);

        Assertions.assertEquals(-1, res1);
    }

    @Test
    public void EmptyTree() {
        aBST tree = new aBST(10);

        tree.AddKey(6);

        Assertions.assertEquals(6, tree.Tree[0]);
        Assertions.assertNull(tree.Tree[1]);
        Assertions.assertNull(tree.Tree[2]);
    }

    @Test
    public void OnlyRootTree() {
        aBST tree = new aBST(10);

        tree.AddKey(6);
        tree.AddKey(5);

        Assertions.assertEquals(6, tree.Tree[0]);
        Assertions.assertEquals(5, tree.Tree[1]);
        Assertions.assertNull(tree.Tree[2]);
    }

    @Test
    public void NormalTree() {
        aBST tree = new aBST(10);

        tree.AddKey(6);
        tree.AddKey(5);
        tree.AddKey(4);
        tree.AddKey(9);

        Assertions.assertEquals(6, tree.Tree[0]);
        Assertions.assertEquals(5, tree.Tree[1]);
        Assertions.assertEquals(9, tree.Tree[2]);
        Assertions.assertEquals(4, tree.Tree[3]);
    }

    @Test
    public void NormalTree2() {
        aBST tree = new aBST(10);

        tree.AddKey(5);
        tree.AddKey(6);
        tree.AddKey(4);
        tree.AddKey(9);

        Assertions.assertEquals(5, tree.Tree[0]);
        Assertions.assertEquals(4, tree.Tree[1]);
        Assertions.assertEquals(6, tree.Tree[2]);
        Assertions.assertEquals(9, tree.Tree[6]);
    }

    @Test
    public void NormalTree3() {
        aBST tree = new aBST(10);

        tree.AddKey(9);
        tree.AddKey(5);
        tree.AddKey(6);
        tree.AddKey(4);

        Assertions.assertEquals(9, tree.Tree[0]);
        Assertions.assertEquals(5, tree.Tree[1]);
        Assertions.assertEquals(4, tree.Tree[3]);
        Assertions.assertEquals(6, tree.Tree[4]);
    }
}
