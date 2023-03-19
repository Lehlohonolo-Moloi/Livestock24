package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/animals")
public class AnimalController {

    private final AnimalService service;
    @Autowired
    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Animal> getAllAnimals(){
        return service.getAllAnimals();
    }

    @GetMapping(path = "{animalId}")
    public Animal getAnimalById(@PathVariable("animalId") Long animalId){
        return service.getAnimalById(animalId);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        return service.addAnimal(animal);
    }

    @DeleteMapping(path = "{animalId}")
    public Animal deleteAnimal(@PathVariable("animalId") Long animalId){
        return service.deleteAnimal(animalId);
    }

    @PutMapping(path = "{animalId}")
    public Animal updateAnimal(@PathVariable("animalId") Long animalId, @RequestParam(required = true) Double weight){
        return service.updateWeight(animalId, weight);
    }
}
