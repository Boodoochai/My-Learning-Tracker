import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTFindNodeBYKeyTest {
    @Test
    void FindLeafTree(){
        BST<Integer> tree = new BST<>(null);
        BSTFind<Integer> ans = new BSTFind<>();

        BSTFind<Integer> res = tree.FindNodeByKey(1);

        Assertions.assertEquals(ans, res);
    }
}
