package com.EJC.ducksTask02.behavior;

import com.EJC.ducksTask02.gameplay.GameConstants;

import java.util.Random;

/**
 * The FlyWithWings class performs flying process of a duck
 */
public class FlyWithWings implements FlyBehavior {
    private static int currentSpeed = rndSpeed(GameConstants.MIN_SPEED, GameConstants.MAX_SPEED);

    private static int rndSpeed(int minS, int maxS) {
        return (new Random(System.currentTimeMillis()).nextInt((maxS + 1) - minS) + minS);
    }

    private boolean isToDoubleSpeed() {
        return GameConstants.MULTIPLIER_SPEED_DOUBLES > Math.random();
    }

    private int doubledIncSpeed(int curSpeed) {
        return curSpeed << 1;
    }

    private int doubledDecSpeed(int curSpeed) {
        return curSpeed >> 1;
    }

    public void fly() {
        System.out.println("    Let's fly! My speed is: " + currentSpeed);
        if (this.isToDoubleSpeed())
            currentSpeed = this.doubledIncSpeed(currentSpeed);
        else
            currentSpeed = this.doubledDecSpeed(currentSpeed);
    }

    public int getSpeed() {
        return currentSpeed;
    }
}
