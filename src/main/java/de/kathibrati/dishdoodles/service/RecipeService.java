package de.kathibrati.dishdoodles.service;

import de.kathibrati.dishdoodles.model.Recipe;

import java.util.List;

public interface RecipeService {

  boolean save(Recipe recipe, String country, String language);

  List<Recipe> getRecipeByName(
    String searchText,
    String country,
    String language
  );

  List<Recipe> getAllRecipes(
    String country,
    String language
  );

}
