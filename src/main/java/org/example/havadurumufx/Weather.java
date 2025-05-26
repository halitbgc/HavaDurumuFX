package org.example.havadurumufx;

public class Weather {
    private String date;
    private String day;
    private String description;
    private String status;
    private int degree;
    private int min;
    private int max;
    private int night;
    private int humidity;

    public Weather(String date, String day, String description, String status, int degree, int min, int max, int night, int humidity) {
        this.date = date;
        this.day = day;
        this.description = description;
        this.status = status;
        this.degree = degree;
        this.min = min;
        this.max = max;
        this.night = night;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", degree=" + degree +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", humidity=" + humidity +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}