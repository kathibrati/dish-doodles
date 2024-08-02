package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<IngredientDto> getIngredient(@PathVariable Long id) {
        IngredientDto dto = ingredientService.findById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else
            return ResponseEntity.notFound().build();

    }
}
