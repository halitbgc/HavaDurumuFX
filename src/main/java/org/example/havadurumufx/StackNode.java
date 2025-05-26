package org.example.havadurumufx;

import javafx.scene.control.Label;

public class StackNode {
    private Label label;
    private StackNode next;

    public StackNode(Label label) {
        this.label = label;
        this.next = null;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
