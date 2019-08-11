package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Purchase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PurchaseRepositoryImpl implements PurchaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Purchase get(long idPerson, long idItem) {
        String query = "SELECT p FROM Purchase p WHERE p.person_id = :person_id and p.item_id = :item_id";
        return (Purchase) entityManager.createQuery(query)
                .setParameter("person_id", idPerson)
                .setParameter("person_id", idItem)
                .getSingleResult();
    }

    @Override
    public List<Purchase> getAll(long idPerson) {
        String query = "SELECT p FROM Purchase p WHERE p.person_id = :person_id";
        return (List<Purchase>) entityManager.createQuery(query)
                .setParameter("person_id", idPerson)
                .getSingleResult();
    }

    @Override
    public void create(Purchase purchase) {
        entityManager.persist(purchase);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Purchase");
    }
}
