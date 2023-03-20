package com.Goats.livestock48.service;

import com.Goats.livestock48.model.AnimalType;
import com.Goats.livestock48.repository.AnimalTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnimalTypeService {

    private final AnimalTypeRepository repository;

    @Autowired
    public AnimalTypeService(AnimalTypeRepository repository) {
        this.repository = repository;
    }

    public List<AnimalType> getAllAnimalTypes(){
        return repository.findAll();
    }

    public AnimalType getAnimalTypeById(Long id){
        AnimalType type = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("AnimalType with id " + id + " does not exist"));
        return type;
    }

    public AnimalType addAnimalType(AnimalType type){
        repository.save(type);
        return type;
    }

    public AnimalType deleteAnimalType(Long id){
        AnimalType type = getAnimalTypeById(id);
        repository.delete(type);
        return type;
    }

    @Transactional
    public AnimalType updateAnimalType(Long id, String breed){
        AnimalType type = getAnimalTypeById(id);

        if(breed != null
                && breed.length() > 0
                && !Objects.equals(type.getAnimalBreed(), breed)){
            type.setAnimalBreed(breed);
        }

        return type;
    }
}
