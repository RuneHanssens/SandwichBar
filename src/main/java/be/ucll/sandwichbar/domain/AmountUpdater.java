package be.ucll.sandwichbar.domain;

public class AmountUpdater {
    String name = "broodje1";
    int amount;

    public AmountUpdater(){

    }

    public AmountUpdater(String name, int amount){
        setAmount(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
