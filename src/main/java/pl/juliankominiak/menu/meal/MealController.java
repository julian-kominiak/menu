package pl.juliankominiak.menu.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    MealService mealService;

    @PostMapping("/meals")
    public void addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
    }

    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        mealService.addMeal(new Meal("1", "Kurczak", MealType.DINNER, 350));
        return mealService.getAllMeals();
    }
}
