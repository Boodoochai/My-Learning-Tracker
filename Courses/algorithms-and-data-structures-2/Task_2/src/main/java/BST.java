class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        if (Root == null) {
            return null;
        }
        return Root.FindNodeByKey(key);
    }

    public boolean AddKeyValue(int key, T val) {
        if (Root == null) {
            Root = new BSTNode<>(key, val, null);
        }
        BSTFind<T> node_find = FindNodeByKey(key);
        if (node_find.NodeHasKey) {
            return false;
        }
        BSTNode<T> node_to_add = new BSTNode<>(key, val, node_find.Node);
        if (node_find.ToLeft) {
            node_find.Node.LeftChild = node_to_add;
        } else {
            node_find.Node.RightChild = node_to_add;
        }
        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FromNode == null) {
            return null;
        }
        if (FindMax) {
            return FromNode.FindMax();
        }
        return FromNode.FindMin();
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> f = FindNodeByKey(key);
        if (!f.NodeHasKey) {
            return false;
        }
        return true;
    }

    public int Count() {
        if (Root == null) {
            return 0;
        }
        return Root.Count();
    }

}