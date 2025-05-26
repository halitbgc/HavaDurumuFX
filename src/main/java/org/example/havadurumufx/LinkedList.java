package org.example.havadurumufx;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Weather weather) {
        if(head == null) {
            head = new Node(weather);
        }
        else {
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(weather));
        }
    }

    public int length() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.getWeather() + " ");
            temp = temp.getNext();
        }
    }

    public Weather get(int i) {
        Node temp = head;
        int count = 0;

        while (count != i) {
            temp = temp.getNext();
            count++;
        }
        return temp.getWeather();
    }

    public void set(int i, Weather weather) {
        Node temp = head;
        int count = 0;

        while (count != i) {
            temp = temp.getNext();
            count++;
        }
        temp.setWeather(weather);
    }

}
