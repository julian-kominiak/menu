package pl.juliankominiak.menu;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Recipe {

    @Id
    private String id;

    @ElementCollection
    Map<String, Integer> components;

    public Recipe() {
        this.components = new HashMap<>();
    }

    public Recipe(String id) {
        this.id = id;
        this.components = new HashMap<>();
    }

    public void addComponent(String component, int quantity) {
        if (components.containsKey(component)) {
            components.put(component, components.get(component) + quantity);
        }
        components.put(component, quantity);
    }

    public Map<String, Integer> getComponents() {
        return components;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
