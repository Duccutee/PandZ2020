package PlantvsZombie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {
	
	static String name;
	static boolean press=false;
	BufferedImage menu,logo,p1,p0,p2,p7,p10,zb5,zb6,zb0,zb1,zb2,zb3,tag;

	public void paint(Graphics g) {
		
		try {
			menu = ImageIO.read(new File("ImageSource\\Menu\\menu7.jpg"));
			logo = ImageIO.read(new File("ImageSource\\Menu\\logo4.jpg"));
			p1 = ImageIO.read(new File("ImageSource\\Menu\\p1.png"));
			p0 = ImageIO.read(new File("ImageSource\\Menu\\p0.png"));
			p2 = ImageIO.read(new File("ImageSource\\Menu\\p2.png"));
			p7 = ImageIO.read(new File("ImageSource\\Menu\\p7.png"));
			p10 = ImageIO.read(new File("ImageSource\\Menu\\p10.png"));
			zb5 = ImageIO.read(new File("ImageSource\\Menu\\zb5.png"));
			zb6 = ImageIO.read(new File("ImageSource\\Menu\\zbd.png"));
			zb0 = ImageIO.read(new File("ImageSource\\Menu\\zb0.png"));
			zb1 = ImageIO.read(new File("ImageSource\\Menu\\zb1.png"));
			zb2 = ImageIO.read(new File("ImageSource\\Menu\\zb2.png"));
			zb3 = ImageIO.read(new File("ImageSource\\Menu\\zb9.png"));
			tag = ImageIO.read(new File("ImageSource\\Menu\\tag.png"));
			
		} 
	  catch (IOException e) {e.printStackTrace();}
		
		//g.drawImage(menu,0 ,0, null);
		g.drawImage(menu,0,0,null);
		g.drawImage(logo,400,150,null);
		g.drawImage(p10, 190, 270, null);
		g.drawImage(p7, 50, 270, null);
		g.drawImage(p1, 0, 375, null);
		g.drawImage(p2, 150, 370, null);
		
		g.drawImage(zb6, 950, 100, null);
		g.drawImage(p0, 30, 400, null);
		g.drawImage(zb5, 700, 0, null);
		g.drawImage(zb2, 900+100, 10, null);
		g.drawImage(zb0, 1000, 80, null);
		g.drawImage(zb1, 860, 100, null);
		
		g.drawImage(zb3, 950, 200, null);
		g.drawImage(tag, 0,-50, null);
		
		
		
		if(press == false) {
			g.setColor(Color.orange);
		    g.fillRect(360,490,455,50);
		
		    g.setColor(Color.black);
		    g.setFont(new Font ("Jokerman",Font.BOLD,30));
		    g.drawString("P r e s s  S P A C E  t o  s t a r t", 360,525);
		}
		else {
			g.setColor(Color.red);
			g.fillRect(360,490,455,50);
			
		    g.setColor(Color.white);
		    g.setFont(new Font ("Jokerman",Font.BOLD,30));
		    g.drawString("P r e s s  S P A C E  t o  s t a r t", 360,525);
		    
//		    TapVeDemo.setCurrentState(1);
//    		Timetest tt = new Timetest();
//			tt.start();
		}
		
		if(name == " " || name == null) Menu.name = " ";
		//else Menu.name = name;
		g.setColor(Color.white);
	    g.setFont(new Font ("Arial",Font.BOLD,25));
	    g.drawString("Welcome  "+name, 25,115);
	}

	public static void setName(String name) {
		Menu.name = name;
	}

	public static void setPress(boolean press) {
		Menu.press = press;
//		press=false;
	}

	public static boolean isPress() {
		return press;
	}
	
}
