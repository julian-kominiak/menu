package pl.juliankominiak.menu.meal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal, String> {
    List<Meal> findAll();
    List<Meal> findByMealType(MealType mealType);
}
