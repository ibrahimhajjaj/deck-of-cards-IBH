

package Game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import javax.swing.ImageIcon;
import static java.util.Collections.shuffle;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.applet.Applet;
import java.awt.image.*;
import java.net.URL;
import javax.imageio.*;

public class Board extends JFrame{

    Container PaneCont;
    JPanel pane;

    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
    private JButton newgame;
    private JButton shullf;
    public List<Integer> cardVals = new ArrayList<Integer>();
    public List<Image> imgaes = new ArrayList<Image>();



    public Board(){
        super("== Card == ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        newgame =new JButton("New Game");
        add(newgame);
        
        
        setLayout(new FlowLayout());
        shullf =new JButton("Shullf");
        add(shullf);

        newgame.addActionListener(A2);
        shullf.addActionListener(shuf);
        
        
        PaneCont = getContentPane(); 
        
        pane= new JPanel();
        pane.setBorder(new BevelBorder(10));
        pane.setBackground(Color.yellow);
        pane.setLayout(new GridLayout(6,9,9,9));
        
        PaneCont.add(pane);
        

        /*
         * C:\\Users\\IbrahimHajjaj\\Desktop\\IBH\\src\\Game\\data\\backPhoto.png
        */
        int pairs = 27;
        List<Card> cardsList = new ArrayList<Card>();

        for (int i = 1; i <= pairs; i++){
            cardVals.add(i);
            cardVals.add(i);   }
        
        Collections.shuffle(cardVals);

        

        for (int val : cardVals){

            Card c = new Card();
            c.setId(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                   
                   
						doTurn();
                }
               
            });
            cardsList.add(c);   }
        
        this.cards = cardsList;
        //set up the timer
        t = new Timer(750, (ActionEvent ae) -> {
            checkCards();  });
        t.setRepeats(false);

        //set up the board itself
         
        
        for (Card c : cards){
            pane.add(c);
        }    
        
        
    }

    public void doTurn() {
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setIcon(null);
            c1.setBackground(Color.white);
             c1.setText(""+c1.getId()); 








        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setIcon(null);
             c2.setBackground(Color.white);
              c2.setText(String.valueOf(c2.getId()));
            
                
            



          
            t.start();
            
        }
    }
    




    
    
 
  

	public void checkCards(){
        if (c1.getId() == c2.getId()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setMatched(true); //flags the button as having been matched
            c2.setMatched(true);
        if (this.isGameWon()){
             String str =  JOptionPane.showInputDialog( "You win! \nAgain ? anykey-no");
             if (str.toUpperCase().equals("NO")) 
                System.exit(0);  
             else
                 NewGame(Board.this);
                
            }
        }

        else{
            c1.setBackground(Color.RED);
            c2.setBackground(Color.RED);
            c1.setIcon(null);
        }
        c1 = null;
        c2 = null;
    }
    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }
    
        public static void NewGame(Board b) {
        b.setVisible(false);
        b = new Board();
        b.setPreferredSize(new Dimension(1050,650));
        b.setLocation(300, 80);
        b.pack();
        b.setResizable(false);
        b.setVisible(true);  }
        
        

    ActionListener A2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NewGame(Board.this);
            }
        };
    
        
     
         ActionListener shuf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
            	
            	
                             
            
            }
        };


        
     
     

}