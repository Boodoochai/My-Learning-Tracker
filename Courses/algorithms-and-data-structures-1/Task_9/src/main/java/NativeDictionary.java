import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int sum = 0;
        for (char c: key.toCharArray())
            sum = (sum + c) % size;
        return sum;
    }

    public boolean isKey(String key) {
        int hash = hashFun(key);
        int slot = hash;
        while (!key.equals(slots[slot])) {
            slot = (slot + 1) % size;
            if (slots[slot] == null || slot == hash) 
                return false;
        }
        return true;
    }

    public void put(String key, T value) {
        int hash = hashFun(key);
        int slot = hash;
        while (slots[slot] != null && !key.equals(slots[slot])) {
            slot = (slot + 1) % size;
            if (slot == hash)
                return;
        }
        slots[slot] = key;
        values[slot] = value;
    }

    public T get(String key) {
        int hash = hashFun(key);
        int slot = hash;
        while (!key.equals(slots[slot])) {
            slot = (slot + 1) % size;
            if (slots[slot] == null || slot == hash)
                return null;
        }
        return values[slot];
    }
}
