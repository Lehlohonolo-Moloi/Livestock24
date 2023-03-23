package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.PurchaseElement;
import com.Goats.livestock48.service.PurchaseElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/purchaseElements")
public class PurchaseElementsController {

    public final PurchaseElementService service;

    @Autowired
    public PurchaseElementsController(PurchaseElementService service) {
        this.service = service;
    }

    @GetMapping("list_purchases")
    public List<PurchaseElement> getAllPurchaseElements(){
        return service.getAllPurchaseElements();
    }

    @GetMapping(path = "{purchaseElementId}")
    public PurchaseElement getPurchaseElementById(@PathVariable("purchaseElementId") Long purchaseElementId){
        return service.getPurchaseElementById(purchaseElementId);
    }

    @PostMapping
    public PurchaseElement addPurchaseElement(@RequestBody PurchaseElement purchaseElement){
        return service.addPurchaseElement(purchaseElement);
    }

    @DeleteMapping(path = "{purchaseElementId}")
    public PurchaseElement deletePurchaseElement(@PathVariable("purchaseElementId") Long purchaseElementId){
        return service.deletePurchaseElement(purchaseElementId);
    }

}
