import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof Comparable) {
            Comparable n1 = (Comparable)v1;
            Comparable n2 = (Comparable)v2;
            if (n1.compareTo(n2) < 0)
                return -1;
            if (n1.compareTo(n2) > 0)
                return 1;
        }
        return 0;
    }

    private boolean isFirstLeft(Node<T> first, Node<T> second) {
        int comp = compare(first.value, second.value);
        return (comp == 1 && !_ascending) || (comp == -1 && _ascending) || comp == 0;
    }

    public void add(T value) {
        Node<T> new_node = new Node<T>(value);
        if (head == null) {
            head = new_node;
            tail = new_node;
            return;
        }
        if (isFirstLeft(new_node, head)) {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            return;
        }
        if (isFirstLeft(tail, new_node)) {
            new_node.prev = tail;
            tail.next = new_node;
            tail = new_node;
            return;
        }
        Node<T> node = head;
        while (!isFirstLeft(new_node, node)) {
            node = node.next;
        }
        new_node.next = node;
        new_node.prev = node.prev;
        node.prev.next = new_node;
        node.prev = new_node;
    }

    public Node<T> find(T val) {
        Node<T> node = head;
        while (node != null) {
            if (node.value == val)
                return node;
            if ((compare(node.value, val) == 1 && _ascending) ||
                (compare(node.value, val) == -1 && !_ascending))
                return null;
            node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        Node<T> node = head;
        while (node != null) {
            if (node.value == val) {
                if (head == node && tail == node) {
                    head = null;
                    tail = null;
                } else if (head == node) {
                    head.next.prev = null;
                    head = head.next;
                } else if (tail == node) {
                    tail.prev.next = null;
                    tail = tail.prev;
                } else {
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                }
                return;
            }
            if ((compare(node.value, val) == 1 && _ascending) ||
                (compare(node.value, val) == -1 && !_ascending))
                return;
            node = node.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count() {
        Node<T> node = head;
        int c = 0;
        while (node != null) {
            c += 1;
            node = node.next;
        }
        return c;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
