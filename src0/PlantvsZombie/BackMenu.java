package PlantvsZombie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BackMenu extends JPanel implements Runnable, ActionListener{
	  private JButton backToGame, basicGarden, oldPlace, kungFu, springDay, jungle ;
	  private BufferedImage backGroundMenu;
	  
	  
	public BackMenu() {
		JMenuItem changeBg = new JMenuItem("Change Background");
		backToGame = new JButton("BACK TO GAME");
		basicGarden = new JButton("Basic Garden");
		oldPlace = new JButton("Old Place");
		kungFu = new JButton("Kung Fu");
		springDay = new JButton("Spring Day");
		jungle = new JButton("Jungle");
		
		backToGame.setBackground(new Color(128, 16, 182));
		backToGame.setFont(new Font ("Algerian",Font.BOLD,15)); //Viner Hand ITC
		
		springDay.setBounds(1000, 600, 70, 50);
		backToGame.addActionListener(this);
		backToGame.setForeground(Color.green);
		
		basicGarden.addActionListener(this);
		oldPlace.addActionListener(this);
		kungFu.addActionListener(this);
		springDay.addActionListener(this);
		jungle.addActionListener(this);
		
		    add(backToGame);
		    add(basicGarden);
		    add(oldPlace);
		    add(kungFu);
		    add(springDay);
		    add(jungle);
		   
		
	}
	public void paint(Graphics g) { 
		  try {backGroundMenu = ImageIO.read(new File("D:\\ImageSource\\Backmenu.jpg"));
			   g.drawImage(backGroundMenu,0 ,0, null);} 
		  catch (IOException e) {e.printStackTrace();}}
	
	public void run() {
	    while (true) {
	      repaint();
	      try {
		        Thread.sleep(10);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
	      }
	    }

	
	public void actionPerformed(ActionEvent e) {
		 
				if(e.getSource() == backToGame) {
					System.out.println("hello");
					TapVeDemo.setRun(true);
					Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				if(e.getSource() == basicGarden) {
					System.out.println("You choose Basic Garden Scene");
					TapVeDemo.changeScene(0);
					//Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				if(e.getSource() == oldPlace ) {
					System.out.println("You choose Basic Garden Scene");
					TapVeDemo.changeScene(1);
					//Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				if(e.getSource() == kungFu ) {
					System.out.println("You choose Basic Garden Scene");
					TapVeDemo.changeScene(2);
					//Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				if(e.getSource() == springDay ) {
					System.out.println("You choose Basic Garden Scene");
					TapVeDemo.changeScene(3);
					//Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				if(e.getSource() == jungle ) {
					System.out.println("You choose Basic Garden Scene");
					TapVeDemo.changeScene(4);
					//Screen.callSetPanel(DynamicPanel.tapVeDemo);
					}
				
	}
}
