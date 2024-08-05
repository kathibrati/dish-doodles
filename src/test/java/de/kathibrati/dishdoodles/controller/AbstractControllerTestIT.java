package de.kathibrati.dishdoodles.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.repository.IngredientRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AbstractControllerTestIT {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public IngredientRepository ingredientRepository;

    @Autowired
    public ObjectMapper objectMapper;

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


}
