package pl.juliankominiak.menu.meal.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int quantity;
    private String unit;

    public Ingredient(String name) {
        this.name = name;
        this.quantity = 0;
    }

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.unit = "g";
    }

    public Ingredient(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Ingredient() {}

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;

        Ingredient ingredient = (Ingredient) o;

        if (!getName().equals(ingredient.getName())) return false;
        return getUnit().equals(ingredient.getUnit());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getUnit().hashCode();
        return result;
    }
}
