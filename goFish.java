import java.util.*;
import javax.swing.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.io.File;
import javax.sound.sampled.*;

public class goFish {

    public static ArrayList<String> myHand = new ArrayList<String>();
    public static ArrayList<String> compHand = new ArrayList<String>();
    public static ArrayList<String> compLay = new ArrayList<String>();
    public static ArrayList<String> myLay = new ArrayList<String>();
    public static ArrayList<String> deck = new ArrayList<String>();

    public static void main(String args[]) throws Exception {

        // Scanner kb = new Scanner(System.in); //for console

        String[] cards = { "AceB", "2B", "3B", "4B", "5B", "6B", "7B", "8B", "9B", "10B", "JB", "QB", "KB", "AceG",
                "2G", "3G", "4G", "5G", "6G", "7G", "8G", "9G", "10G", "JG", "QG", "KG", "AceO", "2O", "3O", "4O", "5O",
                "6O", "7O", "8O", "9O", "10O", "JO", "QO", "KO", "AceP", "2P", "3P", "4P", "5P", "6P", "7P", "8P", "9P",
                "10P", "JP", "QP", "KP" };// No Jokers needed

        // added each card to an array list

        for (String insert : cards) {
            deck.add(insert);
        }
        System.out.println(deck);

        // Scanner option = new Scanner(System.in);

        startGame(7);

        // the cards are dealt out

    }

    public static void startGame(int dealOut) throws Exception {

        for (int numCards = 0; numCards < dealOut; numCards++) {// loops the number of times you wanted dealt
            int n = numCards + 1;// increments the title of each card by 1
            Collections.shuffle(deck);
            // int deal = new Random().nextInt(deck.size() - 1); //randomly selects the
            // index of the deck array using randomizer

            System.out.println("Your cards are: " + deck.get(numCards).split(":")[0]);

            myHand.add(deck.get(numCards));
            deck.remove(deck.get(numCards));
            compHand.add(deck.get(numCards));
            System.out.println("The Computer's cards are: " + deck.get(numCards).split(":")[0]);
            deck.remove(deck.get(numCards));

            n++;// increments n to the next value

        }
        System.out.println(myHand);
        System.out.println(compHand);
        System.out.println(deck);

        JFrame frame = new JFrame();
        ImageIcon instructions = new ImageIcon("images/LilFish.png");
        JOptionPane.showMessageDialog(frame, null, "Rules Of The Game", JOptionPane.INFORMATION_MESSAGE, instructions);
        AudioInputStream input = AudioSystem.getAudioInputStream(new File("sounds/cardShuffle.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(input);
        clip.loop(0);
        Thread.sleep(0);

        Object[] opts = { "Ask for cards", "Put down cards", "Exit" };

        while (compHand.size() > 0 | myHand.size() > 0) {
            JPanel panel = new JPanel();

            for (String u : myHand) {
                ImageIcon icon = new ImageIcon(goFish.class.getResource("./cards_pngs/" + u.split(":")[0] + ".png"));
                panel.add(new JLabel(icon));
            }
            ImageIcon sep = new ImageIcon(goFish.class.getResource("./separator.gif"));
            panel.add(new JLabel(sep));
            for (String u : myLay) {
                ImageIcon icon = new ImageIcon(goFish.class.getResource("./cards_pngs/" + u.split(":")[0] + ".png"));
                panel.add(new JLabel(icon));
            }

            int cho = JOptionPane.showOptionDialog(null, panel, "go fish~~", JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            if (cho == 0) {
                AudioInputStream input2 = AudioSystem.getAudioInputStream(new File("sounds/ClickSound.wav"));
                Clip clip2 = AudioSystem.getClip();
                clip2.open(input2);
                clip2.loop(0);
                Thread.sleep(0);
                String response = (String) JOptionPane.showInputDialog(null,
                        "What card do you want to ask for? \n"
                                + "(Insert J, Q, K, and A for Jack, Queen, King, and Ace, respectively.)",
                        "Ask for card", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (response != null) {
                    System.out.print(response);
                    pullFromCompDeck(response);
                }

            } else if (cho == 1) {
                AudioInputStream input2 = AudioSystem.getAudioInputStream(new File("sounds/ClickSound.wav"));
                Clip clip2 = AudioSystem.getClip();
                clip2.open(input2);
                clip2.loop(0);
                Thread.sleep(0);
                String response = (String) JOptionPane.showInputDialog(null,
                        "What cards do you want to put down? \n"
                                + "(Insert jk, qn, kn, and a for Jack, Queen, King, and Ace, respectively.)",
                        "Put down cards", JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (response != null) {
                    System.out.print(response);
                    putDownMyCards(response);
                }
            } else if (cho == 2) {
                AudioInputStream input2 = AudioSystem.getAudioInputStream(new File("sounds/ClickSound.wav"));
                Clip clip2 = AudioSystem.getClip();
                clip2.open(input2);
                clip2.loop(0);
                Thread.sleep(0);
                System.exit(0);
            }
        }
    }

    public static void drawMyCard() {
        Collections.shuffle(deck);
        myHand.add(deck.get(0));
        deck.remove(deck.get(0));
    }

    public static void drawCompCard() {
        Collections.shuffle(deck);
        compHand.add(deck.get(0));
        deck.remove(deck.get(0));
    }

    public static void pullFromCompDeck(String cName) throws Exception {
        try {
            int fNum = Integer.parseInt(cName);
            System.out.println(" isn't a special card");
            // if this fails, that means that the card is a special card, aka a card that is
            // not normally a number, and it moves on to the catch statement.
            for (int i = 0; i < compHand.size(); i++) {
                if (compHand.get(i).contains(Integer.toString(fNum))) {
                    myHand.add(compHand.get(i));
                    System.out.println("added the card " + compHand.get(i));
                    compHand.remove(i);
                }
                System.out.println(compHand);
            }
        } catch (Exception ex) {
            System.out.println(" caught with exception " + ex);
            for (int i = 0; i < compHand.size(); i++) {
                if (compHand.get(i).contains(cName)) {
                    System.out.println("in loop with index of " + i);
                    myHand.add(compHand.get(i));
                    compHand.remove(i);
                }
            }
            System.out.println(compHand);
        }
    }

    public static void putDownMyCards(String cName) throws Exception {
        try {
            int fNum = Integer.parseInt(cName);
            System.out.println(" isn't a special card");
            // if this fails, that means that the card is a special card, aka a card that is
            // not normally a number, and it moves on to the catch statement.
            for (int i = 0; i < myHand.size(); i++) {
                if (myHand.get(i).contains(Integer.toString(fNum))) {
                    myLay.add(myHand.get(i));
                    System.out.println("added the card " + myHand.get(i));
                    myHand.remove(i);
                }
            }
            System.out.println(myLay);
        } catch (Exception ex) {
            System.out.println(" caught with exception " + ex);
            for (int i = 0; i < myHand.size(); i++) {
                if (myHand.get(i).contains(cName)) {
                    System.out.println("in loop with index of " + i);
                    myLay.add(myHand.get(i));
                    myHand.remove(i);
                }
            }
            System.out.println(myLay);
        }
    }
}