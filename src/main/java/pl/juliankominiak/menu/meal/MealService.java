package pl.juliankominiak.menu.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public void addMeal(Meal meal) {
        if (mealRepository.findByName(meal.getName()).isPresent()) {
            updateMeal(meal);
        } else {
            mealRepository.save(meal);
        }
    }

    public ArrayList<Meal> getAllMeals() {
        return new ArrayList<>(mealRepository.findAll());
    }

    public Meal getMeal(String name) {
        if (mealRepository.findByName(name).isPresent()) {
            return mealRepository.findByName(name).get();
        }
        return null;
    }

    public void updateMeal(Meal meal) {
        Meal mealToUpdate = mealRepository.findByName(meal.getName()).get();
        mealToUpdate.setName(meal.getName());
        mealToUpdate.setKcal(meal.getKcal());
        mealToUpdate.setMealType(meal.getMealType());
        mealToUpdate.setRecipe(meal.getRecipe());
        mealRepository.save(mealToUpdate);
    }

    public void deleteMeal(String name) {
        mealRepository.deleteByName(name);
    }
}
