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

    private void generateContent(){
        Sandwich s1 = new Sandwich("broodje1", 2.5, "brood met nog een paar dingen", 5);
        Sandwich s2 = new Sandwich("broodje2", 3.5, "brood met nog een andere paar dingen", 10);
        addSandwich(s1);
        addSandwich(s2);
    }
}
