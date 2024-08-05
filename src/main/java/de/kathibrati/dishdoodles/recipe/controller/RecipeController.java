package de.kathibrati.dishdoodles.recipe.controller;

import de.kathibrati.dishdoodles.recipe.model.RecipeDto;
import de.kathibrati.dishdoodles.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static de.kathibrati.dishdoodles.common.Constants.API;

@RestController
@RequestMapping(path = "/"+ API +"/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>> getRecipes() {
        List<RecipeDto> dtos = recipeService.findAll();
        return ResponseEntity.ok(dtos);
    }
}
