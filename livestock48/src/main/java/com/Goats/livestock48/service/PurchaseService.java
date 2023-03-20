package com.Goats.livestock48.service;

import com.Goats.livestock48.model.Purchase;
import com.Goats.livestock48.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository repository;
    @Autowired
    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public List<Purchase> getAllPurchases(){
        return repository.findAll();
    }

    public Purchase getPurchaseById(Long id){
        Purchase purchase = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Purchase with id " + id + " does not exist."));
        return purchase;
    }

    public Purchase addPurchase(Purchase purchase){
        repository.save(purchase);
        return purchase;
    }

    public Purchase deletePurchase(Long id){
        Purchase purchase = getPurchaseById(id);
        repository.delete(purchase);
        return purchase;
    }

    @Transactional
    public Purchase updateStatus(Long id, Boolean status){
        Purchase purchase = getPurchaseById(id);
        purchase.setStatus(status);
        return purchase;
    }
}
