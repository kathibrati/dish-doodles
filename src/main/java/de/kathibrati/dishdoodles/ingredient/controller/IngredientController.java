package de.kathibrati.dishdoodles.ingredient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody IngredientCreateOrUpdateResource ingredientResource) {
        IngredientDto dto = ingredientService.save(ingredientResource);
        if (dto != null) {
            return ResponseEntity.ok(dto);
//            return ResponseEntity.created(dto);
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
