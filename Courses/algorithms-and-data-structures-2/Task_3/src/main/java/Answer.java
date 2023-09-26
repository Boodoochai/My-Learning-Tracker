import java.util.ArrayList;

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

class BSTFind<T> {
    public BSTNode<T> Node;

    public boolean NodeHasKey;

    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    // BFS
    public ArrayList<BSTNode> WideAllNodes() {
        // TODO
        return null;
    }

    /*  DFS
    *   orderType == 0 -> in-order
    *   orderType == 1 -> post-order
    *   orderType == 2 -> pre-order
    */
    public ArrayList<BSTNode> DeepAllNodes(int orderType) {
        // TODO
        return null;
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
            } else {
                nodeToDelete.Parent.RightChild = nodeToDelete.RightChild;
            }
            nodeToDelete.RightChild.Parent = nodeToDelete.Parent;
            return true;
        }
        if (nodeToDelete.RightChild == null) {
            if (nodeToDelete.Parent.LeftChild == nodeToDelete) {
                nodeToDelete.Parent.LeftChild = nodeToDelete.LeftChild;
            } else {
                nodeToDelete.Parent.RightChild = nodeToDelete.LeftChild;
            }
            nodeToDelete.LeftChild.Parent = nodeToDelete.Parent;
            return true;
        }
        DeleteTwoChildNode(f.Node);
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
        replacement.LeftChild.Parent = replacement;
        replacement.RightChild.Parent = replacement;
        Root = replacement;
    }

    private void DeleteTwoChildNode(BSTNode<T> nodeToDelete) {
        BSTNode<T> replacement = FindReplacementForDeletable(nodeToDelete);
        replacement.LeftChild = nodeToDelete.LeftChild;
        replacement.Parent = nodeToDelete.Parent;
        replacement.RightChild = nodeToDelete.RightChild;
        if (nodeToDelete.Parent.RightChild == nodeToDelete) {
            nodeToDelete.Parent.RightChild = replacement;
        } else {
            nodeToDelete.Parent.LeftChild = replacement;
        }
        nodeToDelete.LeftChild.Parent = replacement;
        nodeToDelete.RightChild.Parent = replacement;
    }

    public BSTNode<T> FindReplacementForDeletable(BSTNode<T> node) {
        BSTNode<T> curNode = node.RightChild;
        while (curNode.LeftChild != null) {
            curNode = curNode.LeftChild;
        }
        if (curNode.RightChild == null) {
            if (curNode.Parent.LeftChild == curNode) {
                curNode.Parent.LeftChild = null;
            }
            if (curNode.Parent.RightChild == curNode) {
                curNode.Parent.RightChild = null;
            }
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