import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeHeapTest {
    @Test
    public void EmptyTree() {
        Heap heap = new Heap();
        int[] heap_arr = {};
        heap.MakeHeap(heap_arr, 1);

        Assertions.assertEquals(3, heap.HeapArray.length);
    }

    @Test
    public void OneNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {1};
        heap.MakeHeap(heap_arr, 1);

        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(1, heap.HeapArray[0]);
    }

    @Test
    public void TwoNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {1, 2};
        heap.MakeHeap(heap_arr, 1);

        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(2, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
    }

    @Test
    public void ThreeNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {1, 2, 3};
        heap.MakeHeap(heap_arr, 1);

        Assertions.assertEquals(3, heap.HeapArray.length);
        Assertions.assertEquals(3, heap.HeapArray[0]);
        Assertions.assertEquals(1, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
    }

    @Test
    public void FourNodeTree() {
        Heap heap = new Heap();
        int[] heap_arr = {1, 2, 3, 4};
        heap.MakeHeap(heap_arr, 2);

        Assertions.assertEquals(7, heap.HeapArray.length);
        Assertions.assertEquals(4, heap.HeapArray[0]);
        Assertions.assertEquals(3, heap.HeapArray[1]);
        Assertions.assertEquals(2, heap.HeapArray[2]);
        Assertions.assertEquals(1, heap.HeapArray[3]);
    }
}
