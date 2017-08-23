package com.EJC.ducksTask02.ducks;

import com.EJC.ducksTask02.behavior.FlyWithWings;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a Mallard Duck!");
    }
}