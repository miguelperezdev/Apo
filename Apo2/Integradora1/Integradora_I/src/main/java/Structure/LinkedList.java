package Structure;
import Exceptions.EmptyListException;
import model.Driver;
import model.Route;
import java.util.Comparator;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public boolean remove(T data) {
        if (first == null) return false;
        if (first.data.equals(data)) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            size--;
            return true;
        }
        Node<T> current = first;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        if (current == null) return false;
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev;
        }
        size--;
        return true;
    }

    public String showAll() {
        if (first == null) {
            return "There aren't any elements in the list";
        }

        StringBuilder result = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            result.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return result.toString();
    }

    public void sort(Comparator<T> comparator) {
        if (first == null || first.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = first;
            Node<T> prev = null;
            while (current.next != null) {
                if (comparator.compare(current.data, current.next.data) > 0) {
                    Node<T> nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    nextNode.prev = current.prev;
                    current.prev = nextNode;

                    if (prev == null) {
                        first = nextNode;
                    } else {
                        prev.next = nextNode;
                    }
                    if (current.next != null) {
                        current.next.prev = current;
                    } else {
                        last = current;
                    }
                    prev = nextNode;
                    swapped = true;

                } else {
                    prev = current;
                    current = current.next;
                }

            }

        } while (swapped);

    }

    public boolean isEmpty() {
        return first == null;
    }

    public T searchById(String id) {
        Node<T> current = first;
        while (current != null) {
            if (current.data != null && current.data.toString().contains(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public T findTheBestRouteForTime(Comparator<T> comparator) throws EmptyListException {
        if (first == null) {
            throw new EmptyListException("the list is empty");
        }

        Node<T> current = first;
        T bestElement = current.data;

        while (current != null) {
            if (comparator.compare(current.data, bestElement) < 0) {
                bestElement = current.data;
            }
            current = current.next;
        }

        return bestElement;
    }


    public T searchByName(String name){
        Node<T> current = first;
        while(current != null){
            if(current.data instanceof Driver){
                Driver driver= (Driver) current.data;
                if(driver.getNameDriver().equalsIgnoreCase(name)){
                    return current.data;
                }

            }
            current = current.next;
        }
        return null;
    }
    public T get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node<T> current = first;
        for(int i = 0; i< index; i++){
            current = current.next;
        }
        return current.data;
    }



}

