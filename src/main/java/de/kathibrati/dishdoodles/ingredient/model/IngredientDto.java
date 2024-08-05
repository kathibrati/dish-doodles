package de.kathibrati.dishdoodles.ingredient.model;


public record IngredientDto(
        Long id,
        String name,
        Integer calories
) {
    public IngredientDto(Ingredient ingredient) {
        this(ingredient.getId(), ingredient.getName(), ingredient.getCalories());
    }
}
