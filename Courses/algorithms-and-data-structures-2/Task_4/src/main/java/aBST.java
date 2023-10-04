class aBST {
    public Integer[] Tree;

    public aBST(int depth) {
        int tree_size = (int) Math.pow(2, (depth) - 1);
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        int cur_ind = 0;
        while (cur_ind < Tree.length) {
            if (Tree[cur_ind] == null) {
                return -cur_ind;
            }
            if (Tree[cur_ind] == key) {
                return cur_ind;
            }
            if (Tree[cur_ind] > key) {
                cur_ind = 2 * cur_ind + 1;
            } else {
                cur_ind = 2 * cur_ind + 2;
            }
        }
        return null;
    }

    public int AddKey(int key) {
        Integer ind_to_add = FindKeyIndex(key);
        if (ind_to_add == null) {
            return -1;
        }
        Tree[Math.abs(ind_to_add)] = key;
        return ind_to_add;
    }

}