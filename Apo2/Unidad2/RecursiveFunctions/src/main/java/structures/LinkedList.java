package structures;

public class LinkedList {
    // Function to insert a new node at the
    // end of linked list using recursion.
    public Node insertEnd(Node head, int data) {

        // If linked list is empty, create a new node
        if (head == null)
            return new Node(data);

        // If we have not reached the end
        // keep traversing recursively
        head.next = insertEnd(head.next, data);
        return head;
    }

    // Function to traverse and print the linked list
    // starting from the head node, recursively
    public void traverse(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        // Recur for the remaining list
        traverse(head.next);
    }
}
