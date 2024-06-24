package de.kathibrati.dishdoodles.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.PathMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTestIT {

  @Autowired MockMvc mockMvc;
  @Autowired private PathMatcher mvcPathMatcher;

  @Test
  void findAll() throws Exception {
    // TODO:  expect not empty ingredients, expect size 3
    mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andDo(print());
  }

  // region findById
  @Test
  void findById__success() throws Exception {
    //TODO meaningful test
    mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients/1"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andDo(print());
  }

  @Test
  void findById__not_found() throws Exception {
    //TODO meaningful test
    mockMvc.perform(MockMvcRequestBuilders.get("/api/ingredients/1231"))
      .andExpect(status().isNotFound())
      .andDo(print());
  }
  //endregion
}