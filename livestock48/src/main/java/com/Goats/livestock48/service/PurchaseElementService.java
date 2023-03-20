package com.Goats.livestock48.service;

import com.Goats.livestock48.model.PurchaseElement;
import com.Goats.livestock48.repository.PurchaseElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseElementService {

    private final PurchaseElementRepository repository;
    @Autowired
    public PurchaseElementService(PurchaseElementRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseElement> getAllPurchaseElements(){
        return repository.findAll();
    }

    public PurchaseElement getPurchaseElementById(Long id){
        PurchaseElement element = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("PurchaseElement with id" + id + " does not exist."));
        return element;
    }

    public PurchaseElement deletePurchaseElement(Long id){
        PurchaseElement element = getPurchaseElementById(id);
        repository.delete(element);
        return element;
    }

    public PurchaseElement addPurchaseElement(PurchaseElement orderElement) {
        repository.save(orderElement);
        return orderElement;
    }
}
