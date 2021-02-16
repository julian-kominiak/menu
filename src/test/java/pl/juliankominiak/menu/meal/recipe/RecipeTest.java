package pl.juliankominiak.menu.meal.recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
        assertEquals(Collections.emptyList(), recipe.getIngredients());
    }

    @Test
    void addIngredientDefaultUnit() {
        recipe.addIngredient("Kurczak", 300);
        assertNotNull(recipe.getIngredient("Kurczak"));
        assertEquals("Kurczak", recipe.getIngredient("Kurczak").getName());
        assertEquals(300, recipe.getIngredient("Kurczak").getQuantity());
        assertEquals("g", recipe.getIngredient("Kurczak").getUnit());
    }

    @Test
    void addIngredientCustomUnit() {
        recipe.addIngredient("Kurczak", 300, "L");
        assertNotNull(recipe.getIngredient("Kurczak"));
        assertEquals("Kurczak", recipe.getIngredient("Kurczak").getName());
        assertEquals(300, recipe.getIngredient("Kurczak").getQuantity());
        assertEquals("L", recipe.getIngredient("Kurczak").getUnit());
    }

    @Test
    void addMultipleIngredients() {
        recipe.addIngredient("Kurczak", 300);
        recipe.addIngredient("Śmietana", 100, "ml");
        assertEquals(2, recipe.getIngredients().size());
    }

    @Test
    void addIngredientNeutralQuantity() {
        recipe.addIngredient("Kurczak", 0);
        assertEquals(Collections.emptyList(), recipe.getIngredients());
    }

    @Test
    void addIngredientNegativeQuantity() {
        recipe.addIngredient("Kurczak", -10);
        assertEquals(Collections.emptyList(), recipe.getIngredients());
    }

    @Test
    void addIngredientEmptyName() {
        recipe.addIngredient("", 30);
        assertEquals(Collections.emptyList(), recipe.getIngredients());
    }

    @Test
    void addIngredientEmptyUnit() {
        recipe.addIngredient("Kurczak", 30, "");
        assertEquals("g", recipe.getIngredient("Kurczak").getUnit());
    }

    @Test
    void removeIngredient() {
        recipe.addIngredient("Kurczak", 300);
        assertNotEquals(Collections.emptyList(), recipe.getIngredients());
        recipe.removeIngredient("Kurczak");
        assertEquals(Collections.emptyList(), recipe.getIngredients());
    }

    @Test
    void removeNonExistingIngredient() {
        recipe.addIngredient("Kurczak", 300);
        recipe.removeIngredient("Naleśniki");
        assertNotNull(recipe.getIngredient("Kurczak"));
        assertEquals(1, recipe.getIngredients().size());
    }

    @Test
    void removeIngredientQuantity() {
        recipe.addIngredient("Kurczak", 300);
        recipe.removeIngredient("Kurczak", 200);
        assertEquals(100, recipe.getIngredient("Kurczak").getQuantity());
    }

    @Test
    void removeIngredientQuantityToNegative() {
        recipe.addIngredient("Kurczak", 300);
        recipe.removeIngredient("Kurczak", 500);
        assertNull(recipe.getIngredient("Kurczak"));
    }

    @Test
    void removeIngredientNegativeQuantity() {
        recipe.addIngredient("Kurczak", 300);
        recipe.removeIngredient("Kurczak", -500);
        assertEquals(300, recipe.getIngredient("Kurczak").getQuantity());
    }

    @Test
    void updateIngredientName() {
        recipe.addIngredient("Kurczak", 300);
        recipe.updateIngredientName("Kurczak", "Naleśniki");
        assertNull(recipe.getIngredient("Kurczak"));
        assertEquals("Naleśniki", recipe.getIngredient("Naleśniki").getName());
    }

    @Test
    void updateIngredientNameToEmpty() {
        recipe.addIngredient("Kurczak", 300);
        recipe.updateIngredientName("Kurczak", "");
        assertNotNull(recipe.getIngredient("Kurczak"));
        assertNull(recipe.getIngredient(""));
    }

    @Test
    void updateIngredientUnit() {
        recipe.addIngredient("Kurczak", 300);
        assertEquals("g", recipe.getIngredient("Kurczak").getUnit());
        recipe.updateIngredientUnit("Kurczak", "ml");
        assertEquals("ml", recipe.getIngredient("Kurczak").getUnit());
    }
}