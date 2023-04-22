import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        Node prev_node = null;
        while (node != null){
            if (node.value == _value){
                if (this.head == node && this.tail == node){
                    this.head = null;
                    this.tail = null;
                } else if (this.head == node){
                    this.head = node.next;
                } else if (this.tail == node){
                    this.tail = prev_node;
                    prev_node.next = null;
                } else {
                    prev_node.next = node.next;
                }
                return true;
            }
            prev_node = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node prev_node = null;
        while (node != null){
            if (node.value == _value){
                if (this.head == node && this.tail == node){
                    this.head = null;
                    this.tail = null;
                } else if (this.head == node){
                    this.head = node.next;
                } else if (this.tail == node){
                    this.tail = prev_node;
                    prev_node.next = null;
                } else {
                    prev_node.next = node.next;
                }
            } else {
                prev_node = node;
            }
            node = node.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int elements_count = 0;
        Node node = this.head;
        while (node != null){
            elements_count += 1;
            node = node.next;
        }
        return elements_count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        } else {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
