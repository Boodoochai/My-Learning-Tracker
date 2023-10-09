import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenerateTest {
    @Test
    public void EmptyArray() {
        int[] input = {};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(0, tree.length);
    }

    @Test
    public void arrayOneLen() {
        int[] input = {1};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(1, tree[0]);
    }

    @Test
    public void arrayTwoLen() {
        int[] input = {5, 4};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(5, tree[0]);
        Assertions.assertEquals(4, tree[1]);
    }

    @Test
    public void arrayTwoLen2() {
        int[] input = {4, 5};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(5, tree[0]);
        Assertions.assertEquals(4, tree[1]);
    }

    @Test
    public void arrayThreeLen() {
        int[] input = {4, 5, 2};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(4, tree[0]);
        Assertions.assertEquals(2, tree[1]);
        Assertions.assertEquals(5, tree[2]);
    }

    @Test
    public void arrayThreeLen2() {
        int[] input = {2, 5, 4};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(4, tree[0]);
        Assertions.assertEquals(2, tree[1]);
        Assertions.assertEquals(5, tree[2]);
    }

    @Test
    public void arrayFourLen() {
        int[] input = {2, 5, 4, 1};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(4, tree[0]);
        Assertions.assertEquals(2, tree[1]);
        Assertions.assertEquals(5, tree[2]);
        Assertions.assertEquals(1, tree[3]);
    }

    @Test
    public void arrayFourLen2() {
        int[] input = {2, 1, 5, 4};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(4, tree[0]);
        Assertions.assertEquals(2, tree[1]);
        Assertions.assertEquals(5, tree[2]);
        Assertions.assertEquals(1, tree[3]);
    }

    @Test
    public void arrayFourLen3() {
        int[] input = {1, 4, 5, 2};
        int[] tree = AlgorithmsDataStructures2.GenerateBBSTArray(input);

        Assertions.assertEquals(4, tree[0]);
        Assertions.assertEquals(2, tree[1]);
        Assertions.assertEquals(5, tree[2]);
        Assertions.assertEquals(1, tree[3]);
    }
}
