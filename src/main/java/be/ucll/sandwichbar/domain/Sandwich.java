package be.ucll.sandwichbar.domain;


import java.util.Random;

public class Sandwich {
    private String name;
    private double price;
    private String description;
    private int amount;

    public Sandwich() {
    }

    public Sandwich(String name, double price, String description, int amount) {
        setDescription(description);
        setName(name);
        setPrice(price);
        setAmount(amount);
    }

    public Sandwich(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        setAmount(0);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRandomAmount(){
        Random r = new Random();
        if((r.nextInt(5)+1)==5){
            this.amount ++;
        }
    }
}
