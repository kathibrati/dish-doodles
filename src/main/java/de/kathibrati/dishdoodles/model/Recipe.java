package de.kathibrati.dishdoodles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

  private String recipeName;
  private List<Ingredient> ingredientList;
  private List<OvenSetting> ovenSettings;
  private String cookingInstructions;
  private String recipeImageUrl;
  private String dietaryRestrictions;
  private String chefName;
  private double cookingTime;
  private double preparationTime;
  private double ovenTemperature;
  private double totalKcals;
  private double servings;
  private Date creationDate;
  private Date modificationDate;


}
