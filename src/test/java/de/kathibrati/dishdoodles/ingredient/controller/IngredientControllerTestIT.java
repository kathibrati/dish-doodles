package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.controller.AbstractControllerTestIT;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class IngredientControllerTestIT extends AbstractControllerTestIT {

    @Test
    void getIngredients() throws Exception {
        Ingredient banana = persistSampleIngredient("Banana");

        mockMvc.perform(get("/api/ingredients"))
                .andExpectAll(
                        status().is2xxSuccessful(),
                        content().json(objectMapper.writeValueAsString(List.of(banana)))
                );
    }
}