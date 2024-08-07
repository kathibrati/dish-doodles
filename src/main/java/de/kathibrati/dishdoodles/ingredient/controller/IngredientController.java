package de.kathibrati.dishdoodles.ingredient.controller;

import de.kathibrati.dishdoodles.ingredient.model.IngredientCreateOrUpdateResource;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import de.kathibrati.dishdoodles.ingredient.service.IngredientService;
import jakarta.validation.Valid;
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
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(
           @Valid @RequestBody IngredientCreateOrUpdateResource ingredientResource
    ) {
        IngredientDto dto = ingredientService.save(ingredientResource);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id) {
        ingredientService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateIngredient(@PathVariable Long id,
                                                 @RequestBody IngredientCreateOrUpdateResource resource) {
        ingredientService.updateIngredient(resource, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<IngredientDto>> searchIngredientBySearchTerm(@RequestParam("name") String searchName) {
        List<IngredientDto> dtos = ingredientService.searchByName(searchName);

        if (dtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dtos);

    }

}
