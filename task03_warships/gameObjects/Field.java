package gameObjects;

import gameplay.AI;
import visualizer.VisualizerField;

/**
 * The class is about game sea field and it's properties
 */
public class Field {
    private final static int LENGTH_OF_FIELD = 10;
    private final static int WIDTH_0F_FIELD = 10;
    private final static int MAX_CREATION_TIMES = 50;
    public Ship oneStaged1 = new Ship(1);
    private Ship fourStaged = new Ship(4);//unite in one module
    private Ship threeStaged1 = new Ship(3);
    private Ship threeStaged2 = new Ship(3);
    private Ship twoStaged1 = new Ship(2);
    private Ship twoStaged2 = new Ship(2);
    private Ship twoStaged3 = new Ship(2);
    private Ship oneStaged2 = new Ship(1);
    private Ship oneStaged3 = new Ship(1);
    private Ship oneStaged4 = new Ship(1);
    private VisualizerField visualizerField = new VisualizerField();
    private boolean[][] isShotField = new boolean[LENGTH_OF_FIELD][WIDTH_0F_FIELD];
    private boolean[][] isShipField = new boolean[LENGTH_OF_FIELD][WIDTH_0F_FIELD];
    private boolean[][] isBusyField = new boolean[LENGTH_OF_FIELD][WIDTH_0F_FIELD];

    public static int getLengthOfField() {
        return LENGTH_OF_FIELD;
    }

    public boolean getIsShotCell(int coordX, int coordY) {
        return this.isShotField[coordX][coordY];
    }

    public void setIsShotCell(int coordX, int coordY) {
        this.isShotField[coordX][coordY] = true;
    }

    private boolean getIsBusyCell(int coordX, int coordY) {
        return this.isBusyField[coordX][coordY];
    }

    private boolean getIsBusyArea(int coordX, int coordY) {
        if (coordX > 9) {
            coordX = 8;
        }
        if (coordX < 1) {
            coordX = 1;
        }
        if (coordY > 9) {
            coordY = 8;
        }
        if (coordY < 1) {
            coordY = 1;
        }
        if ((getIsBusyCell(coordX, coordY) || getIsBusyCell(coordX, coordY - 1)
                || getIsBusyCell(coordX - 1, coordY - 1) || getIsBusyCell(coordX - 1, coordY)
                || getIsBusyCell(coordX - 1, coordY + 1) || getIsBusyCell(coordX, coordY + 1)
                || getIsBusyCell(coordX + 1, coordY + 1) || getIsBusyCell(coordX + 1, coordY)
                || getIsBusyCell(coordX + 1, coordY - 1))) {
            return true;
        } else return false;
    }

    public void setIsBusyArea(int coordX, int coordY, boolean isVertical, Ship ship) {
        if (coordX > 9) {
            coordX = 8;
        }
        if (coordX < 1) {
            coordX = 1;
        }
        if (coordY > 9) {
            coordY = 8;
        }
        if (coordY < 1) {
            coordY = 1;
        }
        if (isVertical) {
            for (int i = 0; i < ship.getTotalLength(); i++) {
                if (coordY > 0) setIsBusyCell(coordX, coordY + i - 1);
                if (coordX > 0 && coordY > 0) setIsBusyCell(coordX - 1, coordY + i - 1);
                if (coordX > 0) setIsBusyCell(coordX - 1, coordY + i);
                if (coordX > 0 && coordY < 9) setIsBusyCell(coordX - 1, coordY + i + 1);
                if (coordY < 9) setIsBusyCell(coordX, coordY + i + 1);
                if (coordX < 9 && coordY < 9) setIsBusyCell(coordX + 1, coordY + i + 1);
                if (coordX < 9) setIsBusyCell(coordX + 1, coordY + i);
                if (coordX < 9 && coordY > 0) setIsBusyCell(coordX + 1, coordY + i - 1);
            }
        } else {
            for (int i = 0; i < ship.getTotalLength(); i++) {
                if (coordY > 0) setIsBusyCell(coordX + i, coordY - 1);
                if (coordX > 0 && coordY > 0) setIsBusyCell(coordX - 1 + i, coordY - 1);
                if (coordX > 0) setIsBusyCell(coordX - 1 + i, coordY);
                if (coordX > 0 && coordY < 9) setIsBusyCell(coordX - 1 + i, coordY + 1);
                if (coordY < 9) setIsBusyCell(coordX + i, coordY + i + 1);
                if (coordX < 9 && coordY < 9) setIsBusyCell(coordX + 1 + i, coordY + 1);
                if (coordX < 9) setIsBusyCell(coordX + 1 + i, coordY);
                if (coordX < 9 && coordY > 0) setIsBusyCell(coordX + 1 + i, coordY - 1);
            }
        }

    }

