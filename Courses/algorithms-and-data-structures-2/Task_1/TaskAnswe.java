public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<SimpleTreeNode<T>>();
    }

    public void GetAllNodes(List<SimpleTreeNode<T>> nodesList) {
        nodesList.add(this);
        for (SimpleTreeNode<T> child : Children) {
            child.GetAllNodes(nodesList);
        }
    }

    public void FindNodesByValue(T val, List<SimpleTreeNode<T>> rightNodesList) {
        if (NodeValue == val) {
            rightNodesList.add(this);
        }
        for (SimpleTreeNode<T> child : Children) {
            child.FindNodesByValue(val, rightNodesList);
        }
    }

    public int Count() {
        int count = 1;
        for (SimpleTreeNode<T> child : Children) {
            count += child.Count();
        }
        return count;
    }

    public int LeafCount() {
        int count = 0;
        if (Children.size() == 0) {
            count = 1;
        }
        for (SimpleTreeNode<T> child : Children) {
            count += child.LeafCount();
        }
        return count;
    }
}

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