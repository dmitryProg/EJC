package gameplay;

public class Main {
    public static void main(String[] args) {
        Round round = new Round();
        System.out.println("Welcome to the game, respectable player! Please note there's a tiny lucky possibility "
                + "the enemy fleet will be drowned before your even notice it!");
        round.performRound();
    }
}
