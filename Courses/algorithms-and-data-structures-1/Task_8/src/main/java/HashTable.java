public class HashTable {
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++)
            slots[i] = null;
    }

    public int hashFun(String value) {
        int sum = 0;
        for (char c : value.toCharArray())
            sum = (sum + c) % size;
        return sum;
    }

    public int seekSlot(String value) {
        int hash = hashFun(value);
        int slot = hash;
        while (slots[slot % size] != null) {
            slot = slot + step;
            if (slot >= hash + size)
                return -1;
        }
        return slot % size;
    }

    public int put(String value) {
        int slot = seekSlot(value);
        if (slot == -1)
            return -1;
        slots[slot] = value;
        return slot;
    }

    public int find(String value) {
        int hash = hashFun(value);
        int slot = hash;
        while (!value.equals(slots[slot % size])) {
            slot = slot + step;
            if (slots[slot % size] == null || slot >= hash + size)
                return -1;
        }
        return slot % size;
    }
}
