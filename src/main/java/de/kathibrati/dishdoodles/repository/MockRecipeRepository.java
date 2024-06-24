package de.kathibrati.dishdoodles.repository;

import de.kathibrati.dishdoodles.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockRecipeRepository implements RecipeRepository {

  Recipe recipe1 = Recipe.builder()
    .id(1L)
    .recipeName("Bananenbrot")
    .chefName("Ralf")
    .build();

  Recipe recipe2 = Recipe.builder()
    .id(2L)
    .recipeName("Pizza")
    .chefName("Jarjar")
    .build();

  @Override public List<Recipe> findAll() {
    return List.of(recipe1, recipe2);
  }

  @Override public Recipe findById(Long id) {
    return (Recipe) findAll().stream().filter(recipe -> recipe.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
}
