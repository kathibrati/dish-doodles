package de.kathibrati.dishdoodles.ingredient.model;


public record IngredientDto(
Long id,
String name
) {
    public IngredientDto(Ingredient ingredient) {
        this(ingredient.getId(), ingredient.getName());
    }

    public static IngredientDto from(Ingredient ingredient) {
        return new IngredientDto(ingredient.getId(), ingredient.getName());
    }
}
