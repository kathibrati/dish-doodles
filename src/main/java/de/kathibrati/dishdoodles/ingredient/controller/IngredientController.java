package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static de.kathibrati.dishdoodles.common.Constants.API;

@RestController
@RequestMapping(path = "/" + API + "/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        List<IngredientDto> ingredients = ingredientService.findAll();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(
            @RequestBody IngredientCreateOrUpdateResource ingredientResource
    ) {
        IngredientDto dto = ingredientService.save(ingredientResource);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<IngredientDto> deleteIngredient(@PathVariable Long id) {
        return null;
    }
}
