package structures;

import model.Person;

public class PersonList {
    private PersonNode first;
    private PersonNode last;

    public PersonList() {
        this.first = null;
        this.last = null;
    }

    public boolean addPerson(Person person){
        boolean added = false;
        PersonNode node = new PersonNode(person);
        //caso base
        if(first==null && last==null){
            first = node;
            last = node;
            added = true;
        }
        //caso generalizado
        else{
            PersonNode temp = last;
            last = node;

            last.setPrev(temp);
            temp.setNext(last);

            added = true;
        }
        return added;
    }

    public Person searchPerson(String id){
        //Caso base 1
        if(first.getData().getId().equals(id)){
            return first.getData();
        }
        //Caso base 2
        else if(last.getData().getId().equals(id)){
            return last.getData();
        }
        //Caso iterativo
        else{
            PersonNode current = first;
            while(current!=null){
                if(current.getData().getId().equals(id)){
                    return current.getData();
                }
                current = current.getNext();
            }
        }
        return null;
    }

    public boolean removePerson(Person person){
        return false;
    }

    public void selectionSortById(){

    }
}
