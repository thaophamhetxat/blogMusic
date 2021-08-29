package service;

import moduls.Person;

import java.util.ArrayList;

public interface IPersonService {
    Person save(Person person);
    ArrayList<Person>findAll();
    void delete(Person person);
    void edit(Person person);
}
