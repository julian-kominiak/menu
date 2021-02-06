package pl.juliankominiak.menu.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getAllMeals() {
        return new ArrayList(mealRepository.findAll());
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void deleteMeal(String id) {
        mealRepository.deleteById(id);
    }
}
