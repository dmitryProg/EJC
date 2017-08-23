package com.EJC.ducksTask02.ducks;

import com.EJC.ducksTask02.behavior.FlyNoWay;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a Rubber Duck!");
    }
}