package de.kathibrati.dishdoodles.service;

import de.kathibrati.dishdoodles.model.Ingredient;
import de.kathibrati.dishdoodles.model.Recipe;

import java.util.List;

public interface IngredientService {

  boolean save(Ingredient ingredient, String country, String language);

  List<Recipe> getIngredientByName(
    String searchText,
    String country,
    String language
  );

  List<Recipe> getAllIngredients(
    String country,
    String language
  );

}
