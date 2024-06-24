package de.kathibrati.dishdoodles.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTestIT {

  @Autowired MockMvc mockMvc;

  @Test
  void findAll() throws Exception {
    mockMvc.perform((MockMvcRequestBuilders.get("/api/recipes")))
      .andExpect(status().isOk())
      .andExpect((content().contentType(MediaType.APPLICATION_JSON)))
      .andDo(print());

  }

  // region findById
  @Test
  void findById__succes() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes/1"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andDo(print());
  }

  @Test
  void findById__not_found() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes/1231"))
      .andExpect(status().isNotFound())
      .andDo(print());
  }
  //endregion

}