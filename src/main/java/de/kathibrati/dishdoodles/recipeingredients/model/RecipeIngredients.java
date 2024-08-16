package de.kathibrati.dishdoodles.recipeingredients.model;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class RecipeIngredients {

  @Id
  @GeneratedValue
  private Long id;

  private List<Ingredient> ingredientId;

  private Long recipeId;




}
