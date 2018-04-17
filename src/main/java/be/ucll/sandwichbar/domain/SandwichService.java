package be.ucll.sandwichbar.domain;


import be.ucll.sandwichbar.db.SandwichDb;
import be.ucll.sandwichbar.db.SandwichDbInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService {
    private SandwichDb db;

    @Autowired
    public SandwichService() {
        db = new SandwichDbInMemory();
    }

    public List<Sandwich> getSandwiches(){
        return db.getSandwiches();
    }

    public void addSandwich(Sandwich s){
        db.addSandwich(s);
    }

    public void setAmount(String name, int amount){
        db.setAmount(name,amount);
    }
}
