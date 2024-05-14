package de.kathibrati.dishdoodles.service;

import de.kathibrati.dishdoodles.model.Ingredient;
import de.kathibrati.dishdoodles.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IngredientServiceImpl  implements IngredientService{

  @Override
  public boolean save(Ingredient ingredient, String country, String language) {
    return false;
  }

  @Override
  public List<Recipe> getIngredientByName(String searchText, String country, String language) {
    return null;
  }

  @Override
  public List<Recipe> getAllIngredients(String country, String language) {
    return null;
  }
}