    private void setIsBusyCell(int coordX, int coordY) {
        this.isBusyField[coordX][coordY] = true;
    }

    public boolean getIsShipCell(int coordX, int coordY) {
        return this.isShipField[coordX][coordY];
    }

    private void setIsShipCell(int coordX, int coordY) {
        this.isShipField[coordX][coordY] = true;
    }

    public boolean isElseShipCells(int coordX, int coordY) {
        if (coordX == 1 || coordY == 1) {
            return isShipField[coordX + 1][coordY] || isShipField[coordX][coordY + 1];
        }
        if (coordX == 0 || coordY == 0) {
            return isShipField[coordX + 1][coordY] || isShipField[coordX][coordY + 1];
        }
        if (coordX == 9 || coordY == 9) {
            return isShipField[coordX - 1][coordY] || isShipField[coordX][coordY - 1];
        }
        return isShipField[coordX - 1][coordY] || isShipField[coordX][coordY - 1] ||
                isShipField[coordX + 1][coordY] || isShipField[coordX][coordY + 1];
    }

    public boolean isElseUnshotShipCells(int coordX, int coordY) {
        if ((!isShotField[coordX - 1][coordY] && isShipField[coordX - 1][coordY]) ||
                (!isShotField[coordX][coordY - 1] && isShipField[coordX][coordY - 1]) ||
                (!isShotField[coordX + 1][coordY] && isShipField[coordX + 1][coordY]) ||
                (!isShotField[coordX][coordY + 1] && isShipField[coordX][coordY + 1]))
            return true;
        else return false;
    }

    private void setShipPosition(Ship ship) {
        AI gameAI = new AI();
        int creationCounter = 0;
        boolean isShipVertical;
        int coordX;
        int coordY;
        do {
            isShipVertical = gameAI.getRamdomizedIsVertical();
            coordX = gameAI.getRandomizedTopCoordX(ship.getTotalLength());
            coordY = gameAI.getRandomizedTopCoordY(ship.getTotalLength());
            creationCounter++;
            if (creationCounter == MAX_CREATION_TIMES) {
                System.out.println("FLEET should be relocated!");
                setFleetPosition();
            }
        }
        while (getIsBusyAreaForShip(coordX, coordY, ship.getTotalLength(), ship.getIsVertical()));

        if (!isShipVertical) {
            for (int i = 0; i < ship.getTotalLength(); i++) {
                setIsShipCell(coordX + i, coordY);
                setIsBusyCell(coordX + i, coordY);
            }
        } else {
            for (int i = 0; i < ship.getTotalLength(); i++) {
                setIsShipCell(coordX, coordY + i);
                setIsBusyCell(coordX + i, coordY);
            }
        }
        ship.setPosition(isShipVertical, coordX, coordY);
        System.out.println("\nI'm a " + ship.getTotalLength() + "-staged ship!");
    }

    private boolean getIsBusyAreaForShip(int coordX, int coordY, int totalLength, boolean isVertical) {
        if (isVertical) {
            for (int i = 0; i < totalLength; i++) {
                if (getIsBusyArea(coordX, coordY + i))
                    return true;
            }
        } else {
            for (int i = 0; i < totalLength; i++) {
                if (getIsBusyArea(coordX + i, coordY))
                    return true;
            }
        }
        return false;
    }

    public void setFleetPosition() {
        this.setShipPosition(fourStaged);
        this.setShipPosition(threeStaged1);
        this.setShipPosition(threeStaged2);
        this.setShipPosition(twoStaged1);
        this.setShipPosition(twoStaged2);
        this.setShipPosition(twoStaged3);
        this.setShipPosition(oneStaged1);
        this.setShipPosition(oneStaged2);
        this.setShipPosition(oneStaged3);
        this.setShipPosition(oneStaged4);
    }

    public void visualizeField() {
        visualizerField.drawField(this);
    }

    public void visualizeInitialField() {
        visualizerField.drawInitialField(this);
    }
}
