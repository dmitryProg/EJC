package gameObjects;

class Ship {
    private int totalLength;
    private int aliveLength = totalLength;
    private int topCoordX;
    private int topCoordY;
    private boolean isVertical = true;

    Ship(int totalLength) {
        this.totalLength = totalLength;
        this.aliveLength = totalLength;
    }

    /**
     * The setPosition() method sets position of the ship according to the parameters
     *
     * @param isVertical for vertical statement
     * @param topCoordX  for coordinate x of ships' head
     * @param topCoordY  for coordinate y of ships' head
     */
    void setPosition(boolean isVertical, int topCoordX, int topCoordY) {
        if (!isVertical) {
            this.isVertical = false;
            while ((Field.getLengthOfField() - topCoordX - this.totalLength) < 1) {
                --topCoordX;
                System.out.print("Changing position X! ");
            }
        } else {
            while ((Field.getLengthOfField() - topCoordY - this.totalLength) < 1) {
                --topCoordY;
                System.out.print("Changing position Y! ");
            }
        }
        this.topCoordX = topCoordX;
        this.topCoordY = topCoordY;
    }

    /**
     * The getTotalLength method returns the value of totalLength of the ship
     *
     * @return totalLength
     */
    int getTotalLength() {
        return this.totalLength;
    }

    /**
     * The getIsVertical() method returns the value of isVertical property of the ship
     *
     * @return isVertical
     */
    boolean getIsVertical() {
        return this.isVertical;
    }
}
