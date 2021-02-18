package pl.juliankominiak.menu.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<Meal> findByName(String name);
    List<Meal> findByMealType(MealType mealType);
    void deleteByName(String name);
}
