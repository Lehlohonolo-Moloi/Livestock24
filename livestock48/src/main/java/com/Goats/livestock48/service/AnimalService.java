package com.Goats.livestock48.service;

import com.Goats.livestock48.Livestock48Application;
import com.Goats.livestock48.exception.CustomException;
import com.Goats.livestock48.model.Animal;
import com.Goats.livestock48.repository.AnimalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<Animal> getAvailableAnimals(){
        Long cust_id = 0L;
        if(Livestock48Application.getSelf() != null) cust_id = Livestock48Application.getSelf().getCustomerId();

        Long final_id = cust_id;
        return repository.findAll().stream().filter(animal -> !animal.getCustomer().getCustomerId().equals(final_id)).collect(Collectors.toList());
    }

    public Animal getAnimalById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CustomException("Animal with id " + id + " does not exist"));
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

    public List<Animal> getAnimalsByName(String name){
        return getAllAnimals().stream()
                .filter(animal -> animal.getAnimalType().getAnimalName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


}
