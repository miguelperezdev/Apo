package structures;

import model.Person;

public class PersonNode {
    private Person data;
    private PersonNode prev;
    private PersonNode next;

    public PersonNode(Person data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Person getData() {
        return data;
    }

    public PersonNode getPrev() {
        return prev;
    }

    public PersonNode getNext() {
        return next;
    }

    public void setPrev(PersonNode prev) {
        this.prev = prev;
    }

    public void setNext(PersonNode next) {
        this.next = next;
    }


}
