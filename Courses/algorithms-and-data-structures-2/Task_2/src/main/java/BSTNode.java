class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    public int Count() {
        int ans = 1;
        if (LeftChild != null) {
            ans += LeftChild.Count();
        }
        if (RightChild != null) {
            ans += RightChild.Count();
        }
        return ans;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        if (key > NodeKey) {
            return this.FindNodeByKeyHandleRight(key);
        }
        if (key < NodeKey) {
            return this.FindNodeByKeyHandleLeft(key);
        }
        BSTFind<T> res = new BSTFind<>();
        res.Node = this;
        res.NodeHasKey = true;
        return res;
    }

    private BSTFind<T> FindNodeByKeyHandleLeft(int key) {
        if (LeftChild == null) {
            BSTFind<T> res = new BSTFind<>();
            res.Node = this;
            res.NodeHasKey = false;
            res.ToLeft = true;
            return res;
        }
        return LeftChild.FindNodeByKey(key);
    }

    private BSTFind<T> FindNodeByKeyHandleRight(int key) {
        if (RightChild == null) {
            BSTFind<T> res = new BSTFind<>();
            res.Node = this;
            res.NodeHasKey = false;
            res.ToLeft = false;
            return res;
        }
        return RightChild.FindNodeByKey(key);
    }

    public BSTNode<T> FindMax() {
        if (RightChild == null) {
            return this;
        }
        return RightChild.FindMax();
    }

    public BSTNode<T> FindMin() {
        if (LeftChild == null) {
            return this;
        }
        return LeftChild.FindMin();
    }
}