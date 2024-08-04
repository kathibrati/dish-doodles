package de.kathibrati.dishdoodles.ingredient.repository;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<IngredientDto> findByNameContainsIgnoreCase(String searchName);

}
