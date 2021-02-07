package pl.juliankominiak.menu.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public ArrayList<Meal> getAllMeals() {
        return new ArrayList<>(mealRepository.findAll());
    }

    public void addMeal(Meal meal) {
        if (mealRepository.findByName(meal.getName()).isPresent()) {
            updateMeal(meal);
        } else {
            mealRepository.save(meal);
        }
    }

    public void updateMeal(Meal meal) {
        Meal mealToUpdate = mealRepository.findByName(meal.getName()).get();
        mealToUpdate.setName(meal.getName());
        mealToUpdate.setKcal(meal.getKcal());
        mealToUpdate.setMealType(meal.getMealType());
        mealToUpdate.setRecipe(meal.getRecipe());
        mealRepository.save(mealToUpdate);
    }

    public void deleteMeal(long id) {
        mealRepository.deleteById(id);
    }
}
