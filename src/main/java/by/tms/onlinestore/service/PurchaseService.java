package by.tms.onlinestore.service;

import by.tms.onlinestore.entity.Purchase;
import by.tms.onlinestore.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase getPurchase(long idPerson, long idItem){
        return purchaseRepository.get(idPerson, idItem);
    }

    public List<Purchase> getAllPurchases(long idPerson) {
        return purchaseRepository.getAll(idPerson);
    }

    public void create(Purchase purchase) {
        purchaseRepository.create(purchase);
    }

    public void deleteAll() {
        purchaseRepository.deleteAll();
    }
}
