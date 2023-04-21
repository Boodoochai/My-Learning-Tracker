class SeparateTasks {
    public static LinkedList addTwoLists(LinkedList list1, LinkedList list2) {
        LinkedList res = new LinkedList();
        if (list1.count() != list2.count())
            return res;
        Node list1_node = list1.head;
        Node list2_node = list2.head;
        while (list1_node != null) {
            res.addInTail(new Node(list1_node.value + list2_node.value));
            list1_node = list1_node.next;
            list2_node = list2_node.next;
        }
        return res;
    }
}
