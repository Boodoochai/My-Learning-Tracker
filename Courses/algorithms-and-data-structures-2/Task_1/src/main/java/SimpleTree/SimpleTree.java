package SimpleTree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        NewChild.Parent = ParentNode;
        ParentNode.Children.add(NewChild);
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        if (NodeToDelete == Root){
            Root = null;
            return;
        }
        NodeToDelete.Parent.Children.remove(NodeToDelete);
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> nodesList = new ArrayList<>();
        if (Root == null) {
            return nodesList;
        }
        Root.GetAllNodes(nodesList);
        return nodesList;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> rightNodesList = new ArrayList<>();
        if (Root == null) {
            return rightNodesList;
        }
        Root.FindNodesByValue(val, rightNodesList);
        return rightNodesList;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        this.DeleteNode(OriginalNode);
        this.AddChild(NewParent, OriginalNode);
    }

    public int Count() {
        if (Root == null) {
            return 0;
        }
        return Root.Count();
    }

    public int LeafCount() {
        if (Root == null) {
            return 0;
        }
        return Root.LeafCount();
    }
}