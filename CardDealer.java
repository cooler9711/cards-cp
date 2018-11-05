/*******************************
Card Dealer
JAVA SWING/AWT/JOPTIONPANE Version.
Created by Mr. Perrine
February 12, 2017
********************************/

/*******************************
Card Dealer deals out the number
of cards determined by you. The cards
are either dealt out on separate 
dialog panes and/or all the cards are 
displayed on a single pane. A single 
sound file, shuffling, is also included.
The console also shows the cards,
values and status of the arrays. Only
the player's hand is dealt out, but 
with some modifications, this engine
can be entirely GUI-based and used as 
the precursor to any card game. 
See version CardDealerJFX for JavaFX version.
********************************/

import java.util.*;
import javax.swing.*;
import java.awt.*;
import sun.audio.*;
import java.io.*;

public class CardDealer{

 public static void main(String args[]) throws Exception{

  //Scanner kb = new Scanner(System.in); //for console

  String[] cards = {
   "AceH:1:10",
   "2H:2",
   "3H:3",
   "4H:4",
   "5H:5",
   "6H:6",
   "7H:7",
   "8H:8",
   "9H:9",
   "10H:10",
   "JH:10",
   "QH:10",
   "KH:10",
   "AceD:1:10",
   "2D:2",
   "3D:3",
   "4D:4",
   "5D:5",
   "6D:6",
   "7D:7",
   "8D:8",
   "9D:9",
   "10D:10",
   "JD:10",
   "QD:10",
   "KD:10",
   "AceS:1:10",
   "2S:2",
   "3S:3",
   "4S:4",
   "5S:5",
   "6S:7",
   "7S:7",
   "8S:8",
   "9S:9",
   "10S:10",
   "JS:10",
   "QS:10",
   "KS:10",
   "AceC:1:10",
   "2C:2",
   "3C:3",
   "4C:4",
   "5C:5",
   "6C:6",
   "7C:7",
   "8C:8",
   "9C:9",
   "10C:10",
   "JC:10",
   "QC:10",
   "KC:10"
  };//add Jokers if needed
  ArrayList <String> myHand=new ArrayList<String>();
  ArrayList <String> computerHand=new ArrayList<String>();
  
//added each card to an array list

  ArrayList < String > deck = new ArrayList < String > ();
  for (String insert: cards) {
   deck.add(insert);
  }
  System.out.println(deck);
  
  Scanner option=new Scanner (System.in);
  //System.out.println("How many cards do you want to deal out?");//for console prompt
  String dealOut=(String)JOptionPane.showInputDialog(null,"Number of cards to deal:",
                              "CARD DEALER",
                          JOptionPane.PLAIN_MESSAGE,null,
                          null,null);
  int deal=Integer.parseInt(dealOut);
  //int dealOut=option.nextInt();//for console prompt

  
selectCards(deal,deck, myHand, computerHand);

//the cards are dealt out

}

public static void selectCards(int dealOut, ArrayList <String> deck, ArrayList <String> myHand, ArrayList <String> computerHand){

int PTotal=0; //initializes total points of cards by value
int cPTotal=0;
for(int numCards=0;numCards<dealOut;numCards++){//loops the number of times you wanted dealt
int n=numCards+1;//increments the title of each card by 1
Collections.shuffle(deck);
  //int deal = new Random().nextInt(deck.size() - 1); //randomly selects the index of the deck array using randomizer
  
     
  System.out.println("Your cards are: "+deck.get(numCards).split(":")[0]);
  System.out.println("The Computer's cards are: "+deck.get(numCards).split(":")[0]);

/**************************************************************/
/***********DISPLAYS EACH CARD ON SEPARATE WINDOWS*************/
/**************************************************************/

// ImageIcon icon=new ImageIcon(CardGameEnginePLUSPLUS.class.getResource("/cards/"+deck.get(numCards).split(":")[0]+".gif"));
// 
// JLabel label=new JLabel(icon);
// 
// 
// JDialog dialog=new JDialog();
// //dialog.setUndecorated(true);
// dialog.getRootPane().setOpaque(false);
// dialog.setTitle("Card "+n);
// dialog.add(label);
// dialog.setSize(125,150);
// dialog.setModal(false);
// dialog.setVisible(true);
/**************************************************************/

  myHand.add(deck.get(numCards));
    PTotal =PTotal+ Integer.parseInt(deck.get(numCards).split(":")[1]);//adds up the total of the cards dealt out
  deck.remove(deck.get(numCards));
  
  computerHand.add(deck.get(numCards));
    cPTotal =cPTotal+ Integer.parseInt(deck.get(numCards).split(":")[1]);//adds up the total of the cards dealt out
  deck.remove(deck.get(numCards));

  
n++;//increments n to the next value

}//END OF FOR LOOP
System.out.println(myHand);

  System.out.println(PTotal);
  System.out.println(deck);
  
System.out.println(computerHand);

  System.out.println(cPTotal);
  System.out.println(deck);



/**************************************************************/
/***************DISPLAYS ALL CARDS ON SINGLE WINDOW*************/
/**************************************************************/

 JPanel panel=new JPanel();

 
 for(String u:myHand){
 ImageIcon icon=new ImageIcon(CardDealer.class.getResource("/cards_gifs/"+u.split(":")[0]+".gif"));
 panel.add(new JLabel(icon));
 
 }
 
 ImageIcon sep=new ImageIcon(CardDealer.class.getResource("/separator.gif"));
 panel.add(new JLabel(sep));
 
 for(String u:computerHand){
 ImageIcon icon=new ImageIcon(CardDealer.class.getResource("/cards_gifs/"+u.split(":")[0]+".gif"));
 panel.add(new JLabel(icon));
 
 }

 
 JOptionPane.showMessageDialog(null,panel,"My Hand | Computer Hand",JOptionPane.PLAIN_MESSAGE,null);
 

/**************************************************************/
}//END OF METHOD
   }
