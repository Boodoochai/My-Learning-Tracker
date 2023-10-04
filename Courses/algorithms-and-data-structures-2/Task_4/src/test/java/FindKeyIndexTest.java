import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindKeyIndexTest {
    @Test
    public void EmptyTreeDepthOne() {
        aBST tree = new aBST(1);

        Integer res1 = tree.FindKeyIndex(1);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(0);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(0, res2);
        Assertions.assertEquals(0, res3);
    }

    @Test
    public void EmptyTreeDepthTen() {
        aBST tree = new aBST(10);

        Integer res1 = tree.FindKeyIndex(1);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(0);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(0, res2);
        Assertions.assertEquals(0, res3);
    }

    @Test
    public void OnlyRootTree() {
        aBST tree = new aBST(1);
        tree.Tree[0] = 1;

        Integer res1 = tree.FindKeyIndex(1);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(1);

        Assertions.assertEquals(0, res1);
        Assertions.assertNull(res2);
        Assertions.assertEquals(0, res3);
    }

    @Test
    public void OnlyRootTreeBigDepth() {
        aBST tree = new aBST(10);
        tree.Tree[0] = 4;

        Integer res1 = tree.FindKeyIndex(4);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(4);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(-1, res2);
        Assertions.assertEquals(0, res3);
    }

    @Test
    public void TwoNodesTree() {
        aBST tree = new aBST(10);
        tree.Tree[0] = 4;
        tree.Tree[2] = 5;

        Integer res1 = tree.FindKeyIndex(4);
        Integer res3 = tree.FindKeyIndex(4);
        Integer res4 = tree.FindKeyIndex(5);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(0, res3);
        Assertions.assertEquals(2, res4);
    }

    @Test
    public void ThreeNodesTree() {
        aBST tree = new aBST(10);
        tree.Tree[0] = 4;
        tree.Tree[1] = 2;
        tree.Tree[2] = 5;

        Integer res1 = tree.FindKeyIndex(4);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(4);
        Integer res4 = tree.FindKeyIndex(5);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(1, res2);
        Assertions.assertEquals(0, res3);
        Assertions.assertEquals(2, res4);
    }

    public void ThreeNodesTree2() {
        aBST tree = new aBST(10);
        tree.Tree[0] = 4;
        tree.Tree[2] = 5;
        tree.Tree[6] = 8;

        Integer res1 = tree.FindKeyIndex(4);
        Integer res2 = tree.FindKeyIndex(2);
        Integer res3 = tree.FindKeyIndex(4);
        Integer res4 = tree.FindKeyIndex(5);
        Integer res5 = tree.FindKeyIndex(8);

        Assertions.assertEquals(0, res1);
        Assertions.assertEquals(6, res5);
        Assertions.assertEquals(0, res3);
        Assertions.assertEquals(2, res4);
        Assertions.assertNull(res2);
    }
}