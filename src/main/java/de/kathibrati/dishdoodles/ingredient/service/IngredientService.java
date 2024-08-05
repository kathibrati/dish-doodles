package de.kathibrati.dishdoodles.ingredient.service;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .map(IngredientDto::new);
    }

    public IngredientDto save(IngredientCreateOrUpdateResource resource) {
        Ingredient entity = resource.convertToIngredient();
        IngredientDto dto = new IngredientDto(ingredientRepository.save(entity));
        return dto;
    }

    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void updateIngredient(IngredientCreateOrUpdateResource resource, Long id) {
        Ingredient entityToUpdate = ingredientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity for id:" + id + " not found!"));

        updateEntity(resource, id, entityToUpdate);
        ingredientRepository.save(entityToUpdate);
    }

    private void updateEntity(IngredientCreateOrUpdateResource resource, Long id, Ingredient entity) {
        entity.setName(resource.name());
        entity.setId(id);
    }

    public List<IngredientDto> searchByName(String searchName) {
        return ingredientRepository.findByNameContainsIgnoreCase(searchName).stream().map(IngredientDto::new).toList();
    }
}
