package com.Goats.livestock48.controller;

import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/animals")
public class AnimalController {

    private final AnimalService service;
    @Autowired
    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping("list_animals")
    public List<Animal> getAllAnimals(){
        return service.getAllAnimals();
    }

    @GetMapping("get_first_animal")
    public String getFirstAnimal(){
        List<Animal> animals = getAllAnimals();
        if (animals.size() > 0){
            return animals.get(0).toString();
        }
        else return "No Animals found";
    }

    @GetMapping()
    public Animal getAnimalById(@RequestParam("animalId") Long animalId){
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
