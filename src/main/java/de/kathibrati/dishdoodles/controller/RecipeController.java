package de.kathibrati.dishdoodles.controller;

import de.kathibrati.dishdoodles.controller.model.Recipe;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.common.OvenSetting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static de.kathibrati.dishdoodles.common.Constants.API;

@RestController
@RequestMapping("/" + API + "/recipes")
public class RecipeController {

  private final RecipeRepository recipeRepository;

  public RecipeController(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @GetMapping ResponseEntity<List<Recipe>> findAll() {
    Optional<List<Recipe>> allRecipes = Optional.ofNullable(recipeRepository.findAll());
    return allRecipes.map((ResponseEntity::ok))
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}") ResponseEntity<Recipe> findById(@PathVariable(name = "id") Long id) {
    Optional<Recipe> recipe = Optional.ofNullable(recipeRepository.findById(id));
    return recipe.map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/{id}/submitRecipe")
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
    @RequestParam("modificationDate") Date modificationDate,
    @PathVariable Long id) {
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

    return "recipeSuccess";
  }

}
