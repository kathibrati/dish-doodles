package de.kathibrati.dishdoodles.repository;

import de.kathibrati.dishdoodles.model.Ingredient;

import java.util.List;

public interface IngredientRepository {

  List<Ingredient> findAll();

  Ingredient findById(Long id);

  Ingredient save();

  void delete();

}
