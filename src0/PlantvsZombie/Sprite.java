package PlantvsZombie;
import javax.swing.JPanel;
import java.awt.*;

public class Sprite extends JPanel {
  protected int x; 
  protected int y; 
  protected int width; 
  protected int height;
  
  public Sprite(int x, int y, int width, int height){
    this.x=x;
    this.y=y;
    this.width=width;
    this.height=height;
  }
  public int getX() {return x;}
  public int getY(){ return y;}
  public int getWidth(){ return width;}
  public int getHeight(){ return height;}
  public void setWidth(int width) {this.width = width;}
  public void setHeight(int height) {this.height = height;}

  public Rectangle getBound(){
    return new Rectangle(x,y,width,height);
  }
  public void drawBound(Graphics g) {
	  g.drawRect(x,y,width,height);
  }
  }