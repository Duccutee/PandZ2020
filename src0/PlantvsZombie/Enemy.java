package PlantvsZombie;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;

public class Enemy extends Sprite{
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);}

    public void draw(Graphics g){
        g.drawImage(getEnemyImage(),x,y,null);
       // g2d.draw(getBound());
    }
    public Image getEnemyImage(){
        ImageIcon icon = new ImageIcon("D:\\ImageSource\\normalzombie1.png");
        return icon.getImage();
    }
  
}
