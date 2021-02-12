package pl.juliankominiak.menu.meal.recipe;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Ingredient> ingredients;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(String name, int quantity) {
        addIngredient(name, quantity, "g");
    }

    public void addIngredient(String name, int quantity, String unit) {
        if (ingredients.stream()
                .anyMatch(i -> i.getName().equals(name))) {
            addIngredientQuantity(name, quantity);
        } else {
            Ingredient ingredient = new Ingredient(name, quantity, unit);
            ingredients.add(ingredient);
        }
    }

    private void addIngredientQuantity(String name, int quantity) {
        ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .forEach(i -> i.setQuantity(i.getQuantity() + quantity));
    }

    public void removeIngredient(String name) {
        if (ingredients.stream()
                .anyMatch(i -> i.getName().equals(name))) {
            Ingredient ingredientToRemove = ingredients.stream()
                    .filter(i -> i.getName().equals(name))
                    .findAny()
                    .get();
            ingredients.remove(ingredientToRemove);
        }
    }

    private void removeIngredient(String name, int quantity) {
        ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .forEach(i -> i.setQuantity(i.getQuantity() - quantity));
        if (ingredients.stream()
                .anyMatch(i -> i.getQuantity() <= 0)) {
            Ingredient ingredientToRemove = ingredients.stream()
                    .filter(i -> i.getQuantity() <= 0)
                    .findAny()
                    .get();
            ingredients.remove(ingredientToRemove);
        }
    }

    public void updateIngredientName(String name, String newName) {
        ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .forEach(i -> i.setName(newName));
    }

    public void updateIngredientUnit(String name, String newUnit) {
        ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .forEach(i -> i.setUnit(newUnit));
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
