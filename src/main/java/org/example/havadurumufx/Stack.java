package org.example.havadurumufx;

import javafx.scene.control.Label;

public class Stack {
    private StackNode head;
    public Stack() {
        this.head = null;
    }

    public void push(Label label) { //elamani en alta atar sonra gittikce ustune ekleme yapilir
        StackNode newNode = new StackNode(label);
        newNode.setNext(head);
        head = newNode;
    }

    public Label pop() { // dizideki en ustteki elemani cikartir ve cikartilan degeri return eder
        Label remove = head.getLabel();
        head = head.getNext();
        return remove;
    }

    public void print() {
        StackNode temp = head;

        while (temp != null) {
            System.out.println(temp.getLabel());
            temp = temp.getNext();
        }
    }

    public int length() {
        StackNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
