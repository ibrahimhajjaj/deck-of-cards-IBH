
package Game;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame.*;
import javax.swing.JPanel;


public class Game{
    public static void main(String[] args){
        Board c = new Board();
        c.setPreferredSize(new Dimension(1050,650)); //need to use this instead of setSize
        c.setLocation(300, 80);
        c.pack();
        
        c.setResizable(false);
        c.setVisible(true);
                
    }

}
