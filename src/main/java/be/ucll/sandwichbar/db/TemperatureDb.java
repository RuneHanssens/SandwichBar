package be.ucll.sandwichbar.db;

public interface TemperatureDb {
    double getTemp();
    void setTemp(double temp);
    double getHum();
    void setHum(double hum);
}
