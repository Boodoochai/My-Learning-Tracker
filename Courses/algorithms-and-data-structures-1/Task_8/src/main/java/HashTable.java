public class HashTable {
    public int size;
    public int step;
    public String [] slots;
    private int elements_count;

    public HashTable(int sz, int stp) {
      size = sz;
      step = stp;
      slots = new String[size];
      elements_count = 0;
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int sum = 0;
        for (char c : value.toCharArray()) {
            sum = (sum + c) % size;
        }
        return sum;
    }

    public int seekSlot(String value) {
        if (elements_count == size)
            return -1;
        int hash = hashFun(value);
        while (slots[hash] != null)
            hash = (hash + step) % size;
        return hash;
    }

    public int put(String value) {
        int slot = seekSlot(value);
        if (slot == -1)
            return -1;
        slots[slot] = value;
        elements_count += 1;
        return slot;
    }

    public int find(String value) {
        int slot = hashFun(value);
        while (slots[slot] != value && slots[slot] != null)
            slot = (slot + step) % size;
        if (slots[slot] == null)
            return -1;
        return slot;
    }
  }
