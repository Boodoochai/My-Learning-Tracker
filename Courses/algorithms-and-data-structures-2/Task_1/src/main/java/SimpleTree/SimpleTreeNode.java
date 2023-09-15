package SimpleTree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<>();
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
