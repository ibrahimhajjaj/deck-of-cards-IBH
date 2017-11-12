package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {

    private int id;
    private boolean matched = false;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean getMatched() {
        return this.matched;
    }

    public Card() {
        setFont(new Font("Bold", 35, 35));
        setBackground(Color.lightGray);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\IbrahimHajjaj\\Desktop\\IBH\\src\\Game\\data\\backPhoto.png"));

            this.setIcon(new ImageIcon(image));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
