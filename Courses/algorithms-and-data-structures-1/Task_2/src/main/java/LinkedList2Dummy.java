import java.util.*;

public class LinkedList2Dummy {
    public Node head;
    public Node tail;

    public LinkedList2Dummy() {
        head = new Node(1);
        tail = new Node(1);
        head.next = tail;
        tail.prev = head;
    }

    public void addInTail(Node _item) {
        _item.prev = this.tail.prev;
        _item.next = this.tail;
        this.tail.prev.next = _item;
        this.tail.prev = _item;
    }

    public Node find(int _value) {
        Node node = this.head.next;
        while (node.next != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head.next;
        while (node.next != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head.next;
        while (node.next != null) {
            if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head.next;
        while (node.next != null) {
            if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node = node.next;
        }
    }

    public void clear() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int count() {
        int size = 0;
        Node node = this.head.next;
        while (node.next != null) {
            size += 1;
            node = node.next;
        }
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head.next;
            _nodeToInsert.prev = this.head;
            this.head.next.prev = _nodeToInsert;
            this.head.next = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
