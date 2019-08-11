package by.tms.onlinestore.repository;

import by.tms.onlinestore.entity.Purchase;

import java.util.List;

public interface PurchaseRepository {

    Purchase get(long idPerson, long idItem);

    List<Purchase> getAll(long idPerson);

    void create(Purchase purchase);

    void deleteAll();
}
