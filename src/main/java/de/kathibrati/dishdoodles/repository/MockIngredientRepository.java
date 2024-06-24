package de.kathibrati.dishdoodles.repository;

import de.kathibrati.dishdoodles.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockIngredientRepository implements IngredientRepository {

  Ingredient ingredient1 = Ingredient.builder()
    .id(1L)
    .name("Tomate")
    .build();

  Ingredient ingredient2 = Ingredient.builder()
    .id(2L)
    .name("Champignon")
    .build();
  Ingredient ingredient3 = Ingredient.builder()
    .id(3L)
    .name("Milch")
    .build();

  @Override public List<Ingredient> findAll() {
    return List.of(ingredient1, ingredient2, ingredient3);
  }

  @Override public Ingredient findById(Long id) {
    return (Ingredient) findAll().stream().filter(ingredient -> ingredient.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  @Override public Ingredient save() {
    return null;
  }

  @Override public void delete() {

  }
}
