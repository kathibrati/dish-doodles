package de.kathibrati.dishdoodles.ingredient.repository;

import de.kathibrati.dishdoodles.ingredient.model.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @BeforeEach
    public void setUpIngredientsRepository() {
        List<Ingredient> ingredientList = List.of(Ingredient.builder()
                        .name("Tomate")
                        .calories(50)
                        .build(),
                Ingredient.builder()
                        .name("Mate")
                        .calories(59)
                        .build(),
                Ingredient.builder()
                        .name("Zucker")
                        .calories(98)
                        .build(),
                Ingredient.builder()
                        .calories(0)
                        .name("Xucker")
                        .build()
        );
        ingredientRepository.saveAll(ingredientList);
    }

    @Test
    void findByNameContains__IgnoreCase__finds_ingredients_like_given_string() {


        String searchForMate = "Mate";

        List<Ingredient> ingredientDtoList = ingredientRepository.findByNameContainsIgnoreCase(searchForMate);
        assertThat(ingredientDtoList.size()).isEqualTo(2);
        List<String> names = ingredientDtoList.stream().map(Ingredient::getName).toList();

        assertThat(names).containsExactlyInAnyOrder("Mate","Tomate");

    }


    @Test
    void findAllIngredientPages() {
        Page<Ingredient> ingredientPage = ingredientRepository.findAll(PageRequest.of(0, 1));
        List<Ingredient> ingredients = ingredientPage.get().toList();


        assertThat(ingredients.size()).isEqualTo(1);
        assertThat(ingredients.getFirst().getName()).isEqualTo("Tomate");
    }

}