import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value != _value) {
                node = node.next;
                continue;
            }
            if (node == this.head && node == this.tail) {
                this.head = null;
                this.tail = null;
            } else if (node == this.head) {
                this.head = node.next;
                this.head.prev = null;
            } else if (node == this.tail) {
                this.tail = node.prev;
                this.tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value != _value) {
                node = node.next;
                continue;
            }
            if (node == this.head && node == this.tail) {
                this.head = null;
                this.tail = null;
                return;
            } else if (node == this.head) {
                this.head = node.next;
                this.head.prev = null;
                node = this.head;
            } else if (node == this.tail) {
                this.tail = node.prev;
                this.tail.next = null;
                return;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node = node.next;
            }
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int size = 0;
        Node node = this.head;
        while (node != null) {
            size += 1;
            node = node.next;
        }
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null && this.tail == null) {
            _nodeToInsert.next = null;
            _nodeToInsert.prev = null;
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        } else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            _nodeToInsert.prev = null;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
        } else if (this.tail == _nodeAfter) {
            this.tail.next = _nodeToInsert;
            _nodeToInsert.prev = this.tail;
            _nodeToInsert.next = null;
            this.tail = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
