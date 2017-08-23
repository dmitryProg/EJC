package com.EJC.ducksTask02.gameplay;

public final class GameConstants {
    /**
     * @value MULTIPLIER_SPEED_DOUBLES : coefficiency of probability that a speed will be doubled; 0.5 for 50%
     * @value MULTIPLIER_DUCKS_FLYABLE : coefficiency of probability that a duck will fly; 0.5 for 50%
     * @value BET_WIN_MULTIPLIER : coefficiency of how many times your won money are bigger then your bet
     */
    public final static double MULTIPLIER_SPEED_DOUBLES = 0.5;
    public final static int MIN_SPEED = 10;
    public final static int MAX_SPEED = 100;
    final static double MULTIPLIER_DUCKS_FLYABLE = 0.5;
    final static int CASH_BANK = 500;
    final static int EMPTY_BANK = 0;
    final static int BET_SIZE = 100;
    final static int BET_WIN_MULTIPLIER = 2;
    final static int NUM_DUCKS = 5;
    final static int TIME_OF_FLIGHT = 10;
}
