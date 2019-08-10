package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Person;

public interface PersonRepository {

    Person findPersonById(Long id);

    void savePerson(Person person);

    Person findPerson(Person person);

}
