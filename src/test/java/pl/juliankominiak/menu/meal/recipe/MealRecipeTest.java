//package pl.juliankominiak.menu.meal.recipe;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.mockito.configuration.IMockitoConfiguration;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MealRecipeTest {
//
//    private MealRecipe mealRecipe;
//
//    @BeforeEach
//    void setUp() {
//        mealRecipe = new MealRecipe();
//        mealRecipe.addIngredient("Kurczak", 300);
//    }
//
//    @Test
//    void shouldRemoveIngredient() {
//        assertFalse(mealRecipe.getIngredients().isEmpty());
////        mealRecipe.removeIngredient("Kurczak", 300);
//        assertTrue(mealRecipe.getIngredients().isEmpty());
//    }
//
//
//
//}