class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    private int values_num;

    public NativeCache(int _size, Class clazz) {
        size = _size;
        slots = new String[size];
        values = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        hits = new int[size];
    }

    int hashFun(String val) {
        int hash = 0;
        for (char x : val.toCharArray()) {
            hash = (hash + x) % size;
        }
        return hash;
    }

    public boolean isKey(String key) {
        int hash = hashFun(key);
        int slot = hashFun(key);
        while (!key.equals(slots[slot])) {
            if (slots[slot] == null)
                return false;
            slot = (slot + 1) % size;
            if (slot == hash)
                return false;
        }
        hits[slot] += 1;
        return true;
    }

    private void deleteLessUsed() {
        int min_usage = -1;
        int del_ind = 0;
        for (int i = 0; i < size; i++) {
            if (min_usage == -1 || hits[i] < min_usage) {
                min_usage = hits[i];
                del_ind = i;
            }
        }
        slots[del_ind] = null;
    }

    public void put(String key, T value) {
        if (values_num == size)
            deleteLessUsed();
        int slot = hashFun(key);
        while (slots[slot] != null && !slots[slot].equals(key))
            slot = (slot + 1) % size;
        values_num += 1;
        hits[slot] = 1;
        slots[slot] = key;
        values[slot] = value;
    }

    public T get(String key) {
        int hash = hashFun(key);
        int slot = hashFun(key);
        while (!key.equals(slots[slot])) {
            if (slots[slot] == null)
                return null;
            slot = (slot + 1) % size;
            if (slot == hash)
                return null;
        }
        hits[slot] += 1;
        return values[slot];
    }
}
