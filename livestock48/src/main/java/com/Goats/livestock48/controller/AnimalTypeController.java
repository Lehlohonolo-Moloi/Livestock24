package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.AnimalType;
import com.Goats.livestock48.service.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/animalTypes")
public class AnimalTypeController {

    private final AnimalTypeService service;
    @Autowired
    public AnimalTypeController(AnimalTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<AnimalType> getAllAnimals(){
        return service.getAllAnimalTypes();
    }

    @GetMapping(path = "{animalTypeId}")
    public AnimalType getAnimalTypeById(@PathVariable("animalTypeId") Long animalTypeId){
        return service.getAnimalTypeById(animalTypeId);
    }

    @PostMapping(path = "add")
    public AnimalType addAnimalType(@RequestBody AnimalType animalType){
        return service.addAnimalType(animalType);
    }

    @DeleteMapping(path = "{animalTypeId}")
    public AnimalType deleteAnimalType(@PathVariable("animalTypeId") Long animalTypeId){
        return service.deleteAnimalType(animalTypeId);
    }

    @PutMapping(path = "{animalTypeId}")
    public AnimalType updateAnimalType(@PathVariable("animalTypeId") Long animalTypeId, @RequestParam(required = true) String breed){
        return service.updateAnimalType(animalTypeId, breed);
    }

}
