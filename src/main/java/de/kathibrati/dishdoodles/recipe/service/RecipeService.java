package de.kathibrati.dishdoodles.recipe.service;

import de.kathibrati.dishdoodles.recipe.model.RecipeDto;
import de.kathibrati.dishdoodles.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDto> findAll() {
        return recipeRepository.findAll().stream().map(RecipeDto::new).toList();
    }
}
