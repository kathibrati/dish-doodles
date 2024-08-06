package de.kathibrati.dishdoodles.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import de.kathibrati.dishdoodles.recipe.model.Recipe;
import de.kathibrati.dishdoodles.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AbstractControllerTestIT {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public IngredientRepository ingredientRepository;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public RecipeRepository recipeRepository;


    @AfterEach
    public void cleanUpRepository() {
        ingredientRepository.deleteAll();
    }

    public Ingredient persistSampleIngredient(String name) {
        Ingredient ingredient = Ingredient.builder()
                .name(name)
                .calories(100)
                .build();

       return ingredientRepository.save(ingredient);
    }


    public List<Ingredient> persistSampleIngredients(List<Ingredient> ingredients) {

        return ingredientRepository.saveAll(ingredients);
    }

    public Recipe persistSampleRecipe() {
        var recipe = persistSampleRecipe("Sample Banenbrot",
                List.of(
                        persistSampleIngredient("Banane"),
                        persistSampleIngredient("Mehl"),
                        persistSampleIngredient("Milch")
                )
                );

        return recipeRepository.save(recipe);
    }

    public Recipe persistSampleRecipe(String name, List<Ingredient> ingredientList) {
        Recipe recipe = Recipe.builder()
                .recipeName(name)
                .ingredientList(ingredientList)
                .build();

        return recipeRepository.save(recipe);
    }


}
