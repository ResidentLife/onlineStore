package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Person findPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person findPerson(Person person) {
        String query = "SELECT p FROM Person p WHERE p.login = :login and p.password = :password";
        return (Person) entityManager.createQuery(query)
                .setParameter("login", person.getLogin())
                .setParameter("password", person.getPassword())
                .getSingleResult();
    }

    @Override
    public Person isLoginExist(String login) {
        return entityManager.find(Person.class, login);
    }
}

