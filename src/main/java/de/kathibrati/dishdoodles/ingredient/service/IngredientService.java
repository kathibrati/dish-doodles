package de.kathibrati.dishdoodles.ingredient.service;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .map(IngredientDto::from)
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
}
