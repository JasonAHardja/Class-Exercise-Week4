public class ListNode {
    private static class Node<E> {
        /**Data Fields
         */
        private E data;
        private Node<E> next;

        /** Constructors */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    public static class KWSingleLinkedList<E> {
        private Node<E> head = null;
        private int size = 0;

        /** Add an item to the front of the list */
        public void addFirst(E item) {
            head = new Node<>(item, head);
            size++;
        }
        /** Inserting a node in a list */
        public void insertAfterNode(Node<E> node, E dataToInsert) {
            if (node != null) {
                Node<E> newNode = new Node<>(dataToInsert);
                newNode.next = node.next;
                node.next = newNode;
                size++;
            } else {
                System.out.println("node is null");
            }
        }

        /** Add a node after a givven node
            @param node The node preceding the new item
            @param item The item to insert
         */
        private void addAfter(Node<E> node, E item) {
            node.next = new Node<>(item, node.next);
            size++;

        }
        /** Remove th node after a given node
            @param node The node before the one to be removed
            @return the Data from the removed node, or null if there is no node to remove
         */
        private E removeAfter(Node<E> node) {
            Node<E> temp = node.next;
            if (temp != null) {
                node.next = temp.next;
                size--;
                return temp.data;
            } else {
                return null;
            }
        }

        /** Remove the first node from the list
            @return The removed node's data or null if the list is empty
         */
        private E removeFirst() {
            Node<E> temp = head;
            if (head != null) {
                head = head.next;
            }
            //Return data at old head or null if the list is empty
            if (temp != null) {
                size--;
                return temp.data;
            } else {
                return null;
            }
        }
        /** Get size of the list */
        public int size() {
            return size;
        }

        /** Method to print the list */
        public void printList() {
            Node<E> current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        KWSingleLinkedList<String> names = new KWSingleLinkedList<>();
        names.addFirst("Sam");
        names.addFirst("Harry");
        names.addFirst("Dick");
        names.addFirst("Tom");

        Node<String> harry = names.head.next;

        names.insertAfterNode(harry, "Bob");

        names.printList();
    }
}


