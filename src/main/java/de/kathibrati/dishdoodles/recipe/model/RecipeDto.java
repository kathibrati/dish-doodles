package de.kathibrati.dishdoodles.recipe.model;

public record RecipeDto(
        Long id,
        String name
) {
    public RecipeDto(Recipe recipe) {
        this(recipe.getId(), recipe.getRecipeName());
    }
}
