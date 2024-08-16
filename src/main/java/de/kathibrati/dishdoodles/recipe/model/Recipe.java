package de.kathibrati.dishdoodles.recipe.model;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
  private Integer totalKcals;

  @JoinColumn
  @OneToMany
  private List<Ingredient> ingredientList;
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
