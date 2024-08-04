package de.kathibrati.dishdoodles.ingredient.service;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll()
                .stream()
                .map(IngredientDto::new)
                .toList();
    }

    public Optional<IngredientDto> findById(Long id) {
        return ingredientRepository
                .findById(id)
                .map(IngredientDto::from);
    }

    public IngredientDto save(IngredientCreateOrUpdateResource resource) {
        Ingredient entity = resource.convertToIngredient();
        return IngredientDto.from(ingredientRepository.save(entity));
    }

    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void updateIngredient(IngredientCreateOrUpdateResource resource, Long id) {
        Ingredient entityToUpdate = ingredientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Entity for id:" + id + " not found!"));

        updateEntity(resource, id, entityToUpdate);
        ingredientRepository.save(entityToUpdate);
    }

    private void updateEntity(IngredientCreateOrUpdateResource resource, Long id, Ingredient entity) {
        entity.setName(resource.name());
        entity.setId(id);
    }

}
