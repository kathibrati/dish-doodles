package de.kathibrati.dishdoodles.recipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recipe {

  @Id
  @GeneratedValue
  private Long id;
  private String recipeName;
  private int totalKcals;
  //TODO Lösung finden how to verschachtel
//  private List<Ingredient> ingredientList;
//  private List<OvenSetting> ovenSettings;
//  private String cookingInstructions;
//  private String dietaryRestrictions;
//  private String chefName;
//  private double cookingTime;
//  private double preparationTime;
//  private double ovenTemperature;
//  private double servings;
//  private LocalDateTime creationDate;


}
