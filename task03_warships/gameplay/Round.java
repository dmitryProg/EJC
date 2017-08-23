package gameplay;

import gameObjects.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Round {
    private final static int roundLimit = 40;
    private Field gameField = new Field();
    private int shipCells = 20;
    private int numberOfRounds = 1;

    /**
     * The setShipsRandomized() method arranges fleet of ships randomly placing it above all the game field
     *
     * @param field
     */
    private void setShipsRandomized(Field field) {
        field.setFleetPosition();
    }

    /**
     * The getSHipCellsNum() method returns the amount of alive shipCells of the game field
     * thus deciding whether the game is won or not
     *
     * @return shipCells
     */
    private int getShipCellsNum() {
        return this.shipCells;
    }

    /**
     * The performRound() method describes all the required operations for the game turn
     * including shooting of the respectable player
     */

    void performRound() {
        if (numberOfRounds == 1) {
            this.setShipsRandomized(gameField);
            gameField.visualizeInitialField();
            System.out.println("\n\nYou're really lucky that none of your ships was drowned by the storm!");
        }
        int returnValue;
        do {
            returnValue = performShotToPoint(0, 0, gameField);
        }
        while (returnValue == 1);

        gameField.visualizeField();
        System.out.print("\nYour next turn.");
        numberOfRounds++;
        if (this.getShipCellsNum() == 0) {
            System.out.println("The game is over. You have won!");
        } else if (numberOfRounds == roundLimit) {
            System.out.println("The game is over. You have failed!");
        } else performRound();
    }

    /**
     * The performShotToPoint() method describes all the required operations for shooting
     * including reading of the chosen point
     *
     * @param coordX for coordinate x
     * @param coordY for coordinate y
     * @param field  for game field
     * @return 0 if missed the target, 1 if chosen cell has already been shot, 2 if one staged ship was drowned
     * 3 if the multistaged ship was damaged, 4 if the multistaged ship was drowned
     */
    private int performShotToPoint(int coordX, int coordY, Field field) {
        System.out.println("\nPlease enter coordX and coordY coordinate from 1 to 10:");
        int[] point = new int[2];
        point = readCoordinateToShot();
        coordX = point[0] - 1;
        coordY = point[1] - 1;
        System.out.print("\nShots fired! ");

        if (field.getIsShotCell(coordX, coordY)) {
            System.out.print("The cell has already been shot!");
            return 1;
        } else {
            field.setIsShotCell(coordX, coordY);
            if (field.getIsShipCell(coordX, coordY)) {
                System.out.println("GOOD shot! Bull's eye!");
                if (!field.isElseShipCells(coordX, coordY)) {
                    System.out.print("The one-staged ship was drowned!");
                    field.setIsBusyArea(coordX, coordY, false, field.oneStaged1);
                    --shipCells;
                    return 2;
                } else if (field.isElseUnshotShipCells(coordX, coordY)) {
                    System.out.print("The ship is drowning!");
                    --shipCells;
                    return 3;
                } else {
                    System.out.print("The multi-staged ship was drowned!");
                    field.setIsBusyArea(coordX, coordY, false, field.oneStaged1);
                    --shipCells;
                    return 4;
                }
            } else {
                System.out.println("MISSED the target!");
                return 0;
            }
        }
    }

    /**
     * The readCoordinateToShot() method describes communication with the player to get coordinates of the point
     * where respectable player wants to shoot
     *
     * @return array of 2 coordinates
     */
    private int[] readCoordinateToShot() {
        int[] coordinates = new int[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                coordinates[0] = Integer.parseInt(reader.readLine());
                coordinates[1] = Integer.parseInt(reader.readLine());

                if ((coordinates[0] > 0 && coordinates[0] <= Field.getLengthOfField())
                        && coordinates[1] > 0 && coordinates[1] <= Field.getLengthOfField()) {
                    break;
                } else {
                    System.out.println("Please, don't be a retard and re-enter the point(s) correctly");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("BufferedReader IOException in gameplay.Main.main!");
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
                System.err.println("The entered value is not a number. Enter the point again!");
            }
        }
        return coordinates;
    }
}
