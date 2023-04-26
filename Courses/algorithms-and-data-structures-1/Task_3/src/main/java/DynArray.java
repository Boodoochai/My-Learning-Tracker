public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T[] new_array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        for (int i = 0; i < this.count; i++) {
            new_array[i] = this.array[i];
        }
        this.array = new_array;
        this.capacity = new_capacity;
    }

    public T getItem(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(capacity*2);
        }
        array[count] = itm;
        count += 1;
    }

    public void insert(T itm, int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        if (count == capacity) {
            makeArray(capacity*2);
        }

        for (int i = count-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = itm;

        count += 1;
    }

    public void remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < count-1; i++) {
            this.array[i] = this.array[i+1];
        }

        this.count -= 1;

        this.array[count] = null;

        if (count < capacity / 2.f && capacity > 16) {
            int new_capacity = (int)(capacity/1.5);
            if (new_capacity < 16)
                new_capacity = 16;
            makeArray(new_capacity);
        }
    }
}
