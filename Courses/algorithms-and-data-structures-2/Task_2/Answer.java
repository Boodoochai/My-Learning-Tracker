import java.io.*;
import java.util.*;

class BSTNode<T>
{
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    public int Count()
    {
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

class BSTFind<T>
{
    public BSTNode<T> Node;

    public boolean NodeHasKey;

    public boolean ToLeft;

    public BSTFind() { Node = null; }
}


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