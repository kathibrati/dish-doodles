package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.controller.AbstractControllerTestIT;
import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IngredientControllerTestIT extends AbstractControllerTestIT {

    @Test
    void getIngredients__success() throws Exception {
        Ingredient banana = persistSampleIngredient("Banana");

        mockMvc.perform(get("/api/ingredients"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(List.of(banana)))
                );
    }

    @Test
    void getSingleIngredient__success() throws Exception {
        Ingredient mehl = persistSampleIngredient("Mehl");
        mockMvc.perform((get("/api/ingredients/" + mehl.getId())))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(mehl))
                );
    }

    @Test
    void getSingleIngredient__not_found() throws Exception {
        mockMvc.perform(get("/api/ingredients/" + 123456L))
                .andExpect(
                        status().isNotFound()
                );
    }

    @Test
    void createIngredient__success() throws Exception {
        IngredientCreateOrUpdateResource createOrUpdateResource = new IngredientCreateOrUpdateResource("Tomate");

        mockMvc.perform(
                        post("/api/ingredients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(createOrUpdateResource))
                )
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.id").exists(),
                        jsonPath("$.name", is(createOrUpdateResource.name()))
                );

        // oder so
//        var result = mockMvc.perform(post("/api/ingredients")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(createOrUpdateResource))).andReturn();
//
//        var dto = objectMapper.readValue(result.getResponse().getContentAsString(), IngredientDto.class);
//
//        assertThat(dto.id()).isNotNull();
//        assertThat(dto.name()).isEqualTo(createOrUpdateResource.name());

    }

    @Test
    void deleteIngredientByIdById__success() throws Exception {
        Ingredient worst = persistSampleIngredient("Wurst");
        ingredientRepository.save(worst);
        mockMvc.perform(delete("/api/ingredients/1")).andExpect(status().isOk());

    }

    @Test
    void deleteIngredientByIdById__entity_doesnt_exist() throws Exception {
        mockMvc.perform(delete("/api/ingredients/1")).andExpect(status().isOk());

    }

    @Test
    void updateIngredient__should_update_name() throws Exception {
        Ingredient tomate = persistSampleIngredient("Tomate");
        IngredientCreateOrUpdateResource updateResource = new IngredientCreateOrUpdateResource("Zucker");

        var entity = ingredientRepository.findById(tomate.getId()).orElseThrow();

        assertThat(entity.getName()).isEqualTo("Tomate");

        mockMvc.perform(
                        put("/api/ingredients/"+tomate.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updateResource))
                )
                .andExpect(status().isNoContent()
                );

        entity = ingredientRepository.findById(tomate.getId()).orElseThrow();

        assertThat(entity.getName()).isEqualTo("Zucker");


    }

    @Test
    void updateIngredient__should_not_update_name() throws Exception {
        Ingredient tomate = persistSampleIngredient("Tomate");

        String name = ingredientRepository.findById(tomate.getId()).map(Ingredient::getName).orElseThrow();
        assertThat(name).isEqualTo(tomate.getName());

        mockMvc.perform(put("/api/ingredients/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tomate))
        ).andExpect(status().isNotFound());

        assertThat(name).isEqualTo(tomate.getName());

    }
}