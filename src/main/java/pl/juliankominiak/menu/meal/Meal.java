package pl.juliankominiak.menu.meal;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import pl.juliankominiak.menu.meal.recipe.Recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Meal {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private MealType mealType;
    private int kcal;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Recipe recipe;

    public Meal(String name, MealType mealType, int kcal) {
        this.name = name;
        this.mealType = mealType;
        this.kcal = kcal;
    }

    public Meal() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
