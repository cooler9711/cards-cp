import java.util.*;
import javax.swing.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;

public class goFish {

    public static void main(String args[]) throws Exception {

        // Scanner kb = new Scanner(System.in); //for console

        String[] cards = { "AceB", "2B", "3B", "4B", "5B", "6B", "7B", "8B", "9B", "10B", "JH", "QH", "KH", "AceD",
                "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AceS", "2S", "3S", "4S", "5S",
                "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AceC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
                "10C", "JC", "QC", "KC" };//No Jokers needed
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
            ArrayList<String> compHand) throws Exception {

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
         JFrame frame = new JFrame();
        ImageIcon instructions = new ImageIcon("images/LilFish.png");
       JOptionPane.showMessageDialog(frame, null , "Rewls ov de gaim", JOptionPane.INFORMATION_MESSAGE, instructions);
        for (String u : myHand) {
            ImageIcon icon = new ImageIcon(goFish.class.getResource("./cards_gifs/" + u.split(":")[0] + ".gif"));
            panel.add(new JLabel(icon));
        }

        Object[] opts = { "Ask for cards", "Put down cards","Exit" };

        while (compHand.size() > 0 | myHand.size() > 0) {

            int cho = JOptionPane.showOptionDialog(null, panel, "go fish~~", JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            if (cho == 0) {
                String response=(String)JOptionPane.showInputDialog(null,
                        "What card do you want to ask for? \n"
                                + "(Insert jk, qn, kn, and a for Jack, Queen, King, and Ace, respectively.)",
                        "Ask for card", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        System.out.print(response);
            } else if (cho == 1) {
                String response=(String)JOptionPane.showInputDialog(null,
                        "What cards do you want to put down? \n"
                                + "(Insert jk, qn, kn, and a for Jack, Queen, King, and Ace, respectively.)",
                        "Put down cards", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        System.out.print(response);
            } else if (cho == 2) {
               System.exit(0);
            }
        }
    }

    public static ArrayList<String> drawCard(ArrayList<String> deck, ArrayList<String> hand) {
        Collections.shuffle(deck);
        hand.add(deck.get(0));
        deck.remove(deck.get(0));
        return deck;
    }

    public static void checkCompDeck(String cName) throws Exception {
        boolean isAce = false;
        boolean isJack = false;
        boolean isQueen = false;
        boolean isKing = false;
        boolean isSpecial = false;
        try {
            int fNum = Integer.parseInt(Character.toString(cName.charAt(0)));
            // if this fails, that means that the card is a special card, aka a card that is
            // not normally a number, and it moves on to the catch statement.
        } catch (Exception ex) {
            isSpecial = true;
            switch (cName.charAt(0)) {
            case 'A':
                isAce = true;
            case 'J':
                isJack = true;
            case 'Q':
                isQueen = true;
            case 'K':
                isKing = true;
            }
        }
        
    }
}