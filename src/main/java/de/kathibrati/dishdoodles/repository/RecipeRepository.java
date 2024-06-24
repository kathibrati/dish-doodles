package de.kathibrati.dishdoodles.repository;

import de.kathibrati.dishdoodles.model.Recipe;

import java.util.List;

public interface RecipeRepository {

  List<Recipe> findAll();

  Recipe findById(Long id);
}
