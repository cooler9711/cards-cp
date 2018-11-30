//Program shows how to create a simple GUI
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class SimpleGui{
   public static void main(String[] args) throws Exception {
      JFrame frame = new JFrame();
      ImageIcon icon = new ImageIcon("images/BMO_dancing.gif");    
      //simple showMessage GUI
      JOptionPane.showMessageDialog(frame, "Inside text" , "Moi", JOptionPane.INFORMATION_MESSAGE, icon);
      //Input GUI
      Object[] options = {"Lorum", "Ipsum", "Dolor"};
      String response = (String)JOptionPane.showInputDialog(frame, "Inside Text", "Window name", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
      
      int value = (int)JOptionPane.showOptionDialog(frame, "Inside text", "Window name", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, icon, options, null);
      if (value == 0) {
         System.out.println("You have selected Lorum");
         System.out.println("You have selected Dolor");
         System.out.println("You have selected Ipsum");
      }
      else if (value == 1) {
         System.out.println("You have selected Ipsum");
         
      }
   
   }
}