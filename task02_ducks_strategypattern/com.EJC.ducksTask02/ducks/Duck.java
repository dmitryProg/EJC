package com.EJC.ducksTask02.ducks;

import com.EJC.ducksTask02.behavior.FlyBehavior;

/**
 * The abstract class Duck represents duck with it's behavior and abilities to fly and display itselves
 */
public abstract class Duck {

    public FlyBehavior flyBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
        flyBehavior.getSpeed();
    }
}
