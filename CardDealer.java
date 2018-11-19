import java.util.*;
import javax.swing.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;

public class CardDealer {

    public static void main(String args[]) throws Exception {

        // Scanner kb = new Scanner(System.in); //for console

        String[] cards = { "AceH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AceD",
                "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AceS", "2S", "3S", "4S", "5S",
                "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AceC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
                "10C", "JC", "QC", "KC" };// add Jokers if needed
        ArrayList<String> myHand = new ArrayList<String>();
        ArrayList<String> compHand = new ArrayList<String>();

        // added each card to an array list

        ArrayList<String> deck = new ArrayList<String>();
        for (String insert : cards) {
            deck.add(insert);
        }
        System.out.println(deck);

        // Scanner option = new Scanner(System.in);

        startGame(7, deck, myHand, compHand);

        // the cards are dealt out

    }

    public static void startGame(int dealOut, ArrayList<String> deck, ArrayList<String> myHand,
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
                                + "(do jk, qn, kn, and a for jack, queen, king, and ace, respectively.)",
                        "ask for card", JOptionPane.PLAIN_MESSAGE, null, null, null);
            } else if (cho == 1) {
                JOptionPane.showInputDialog(null,
                        "what cards do you want to put down? \n"
                                + "(do jk, qn, kn, and a for jack, queen, king, and ace, respectively.)",
                        "put down cards", JOptionPane.PLAIN_MESSAGE, null, null, null);
            }
        }
    }

    public static String drawCard(ArrayList<String> deck, ArrayList<String> hand) {
        Collections.shuffle(deck);
        hand.add(deck.get(0));
        deck.remove(deck.get(0));
        return deck;
    }

    public static void checkCompDeck(String cName) {
        boolean isAce;
        boolean isSpecial;
        try {
            Integer.parseInt((String) cName.charAt(0));
            isSpecial = false;
        } catch (Exception ex) {
            isSpecial = true;
            if (cName.charAt(2) == "e")
                isAce = true;
            else
                isAce = false;
        }
    }
}
