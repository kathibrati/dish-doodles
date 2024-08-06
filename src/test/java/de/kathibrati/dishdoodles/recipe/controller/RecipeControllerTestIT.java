package de.kathibrati.dishdoodles.recipe.controller;

import de.kathibrati.dishdoodles.controller.AbstractControllerTestIT;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.recipe.model.Recipe;
import de.kathibrati.dishdoodles.recipe.model.RecipeDto;
import de.kathibrati.dishdoodles.recipe.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RecipeControllerTestIT extends AbstractControllerTestIT {

    @Test
    void getRecipes() throws Exception {
        List<Ingredient> ingredientList = (List.of(
                Ingredient.builder().name("Ei").calories(90).amount(6).build(),
                Ingredient.builder().name("Milch").calories(47).amount(120).build(),
                Ingredient.builder().name("Dinkelmehl").calories(348).amount(140).build()
        ));

        persistSampleIngredients(ingredientList);

        Integer totalKcals = RecipeService.calculateTotalRecipeKcals(ingredientList.stream().map(IngredientDto::new).toList());

        Recipe myFavouriteRecipe = Recipe.builder()
                .recipeName("Protein Waffeln")
                .ingredientList(ingredientList)
                .totalKcals(totalKcals)
                .build();

        recipeRepository.save(myFavouriteRecipe);

        RecipeDto recipeDto = new RecipeDto(myFavouriteRecipe);

        mockMvc.perform(get("/api/recipes"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(List.of(recipeDto)))
                );
    }
}