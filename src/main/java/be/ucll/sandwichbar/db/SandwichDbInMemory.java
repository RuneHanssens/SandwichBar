package be.ucll.sandwichbar.db;

import be.ucll.sandwichbar.domain.Sandwich;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SandwichDbInMemory implements SandwichDb {
    private Map<String,Sandwich> sandwiches;

    public SandwichDbInMemory() {
        this.sandwiches = new HashMap<String,Sandwich>();
        generateContent();
    }

    public List<Sandwich> getSandwiches() {
        List<Sandwich> result = new ArrayList<Sandwich>();
        for (Sandwich value : sandwiches.values()) {
            result.add(value);
        }
        return result;
    }

    public void addSandwich(Sandwich newSandWich) {
        sandwiches.put(newSandWich.getName(),newSandWich);
    }


    public void setAmount(String name, int amount) {
        getSandwich(name).setAmount(amount);
    }

    public Sandwich getSandwich(String name) {
        return sandwiches.get(name);
    }

    public void deleteSandwich(String name) {
        sandwiches.remove(name);
    }

    @Override
    public void updateSandwich(Sandwich s) {
        sandwiches.remove(s.getName());
        sandwiches.put(s.getName(),s);
    }

    private void generateContent(){
        Sandwich s1 = new Sandwich("Martino", 2.8, "Wit broodje met americain, martino saus, uitjes en augurken", 0);
        Sandwich s2 = new Sandwich("Balleke andalouse", 3.0, "Wit broodje met balleke en andalouse", 10);
        Sandwich s3 = new Sandwich("Mozzarella pesto", 3.5, "Wit broodje met tomaat, mozzarello en pesto", 8);
        Sandwich s4 = new Sandwich("Smoske", 2.8, "Wit broodje met hesp, kaas, groentjes en mayonaise", 3);
        s2.setBought(9);
        s3.setBought(6);
        s4.setBought(11);
        addSandwich(s1);
        addSandwich(s2);
        addSandwich(s3);
        addSandwich(s4);
    }
}
