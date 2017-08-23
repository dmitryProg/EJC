package com.EJC.ducksTask02.behavior;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("    I can't fly!");
    }

    public int getSpeed() {
        return 0;
    }
}
