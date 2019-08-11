package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ItemReposytoryImpl implements ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item get(long id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public List<Item> getAll() {
        return (List<Item>) entityManager.createQuery("FROM Item").getResultList();
    }

    @Override
    public void create(Item item) {
        entityManager.persist(item);
    }

    @Override
    public void update(Item item) {
        entityManager.merge(item);
    }

    @Override
    public void delete(Item item) {
        entityManager.remove(item);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Item");
    }
}
