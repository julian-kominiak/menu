package pl.juliankominiak.menu.meal;

import pl.juliankominiak.menu.Recipe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Meal {
    @Id
    private String id;
    private String name;
    private MealType mealType;
    private int kcal;

    @OneToOne
    private Recipe recipe;

    public Meal(String id, String name, MealType mealType, int kcal) {
        this.id = id;
        this.name = name;
        this.mealType = mealType;
        this.kcal = kcal;
    }

    public Meal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;

        Meal meal = (Meal) o;

        if (getKcal() != meal.getKcal()) return false;
        if (!getName().equals(meal.getName())) return false;
        if (getMealType() != meal.getMealType()) return false;
        return getRecipe().equals(meal.getRecipe());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getMealType().hashCode();
        result = 31 * result + getRecipe().hashCode();
        result = 31 * result + getKcal();
        return result;
    }
}
