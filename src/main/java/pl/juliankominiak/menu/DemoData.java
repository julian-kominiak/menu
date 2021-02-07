package pl.juliankominiak.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.juliankominiak.menu.meal.Meal;
import pl.juliankominiak.menu.meal.MealRepository;
import pl.juliankominiak.menu.meal.MealType;
import pl.juliankominiak.menu.meal.recipe.Ingredient;
import pl.juliankominiak.menu.meal.recipe.MealRecipe;

@Component
public class DemoData {

    @Autowired
    private MealRepository mealRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        Meal meal = new Meal("Kurczak śmietanowy", MealType.DINNER, 450);
        MealRecipe mealRecipe = new MealRecipe();
        mealRecipe.addIngredient(new Ingredient("Kurczak", 300));
        mealRecipe.addIngredient(new Ingredient("Śmietana", 100, "ml"));
        meal.setRecipe(mealRecipe);
        mealRepository.save(meal);

        mealRepository.save(new Meal("Naleśniki", MealType.DINNER, 45034));
    }

}
