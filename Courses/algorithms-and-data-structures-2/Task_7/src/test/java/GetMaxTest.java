import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetMaxTest {
    @Test
    public void EmptyTree() {
        Heap heap = new Heap();

        int res1 = heap.GetMax();

        Assertions.assertEquals(-1, res1);
    }

    @Test
    public void OneNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {1};
        heap.MakeHeap(heap_arr, 1);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();

        Assertions.assertEquals(1, res1);
        Assertions.assertEquals(-1, res2);
    }

    @Test
    public void ThreeNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {4, 2, 8};
        heap.MakeHeap(heap_arr, 1);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();
        int res3 = heap.GetMax();
        int res4 = heap.GetMax();

        Assertions.assertEquals(8, res1);
        Assertions.assertEquals(4, res2);
        Assertions.assertEquals(2, res3);
        Assertions.assertEquals(-1, res4);
    }

    @Test
    public void ThreeNodeTree2() {
        Heap heap = new Heap();
        int[] heap_arr = {8, 4, 2};
        heap.MakeHeap(heap_arr, 1);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();
        int res3 = heap.GetMax();
        int res4 = heap.GetMax();

        Assertions.assertEquals(8, res1);
        Assertions.assertEquals(4, res2);
        Assertions.assertEquals(2, res3);
        Assertions.assertEquals(-1, res4);
    }

    @Test
    public void ThreeNodeTree3() {
        Heap heap = new Heap();
        int[] heap_arr = {2, 4, 8};
        heap.MakeHeap(heap_arr, 1);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();
        int res3 = heap.GetMax();
        int res4 = heap.GetMax();

        Assertions.assertEquals(8, res1);
        Assertions.assertEquals(4, res2);
        Assertions.assertEquals(2, res3);
        Assertions.assertEquals(-1, res4);
    }

    @Test
    public void FiveNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {2, 4, 8, 7, 4};
        heap.MakeHeap(heap_arr, 2);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();
        int res3 = heap.GetMax();
        int res4 = heap.GetMax();
        int res5 = heap.GetMax();
        int res6 = heap.GetMax();

        Assertions.assertEquals(8, res1);
        Assertions.assertEquals(7, res2);
        Assertions.assertEquals(4, res3);
        Assertions.assertEquals(4, res4);
        Assertions.assertEquals(2, res5);
        Assertions.assertEquals(-1, res6);
    }

    @Test
    public void FiveNodeTree2() {
        Heap heap = new Heap();
        int[] heap_arr = {7, 8, 4, 2, 4};
        heap.MakeHeap(heap_arr, 2);

        int res1 = heap.GetMax();
        int res2 = heap.GetMax();
        int res3 = heap.GetMax();
        int res4 = heap.GetMax();
        int res5 = heap.GetMax();
        int res6 = heap.GetMax();

        Assertions.assertEquals(8, res1);
        Assertions.assertEquals(7, res2);
        Assertions.assertEquals(4, res3);
        Assertions.assertEquals(4, res4);
        Assertions.assertEquals(2, res5);
        Assertions.assertEquals(-1, res6);
    }
}
