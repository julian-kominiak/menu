package pl.juliankominiak.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.juliankominiak.menu.meal.Meal;
import pl.juliankominiak.menu.meal.MealService;
import pl.juliankominiak.menu.meal.MealType;

@SpringBootApplication
public class MenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);
    }

}
