import java.util.Arrays;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        if (a.length == 0) {
            return;
        }
        Arrays.sort(a);
        BSTNode root = new BSTNode(a[a.length / 2], null);
        root.Level = 0;
        GenerateTreeRec(a, 0, a.length / 2, true, root);
        GenerateTreeRec(a, a.length / 2 + 1, a.length, false, root);
        Root = root;
    }

    private static void GenerateTreeRec(int[] a, int l, int r, boolean isLeftChild, BSTNode parent) {
        if (l == r) {
            return;
        }

        int m = (l + r) / 2;
        BSTNode node = new BSTNode(a[m], parent);
        node.Level = parent.Level + 1;

        if (isLeftChild) {
            parent.LeftChild = node;
        } else {
            parent.RightChild = node;
        }

        GenerateTreeRec(a, l, m, true, node);
        GenerateTreeRec(a, m + 1, r, false, node);
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node.LeftChild == null) {
            return root_node.RightChild == null || (root_node.RightChild.RightChild == null && root_node.RightChild.LeftChild == null);
        }

        if (root_node.RightChild == null) {
            return root_node.LeftChild.RightChild == null && root_node.LeftChild.LeftChild == null;
        }

        return this.IsBalanced(root_node.LeftChild) && this.IsBalanced(root_node.RightChild);
    }
}
