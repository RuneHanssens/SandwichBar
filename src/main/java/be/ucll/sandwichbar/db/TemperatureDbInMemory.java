package be.ucll.sandwichbar.db;

public class TemperatureDbInMemory implements TemperatureDb{
    private double temp;
    private double hum;

    public TemperatureDbInMemory() {
    }

    public TemperatureDbInMemory(double temp) {
        this.temp = temp;
    }

    @Override
    public double getTemp() {
        return temp;
    }

    @Override
    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public double getHum() {
        return hum;
    }

    @Override
    public void setHum(double hum) {
        this.hum = hum;
    }
}
