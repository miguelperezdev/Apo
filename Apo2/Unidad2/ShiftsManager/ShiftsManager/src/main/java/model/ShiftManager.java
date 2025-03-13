package model;

import structures.PersonList;

public class ShiftManager {

    private PersonList persons;

    public ShiftManager(){
        persons = new PersonList();
    }

    public boolean addPerson(String name, String id){
        return persons.addPerson(new Person(name,id));
    }

    public Person searchPerson(String id){
        return persons.searchPerson(id);
    }
}
