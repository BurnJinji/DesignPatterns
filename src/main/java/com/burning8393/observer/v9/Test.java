package com.burning8393.observer.v9;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Button1 button = new Button1();
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListener2());
        button.buttonPressed();
    }
}

class Button1 {
    private List<ActionListener> listeners = new ArrayList<>();

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void buttonPressed() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        for (int i = 0; i < listeners.size(); i++) {
            ActionListener actionListener = listeners.get(i);
            actionListener.actionPerformed(event);
        }
    }
}

interface ActionListener {
    void actionPerformed(ActionEvent event);
}

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("button pressed");
    }
}

class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("button pressed 2");
    }
}

class ActionEvent {
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }
}

