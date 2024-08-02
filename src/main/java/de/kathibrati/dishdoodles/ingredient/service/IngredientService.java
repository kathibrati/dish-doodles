package de.kathibrati.dishdoodles.ingredient.service;

import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public IngredientDto findById(Long id) {
        return IngredientDto.from(ingredientRepository.findById(id).orElseThrow());
    }
}
