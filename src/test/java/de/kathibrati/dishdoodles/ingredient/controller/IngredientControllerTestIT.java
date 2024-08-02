package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.controller.AbstractControllerTestIT;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class IngredientControllerTestIT extends AbstractControllerTestIT {

    @Test
    void getIngredients() throws Exception {
        mockMvc.perform(get("/api/ingredients"))
                .andExpect(status().is2xxSuccessful());
    }
}