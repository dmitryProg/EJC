package com.EJC.ducksTask02.gameplay;

import com.EJC.ducksTask02.ducks.Duck;
import com.EJC.ducksTask02.ducks.MallardDuck;
import com.EJC.ducksTask02.ducks.RubberDuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Round class performs game actions during the round
 */
class Round {
    private static int currentCash = GameConstants.CASH_BANK;

    private boolean isEmpty(int curCash) {
        return curCash <= GameConstants.EMPTY_BANK;
    }

    private int decreaseBank(int curCash) {
        return curCash - GameConstants.BET_SIZE;
    }

    private int increaseBank(int curCash) {
        return curCash + GameConstants.BET_WIN_MULTIPLIER * GameConstants.BET_SIZE;
    }

    private boolean isFlyable() {
        return GameConstants.MULTIPLIER_DUCKS_FLYABLE > Math.random();
    }

    private int getDuckNumber() {
        int dNum;
        while (true) {
            System.out.println("Please, enter the number of your duck from 1 up to " + GameConstants.NUM_DUCKS);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                dNum = Integer.parseInt(reader.readLine());
                if (dNum > 0 && dNum <= GameConstants.NUM_DUCKS) break;
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return dNum;
    }

    /**
     * The function performs gameplay
     * The rest of the ducks, NOT YOURS, will be only added to flyingDuckList.
     * You just get 200 $ for other flying mallard ducks.
     *
     * @return 0 if everything is O.K.
     */
    int performIt() {
        int duckNumber;
        duckNumber = this.getDuckNumber();
        List<Duck> flyingDucksList = new ArrayList<>();

        for (int i = 0; i < GameConstants.NUM_DUCKS; i++) {
            if (this.isFlyable()) {
                Duck duck = new MallardDuck();
                duck.display();
                if ((duckNumber - 1) == i) {
                    System.out.println("You're lucky today! Your duck can fly!");
                    int myDuckPrevSpeed;
                    int myDuckCurrSpeed;

                    for (int j = 0; j < GameConstants.TIME_OF_FLIGHT; j++) {
                        System.out.println("        Second #" + (j + 1));
                        if (duck.flyBehavior.getSpeed() == 0) {
                            System.out.println("\nW.A.S.T.E.D! Your duck's speed is 0!");
                            return 0;
                        }
                        myDuckPrevSpeed = duck.flyBehavior.getSpeed();
                        duck.performFly();
                        myDuckCurrSpeed = duck.flyBehavior.getSpeed();
                        if (j > 0) {
                            if (myDuckPrevSpeed > myDuckCurrSpeed) currentCash = this.decreaseBank(currentCash);
                            else if (myDuckPrevSpeed < myDuckCurrSpeed) currentCash = this.increaseBank(currentCash);
                            else continue;
                        }
                        if (this.isEmpty(currentCash)) {
                            System.out.println("\nW.A.S.T.E.D! Your bank is empty! " + currentCash);
                            return 0;
                        }
                    }

                }
                flyingDucksList.add(duck);
                currentCash = this.increaseBank(currentCash);
            } else {
                Duck duck = new RubberDuck();
                duck.display();
                duck.performFly();
                if ((duckNumber - 1) == i) {
                    System.out.println("\nW.A.S.T.E.D! Your RUBBER duck can't fly!");
                    return 0;
                }
                currentCash = this.decreaseBank(currentCash);
            }
        }
        System.out.println("\nGood game! The number of flying ducks is: " + flyingDucksList.size());
        System.out.println("You have won " + currentCash + "$");
        return 0;
    }
}
