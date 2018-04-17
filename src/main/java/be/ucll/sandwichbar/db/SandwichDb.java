package be.ucll.sandwichbar.db;

import be.ucll.sandwichbar.domain.Sandwich;
import java.util.List;

public interface SandwichDb {
    List<Sandwich> getSandwiches();
    void addSandwich(Sandwich newSandWich);
    void setAmount(String name, int amount);
    Sandwich getSandwich(String name);
    void deleteSandwich(String name);
}
