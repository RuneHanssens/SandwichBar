package be.ucll.sandwichbar.domain;

public class HumidityUpdater {
    double humidity;

    public HumidityUpdater(){

    }

    public HumidityUpdater(double humidity){
        setHumidity(humidity);
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
