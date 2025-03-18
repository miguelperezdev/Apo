package ui;

import structures.LinkedList;
import structures.Node;

public class Main2 {

    public static void main(String[] args){
        Node head = null;
        LinkedList list = new LinkedList();

        head = list.insertEnd(head, 1);
        head = list.insertEnd(head, 2);
        head = list.insertEnd(head, 3);
        head = list.insertEnd(head, 4);
        head = list.insertEnd(head, 5);

        list.traverse(head);
    }
}
