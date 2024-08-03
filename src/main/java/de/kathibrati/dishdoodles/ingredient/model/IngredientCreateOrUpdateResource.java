package de.kathibrati.dishdoodles.ingredient.model;

public record IngredientCreateOrUpdateResource(
        String name
) {
    public Ingredient convertToIngredient() {
        return Ingredient.builder()
                .name(this.name())
                .build();
    }
}
