package repository;

import moduls.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepo extends CrudRepository<Person,Integer> {
}
