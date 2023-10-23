import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTest {
    @Test
    public void EmptyHeap() {
        Heap heap = new Heap();
        boolean res1 = heap.Add(1);

        Assertions.assertFalse(res1);
    }

    @Test
    public void OneNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 1);

        boolean res1 = heap.Add(1);

        Assertions.assertTrue(res1);
        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(1, heap.HeapArray[0]);
    }

    @Test
    public void TwoNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 1);

        boolean res1 = heap.Add(1);
        boolean res2 = heap.Add(2);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(2, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
    }

    @Test
    public void ThreeNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 1);

        boolean res1 = heap.Add(1);
        boolean res2 = heap.Add(2);
        boolean res3 = heap.Add(3);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertTrue(res3);
        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(3, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void FourNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 2);

        boolean res1 = heap.Add(1);
        boolean res2 = heap.Add(2);
        boolean res3 = heap.Add(3);
        boolean res4 = heap.Add(4);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertTrue(res3);
        Assertions.assertTrue(res4);
        Assertions.assertEquals(7, heap.HeapArray.length);
        Assertions.assertEquals(4, heap.HeapArray[0]);
        Assertions.assertEquals(3, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
        Assertions.assertEquals(1, heap.HeapArray[3]);
    }

    @Test
    public void FourNodeTree2() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 1);

        boolean res1 = heap.Add(1);
        boolean res2 = heap.Add(2);
        boolean res3 = heap.Add(3);
        boolean res4 = heap.Add(4);

        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
        Assertions.assertTrue(res3);
        Assertions.assertFalse(res4);
        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(3, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
    }
}
