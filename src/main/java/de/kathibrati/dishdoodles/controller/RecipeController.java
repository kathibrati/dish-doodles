package de.kathibrati.dishdoodles.controller;

import de.kathibrati.dishdoodles.model.Ingredient;
import de.kathibrati.dishdoodles.model.OvenSetting;
import de.kathibrati.dishdoodles.model.Recipe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/{country}/{language}/recipes")
public class RecipeController {

  @PostMapping("/submitRecipe")
  public String submitRecipe(
    @RequestParam("recipeName") String recipeName,
    @RequestParam("ingredientList") List<Ingredient> ingredientList,
    @RequestParam("ovenSettings") List<OvenSetting> ovenSettings,
    @RequestParam("cookingInstructions") String cookingInstructions,
    @RequestParam("recipeImageUrl") String recipeImageUrl,
    @RequestParam("dietaryRestrictions") String dietaryRestrictions,
    @RequestParam("chefName") String chefName,
    @RequestParam("cookingTime") double cookingTime,
    @RequestParam("preparationTime") double preparationTime,
    @RequestParam("ovenTemperature") double ovenTemperature,
    @RequestParam("totalKcals") double totalKcals,
    @RequestParam("servings") double servings,
    @RequestParam("creationDate") Date creationDate,
    @RequestParam("modificationDate") Date modificationDate
  ) {
    Recipe recipe = new Recipe();
    recipe.setRecipeName(recipeName);
    recipe.setIngredientList(ingredientList);
    recipe.setOvenSettings(ovenSettings);
    recipe.setCookingInstructions(cookingInstructions);
    recipe.setRecipeImageUrl(recipeImageUrl);
    recipe.setDietaryRestrictions(dietaryRestrictions);
    recipe.setChefName(chefName);
    recipe.setCookingTime(cookingTime);
    recipe.setPreparationTime(preparationTime);
    recipe.setOvenTemperature(ovenTemperature);
    recipe.setTotalKcals(totalKcals);
    recipe.setServings(servings);
    recipe.setCreationDate(creationDate);
    recipe.setModificationDate(modificationDate);

    // Save recipe to the database or process as needed

    return "recipeSuccess";
  }

}
