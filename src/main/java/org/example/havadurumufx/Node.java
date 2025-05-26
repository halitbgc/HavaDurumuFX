package org.example.havadurumufx;

public class Node {
    private Weather weather;
    private Node next;

    public Node(Weather weather) {
        this.weather = weather;
        this.next = null;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
