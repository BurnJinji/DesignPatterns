package com.burning8393.state.v2;

public class MM {
    String name;
    private MMState state = new MMHappyState();

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }

}
