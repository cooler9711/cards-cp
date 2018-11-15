import java.util.*;
import javax.swing.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;

public class CardDealer {

    public static void main(String args[]) throws Exception {

        // Scanner kb = new Scanner(System.in); //for console

        String[] cards = { "AceH:1:10", "2H:2", "3H:3", "4H:4", "5H:5", "6H:6", "7H:7", "8H:8", "9H:9", "10H:10",
                "JH:10", "QH:10", "KH:10", "AceD:1:10", "2D:2", "3D:3", "4D:4", "5D:5", "6D:6", "7D:7", "8D:8", "9D:9",
                "10D:10", "JD:10", "QD:10", "KD:10", "AceS:1:10", "2S:2", "3S:3", "4S:4", "5S:5", "6S:7", "7S:7",
                "8S:8", "9S:9", "10S:10", "JS:10", "QS:10", "KS:10", "AceC:1:10", "2C:2", "3C:3", "4C:4", "5C:5",
                "6C:6", "7C:7", "8C:8", "9C:9", "10C:10", "JC:10", "QC:10", "KC:10" };// add Jokers if needed
        ArrayList<String> myHand = new ArrayList<String>();
        ArrayList<String> compHand = new ArrayList<String>();

        // added each card to an array list

        ArrayList<String> deck = new ArrayList<String>();
        for (String insert : cards) {
            deck.add(insert);
        }
        System.out.println(deck);

        // Scanner option = new Scanner(System.in);

        selectCards(7, deck, myHand, compHand);

        // the cards are dealt out

    }

    public static void selectCards(int dealOut, ArrayList<String> deck, ArrayList<String> myHand,
            ArrayList<String> compHand) {

        for (int numCards = 0; numCards < dealOut; numCards++) {// loops the number of times you wanted dealt
            int n = numCards + 1;// increments the title of each card by 1
            Collections.shuffle(deck);
            // int deal = new Random().nextInt(deck.size() - 1); //randomly selects the
            // index of the deck array using randomizer

            System.out.println("Your cards are: " + deck.get(numCards).split(":")[0]);
            System.out.println("The Computer's cards are: " + deck.get(numCards).split(":")[0]);

            myHand.add(deck.get(numCards));
            deck.remove(deck.get(numCards));
            compHand.add(deck.get(numCards));
            deck.remove(deck.get(numCards));

            n++;// increments n to the next value

        }
        System.out.println(myHand);
        System.out.println(compHand);
        System.out.println(deck);

        JPanel panel = new JPanel();

        for (String u : myHand) {
            ImageIcon icon = new ImageIcon(CardDealer.class.getResource("./cards_gifs/" + u.split(":")[0] + ".gif"));
            panel.add(new JLabel(icon));
        }

        Object[] opts = { "ask for cards", "put down cards" };

        while (compHand.size() > 0 | myHand.size() > 0) {

            int cho = JOptionPane.showOptionDialog(null, panel, "go fish~~", JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            if (cho == 0) {
                JOptionPane.showInputDialog(null,
                        "what card do you want to ask for? \n"
                                + "(do jk, qn, kn, and a for jack, queen, king, and ace, respectively.",
                        "ask for card", JOptionPane.PLAIN_MESSAGE, null, null, null);
            }
        }
    }

    public static void drawCard(ArrayList<String> deck, ArrayList<String> hand) {
        Collections.shuffle(deck);
        hand.add(deck.get(0));
        deck.remove(deck.get(0));
    }
}
