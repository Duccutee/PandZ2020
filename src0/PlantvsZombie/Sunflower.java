package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sunflower extends Sprite {
	
	private BufferedImage sunflowerImage;
	private int hp=100,create=3000;
	
	ArrayList<Sun> suns = TapVeDemo.getSunList();
	
	public Sunflower(int x, int y, int width, int height) {
		super(x, y, width, height);}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void Loop() { //loop to create sun again and again
		create--;
		if(create<=0) {
			TapVeDemo.addSun(new Sun(this.x , this.y , this.y+30));
			this.create=3000;
		}
	}
	  public void paint(Graphics g){
		    g.drawImage(getSunFlowerImage(),x,y,null);} 

		   public Image getSunFlowerImage(){
		    ImageIcon icon1 = new ImageIcon("ImageSource\\sunflower.gif");
		    return icon1.getImage();}
	
	public void paint1(Graphics f) {
//		f.setColor(Color.red);
//		f.fillOval(x,y,50,50);
		
		try {
			sunflowerImage= ImageIO.read(new File("ImageSource\\sunflower.gif"));
			f.drawImage(sunflowerImage,x,y,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Hp (int damageOfZombie) {
		hp = hp - damageOfZombie;}
	
	
}