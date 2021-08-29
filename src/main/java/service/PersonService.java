package service;

import moduls.Person;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IPersonRepo;

import java.util.ArrayList;

public class PersonService implements IPersonService {
    @Autowired
    IPersonRepo iPersonRepo;

    @Override
    public Person save(Person person) {
        return iPersonRepo.save(person);
    }

    @Override
    public ArrayList<Person> findAll() {
        return (ArrayList<Person>) iPersonRepo.findAll();
    }

    @Override
    public void delete(Person person) {
        iPersonRepo.delete(person);
    }

    @Override
    public void edit(Person person) {
        iPersonRepo.save(person);
    }
}
