package de.kathibrati.dishdoodles.ingredient.repository;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import de.kathibrati.dishdoodles.ingredient.model.IngredientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;



    @Test
    void findByNameContains__IgnoreCase__finds_ingredients_like_given_string() {
        List<Ingredient> ingredientList = List.of(Ingredient.builder()
                        .name("Tomate")
                        .build(),
                Ingredient.builder()
                        .name("Mate")
                        .build(),
                Ingredient.builder()
                        .name("Zucker")
                        .build(),
                Ingredient.builder()
                        .name("Xucker")
                        .build()
        );
        ingredientRepository.saveAll(ingredientList);


        String searchForMate = "Mate";

        List<IngredientDto> ingredientDtoList = ingredientRepository.findByNameContainsIgnoreCase(searchForMate);
        assertThat(ingredientDtoList.size()).isEqualTo(2);
        List<String> names = ingredientDtoList.stream().map(IngredientDto::name).toList();

        assertThat(names).containsExactlyInAnyOrder("Mate","Tomate");

    }

}