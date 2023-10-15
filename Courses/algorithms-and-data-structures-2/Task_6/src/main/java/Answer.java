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

    }

    private static void GenerateTreeRec(int[] a, int l, int r, BSTNode parent) {
        if (l == r) {
            return;
        }
        int m = (l+r) / 2;
        BSTNode node = new BSTNode(a[m], null);
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node.LeftChild == null) {
            if ((root_node.RightChild == null || (root_node.RightChild.RightChild == null && root_node.RightChild.LeftChild == null))) {
                return true;
            } else {
                return false;
            }
        }
        if (root_node.RightChild == null) {
            if (root_node.LeftChild.RightChild == null && root_node.LeftChild.LeftChild == null) {
                return true;
            } else {
                return false;
            }
        }

        if (this.IsBalanced(root_node.LeftChild) && this.IsBalanced(root_node.RightChild)) {
            return true;
        }
        return false;
    }
}