package de.kathibrati.dishdoodles.controller;

import de.kathibrati.dishdoodles.model.Ingredient;
import de.kathibrati.dishdoodles.repository.IngredientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static de.kathibrati.dishdoodles.common.Constants.API;

@RestController
@RequestMapping("/" + API + "/ingredients")
public class IngredientController {

  private final IngredientRepository ingredientRepository;

  public IngredientController(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @GetMapping ResponseEntity<List<Ingredient>> findAll() {
    Optional<List<Ingredient>> allIngredients = Optional.ofNullable(ingredientRepository.findAll());
    return allIngredients.map((ResponseEntity::ok))
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}") ResponseEntity<Ingredient> findById(@PathVariable(name = "id") Long id) {
    Optional<Ingredient> ingredient = Optional.ofNullable(ingredientRepository.findById(id));
    return ingredient.map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }
}
