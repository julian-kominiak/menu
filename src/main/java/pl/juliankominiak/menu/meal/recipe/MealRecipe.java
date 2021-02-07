package pl.juliankominiak.menu.meal.recipe;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class MealRecipe {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Ingredient> ingredients;

    public MealRecipe() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredient.addQuantity(ingredient.getQuantity());
        }
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
