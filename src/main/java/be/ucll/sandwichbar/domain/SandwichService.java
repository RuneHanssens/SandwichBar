package be.ucll.sandwichbar.domain;


import be.ucll.sandwichbar.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichService {
    private SandwichDb sDb;
    private TemperatureDb tDb;

    @Autowired
    public SandwichService() {
        sDb = new SandwichDbInMemory();
        tDb = new TemperatureDbInMemory();
    }

    public List<Sandwich> getSandwiches(){
        return sDb.getSandwiches();
    }

    public void addSandwich(Sandwich s){
        sDb.addSandwich(s);
    }

    public void updateSandwich(Sandwich s){
        sDb.updateSandwich(s);
    }

    public void updateAmount(String name, int amount){
        sDb.getSandwich(name).setAmount(amount);
        System.out.println(sDb.getSandwich(name).getAmount());
    }

    public Sandwich getSandwich(String name){
        return sDb.getSandwich(name);
    }

    public double getTemp(){
        return tDb.getTemp();
    }

    public void setTemp(double temp){
        tDb.setTemp(temp);
    }

    public double getHum(){return tDb.getHum();}

    public void setHum(double hum){
        tDb.setHum(hum);
    }
}
