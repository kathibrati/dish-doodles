package de.kathibrati.dishdoodles.service;

import de.kathibrati.dishdoodles.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements  RecipeService{

  @Override
  public boolean save(Recipe recipe, String country, String language) {
    return false;
  }

  @Override
  public List<Recipe> getRecipeByName(String searchText, String country, String language) {
    return null;
  }

  @Override
  public List<Recipe> getAllRecipes(String country, String language) {
    return null;
  }
}
