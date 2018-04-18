package be.ucll.sandwichbar.domain;

public class SandwichGraphData {
    private String name;
    private int bought;

    public SandwichGraphData() {
    }

    public SandwichGraphData(String name, int bought) {
        this.name = name;
        this.bought = bought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }
}
