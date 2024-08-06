package de.kathibrati.dishdoodles.recipe.model;

import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;

import java.util.List;

import static de.kathibrati.dishdoodles.recipe.service.RecipeService.calculateTotalRecipeKcals;

public record RecipeDto(
        Long id,
        String name,
        List<IngredientDto> ingredientDtos,
        Integer totalKcals
) {
    public RecipeDto(Recipe recipe) {
        this(
                recipe.getId(),
                recipe.getRecipeName(),
                recipe.getIngredientList().stream().map(IngredientDto::new).toList(),
                calculateTotalRecipeKcals(recipe.getIngredientList().stream().map(IngredientDto::new).toList())
        );
    }
}
