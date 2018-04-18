package be.ucll.sandwichbar.domain;

public class TemperatureUpdater {
    private double temp;

    public TemperatureUpdater() {
    }

    public TemperatureUpdater(double temp) {
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
