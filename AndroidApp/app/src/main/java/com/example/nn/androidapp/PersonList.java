package com.example.nn.androidapp;

import android.text.Editable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by NN on 21.10.2015.
 */
public class PersonList {

    private List<Person> personList;

    public PersonList(){

        personList = new ArrayList<>();
    }

    public void addPerson(Editable name, Editable surname){
        personList.add(0, new Person(name.toString(), surname.toString()));
    }

    public Person getPerson(int index){
        return personList.get(index);
    }

    public int getSize(){
        return personList.size();
    }

    public void removePerson(UUID id){

        Iterator<Person> it = personList.iterator();
        while(it.hasNext()){
            if(it.next().getmId().equals(id)){
                it.remove();
                return;
            }
        }
    }

    public void editPerson(String id, String name, String surname){
        for (int i = 0; i < personList.size(); i++){
            if (personList.get(i).getmId().equals(id)){
                personList.get(i).setmName(name);
                personList.get(i).setmSurname(surname);
                return;
            }
        }
    }


}
