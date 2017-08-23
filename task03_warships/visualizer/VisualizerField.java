package visualizer;

import gameObjects.Field;

public class VisualizerField implements Visualazible {
    private final static int LENGTH_OF_FIELD = 10;
    private char seaCell = '~';
    private char shotSeaCell = 'o';
    private char shotShipCell = 'X';

    /**
     * The drawInitialField() method draws initial game field filled with seaCells only
     *
     * @param field for game field
     */
    public void drawInitialField(Field field) {
        System.out.println("\n  Oy  1 2 3 4 5 6 7 8 9 10");
        System.out.print("Ox");
        for (int i = 0; i < LENGTH_OF_FIELD; i++) {
            if ((i + 1) == 10) System.out.print("\n " + (i + 1) + "  ");
            else System.out.print("\n " + (i + 1) + "   ");
            for (int j = 0; j < LENGTH_OF_FIELD; j++) {
                System.out.print(" " + seaCell);
            }
        }
    }

    /**
     * The drawField() method draws game field during the game process after each turn
     *
     * @param field for game field
     */
    public void drawField(Field field) {
        System.out.println("\n  Oy  1 2 3 4 5 6 7 8 9 10");
        System.out.print("Ox");
        for (int i = 0; i < LENGTH_OF_FIELD; i++) {
            if ((i + 1) == 10) System.out.print("\n " + (i + 1) + "  ");
            else System.out.print("\n " + (i + 1) + "   ");
            for (int j = 0; j < LENGTH_OF_FIELD; j++) {
                if (field.getIsShotCell(i, j) && field.getIsShipCell(i, j)) {
                    System.out.print(" " + shotShipCell);
                } else if (field.getIsShotCell(i, j)) {
                    System.out.print(" " + shotSeaCell);
                } else {
                    System.out.print(" " + seaCell);
                }
            }
        }
    }
}
