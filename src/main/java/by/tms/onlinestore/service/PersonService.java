package by.tms.onlinestore.service;

import by.tms.onlinestore.entity.Person;
import by.tms.onlinestore.entity.Role;
import by.tms.onlinestore.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPersonByID (Long id){
        return personRepository.findPersonById(id);
    }

    public void savePerson(Person person) {
        if (person.getRole() == null) {
            person.setRole(Role.user);
        }
        Person p = new Person(person.getLogin(), person.getPassword());
        personRepository.savePerson(p);
    }

    public Person FindPerson (Person person) {
        return personRepository.findPerson(person);
    }

    public boolean isLoginExist (String login) {
        if (personRepository.isLoginExist(login) != null) {
            return true;
        }
        return false;
    }
}
