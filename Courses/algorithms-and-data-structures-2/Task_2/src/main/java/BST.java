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
            return true;
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
        if (f == null || !f.NodeHasKey) {
            return false;
        }
        BSTNode<T> nodeToDelete = f.Node;
        if (f.Node == Root) {
            DeleteRoot();
            return true;
        }
        if (nodeToDelete.RightChild == null && nodeToDelete.LeftChild == null) {
            if (nodeToDelete.Parent.LeftChild == nodeToDelete) {
                nodeToDelete.Parent.LeftChild = null;
            } else {
                nodeToDelete.Parent.RightChild = null;
            }
            return true;
        }
        if (nodeToDelete.LeftChild == null) {
            if (nodeToDelete.Parent.LeftChild == nodeToDelete) {
                nodeToDelete.Parent.LeftChild = nodeToDelete.RightChild;
                nodeToDelete.RightChild.Parent = nodeToDelete.Parent;
            } else {
                nodeToDelete.Parent.RightChild = nodeToDelete.RightChild;
                nodeToDelete.RightChild.Parent = nodeToDelete.Parent;
            }
            return true;
        }
        if (nodeToDelete.RightChild == null) {
            if (nodeToDelete.Parent.LeftChild == nodeToDelete) {
                nodeToDelete.Parent.LeftChild = nodeToDelete.LeftChild;
                nodeToDelete.LeftChild.Parent = nodeToDelete.Parent;
            } else {
                nodeToDelete.Parent.RightChild = nodeToDelete.LeftChild;
                nodeToDelete.LeftChild.Parent = nodeToDelete.Parent;
            }
            return true;
        }
        DeleteTwoChildsNode(f.Node);
        return true;
    }

    private void DeleteRoot() {
        if (Count() == 1) {
            Root = null;
            return;
        }
        if (Root.LeftChild == null) {
            Root = Root.RightChild;
            Root.Parent = null;
            return;
        }
        if (Root.RightChild == null) {
            Root = Root.LeftChild;
            Root.Parent = null;
            return;
        }
        BSTNode<T> replacement = FindReplacementForDeletable(Root);
        replacement.RightChild = Root.RightChild;
        replacement.LeftChild = Root.LeftChild;
        replacement.Parent = null;
    }

    private void DeleteTwoChildsNode(BSTNode<T> nodeToDelete) {
        BSTNode<T> replacement = FindReplacementForDeletable(Root);
        replacement.LeftChild = nodeToDelete.LeftChild;
        replacement.Parent = nodeToDelete.Parent;
        replacement.RightChild = nodeToDelete.RightChild;
    }

    public BSTNode<T> FindReplacementForDeletable(BSTNode<T> node) {
        BSTNode<T> curNode = node.RightChild;
        while (curNode.LeftChild != null) {
            curNode = curNode.LeftChild;
        }
        if (curNode.RightChild == null) {
            return curNode;
        }
        if (curNode.Parent.LeftChild == curNode) {
            curNode.Parent.LeftChild = curNode.RightChild;
            curNode.RightChild.Parent = curNode.Parent;
        }
        if (curNode.Parent.RightChild == curNode) {
            curNode.Parent.RightChild = curNode.RightChild;
            curNode.RightChild.Parent = curNode.Parent;
        }
        return curNode;
    }

    public int Count() {
        if (Root == null) {
            return 0;
        }
        return Root.Count();
    }

}