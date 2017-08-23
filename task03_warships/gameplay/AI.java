package gameplay;

/**
 * The class AI is about randomizing ships coordinates
 */
public class AI {

    /**
     * The getRandomizedIsVertical() method ramdomizes isVertical value
     * and thus makes ship orientation vertical of horizontal
     *
     * @return randomized boolean with fair 50%-50% probability
     */
    public boolean getRamdomizedIsVertical() {
        int result = (int) (Math.random() * 10);
        if (result < 5) return true;
        else return false;
    }

    /**
     * The getRandomizedTopCoordX() method ramdomizes position of the ship at the axis X coordX
     *
     * @return randomized boolean with fair 50%-50% probability
     */
    public int getRandomizedTopCoordX(int length) {
        return (int) (Math.random() * (10 - length));
    }

    /**
     * The getRandomizedTopCoordX() method ramdomizes position of the ship at the axis X coordX
     *
     * @return randomized boolean with fair 50%-50% probability
     */
    public int getRandomizedTopCoordY(int length) {
        return (int) (Math.random() * (10 - length));
    }
}
