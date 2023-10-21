import static java.lang.Math.pow;

class Heap {
    public int[] HeapArray;
    private int elementsNum;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        HeapArray = new int[(int) pow(2, depth + 1) - 1];
        for (int x : a) {
            this.Add(x);
        }
        elementsNum = a.length;
    }

    public int GetMax() {
        if (HeapArray == null || elementsNum == 0) {
            return -1;
        }
        int res = HeapArray[0];
        HeapArray[0] = HeapArray[elementsNum - 1];
        elementsNum -= 1;
        HeapifyDown(0);
        return res;
    }

    public boolean Add(int key) {
        if (elementsNum == HeapArray.length) {
            return false;
        }
        elementsNum += 1;
        HeapArray[elementsNum-2] = key;
        HeapifyUp(elementsNum-2);
        return true;
    }

    private void HeapifyUp(int ind) {
        if (HeapArray[ind] > HeapArray[(ind-1)/2]) {
            int tmp = HeapArray[ind];
            HeapArray[ind] = HeapArray[(ind-1)/2];
            HeapArray[(ind-1)/2] = tmp;
            HeapifyUp((ind-1)/2);
        }
    }

    private void HeapifyDown(int ind) {
        if (HeapArray[ind] > HeapArray[ind*2+1] && HeapArray[ind] > HeapArray[ind*2+2]) {
            return;
        }
        if (HeapArray[ind*2+1] > HeapArray[ind*2+2]) {
            int tmp = HeapArray[ind];
            HeapArray[ind] = HeapArray[ind*2+1];
            HeapArray[ind*2+1] = tmp;
            HeapifyDown(ind*2+1);
        } else {
            int tmp = HeapArray[ind];
            HeapArray[ind] = HeapArray[ind*2+2];
            HeapArray[ind*2+2] = tmp;
            HeapifyDown(ind*2+2);
        }
    }

}