import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddKeyTest {
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
