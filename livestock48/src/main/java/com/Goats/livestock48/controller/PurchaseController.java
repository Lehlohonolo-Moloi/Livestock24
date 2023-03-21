package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Purchase;
import com.Goats.livestock48.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/purchases")
public class PurchaseController {

    private final PurchaseService service;
    @Autowired
    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping("list_all_purchases")
    public List<Purchase> getAllPurchases(){
        return service.getAllPurchases();
    }

    @GetMapping(path = "{purchaseId}")
    public Purchase getPurchaseById(@PathVariable("purchaseId") Long purchaseId){
        return service.getPurchaseById(purchaseId);
    }

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase){
        return service.addPurchase(purchase);
    }

    @DeleteMapping(path = "{purchaseId}")
    public Purchase deletePurchase(@PathVariable("purchaseId") Long purchaseId){
        return service.deletePurchase(purchaseId);
    }

    @PutMapping(path = "{purchaseId}")
    public Purchase updateStatus(@PathVariable("purchaseId") Long purchaseId, @RequestParam(required = true) Boolean status){
        return service.updateStatus(purchaseId, status);
    }
}
