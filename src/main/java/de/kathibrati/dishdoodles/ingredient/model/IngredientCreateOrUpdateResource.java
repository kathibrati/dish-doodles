package de.kathibrati.dishdoodles.ingredient.model;

import org.hibernate.validator.constraints.Length;

public record IngredientCreateOrUpdateResource(
        @Length(max = 255) String name,
        Integer calories
) {
    public Ingredient convertToIngredient() {
        return Ingredient.builder()
                .name(this.name)
                .calories(this.calories)
                .build();
    }
}
