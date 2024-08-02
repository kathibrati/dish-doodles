package de.kathibrati.dishdoodles.ingredient.repository;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


}
