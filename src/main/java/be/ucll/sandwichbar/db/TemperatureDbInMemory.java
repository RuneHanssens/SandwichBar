package be.ucll.sandwichbar.db;

public class TemperatureDbInMemory implements TemperatureDb{
    private double temp;

    public TemperatureDbInMemory() {
    }

    public TemperatureDbInMemory(double temp) {
        this.temp = temp;
    }

    @Override
    public double getTemp() {
        return 0;
    }

    @Override
    public void setTemp(double temp) {
        this.temp = temp;
    }

}
