package com.Goats.livestock48.service;

import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.repository.AnimalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    @Autowired
    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<Animal> getAllAnimals(){
        return repository.findAll();
    }

    public Animal getAnimalById(Long id){
        Animal animal = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Animal with id " + id + " does not exist"));
        return animal;
    }

    public Animal addAnimal(Animal animal){
        repository.save(animal);
        return animal;
    }

    public Animal deleteAnimal(Long id){
        Animal animal = getAnimalById(id);
        repository.delete(animal);
        return animal;
    }


    @Transactional
    public Animal updateWeight(Long id, Double weight){
        Animal animal = getAnimalById(id);

        if(weight > 1 && !Objects.equals(animal.getWeightInKg(), weight)){
            animal.setWeightInKg(weight);
        }

        return animal;
    }


}
