package PlantvsZombie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LosingScreen extends JPanel implements ActionListener {
	//public static final String strImagePath = "D:\\ImageSource\\ZombieAteYourBrain.png";
	static ImageIcon bg;
	private BufferedImage backGround;
	private JButton retry;
	private JButton exist;
	
//	JPanel losingPanel;
	
		 public LosingScreen() {
			// losingPanel = new JPanel() {
				// @Override
			/*	 protected void paintComponent(Graphics g) {
					 super.paintComponent(g);
					 if (bg != null) {
						 g.drawImage(bg.getImage(), 0, 0, 1200, 600, null);
					 }
				 }*/
			// };
		//	 setContentPane(losingPanel);
			 	setLayout(null); //****if not we cannot adjust the location 
			 	//setSize(1200,600);
		        retry = new JButton("RETRY");
		        retry.setBackground(new Color(169, 20, 241));
		        retry.setFont(new Font ("Doctor Glitch",Font.BOLD,15));
		        retry.setBounds(705,498,98,40);
		        retry.addActionListener(this);
		        retry.setForeground(Color.white);
		        
		        
		        exist = new JButton("EXIST");
		        exist.setBackground(new Color(77, 180, 245));
		        exist.setFont(new Font ("Doctor Glitch",Font.BOLD,15));
		        exist.setBounds(425,498,133,40);
		        exist.addActionListener(this);
		        exist.setForeground(Color.white);
		        
		     //   losingPanel.
		        add(retry);
		     //   losingPanel.
		        add(exist);
		        //add(losingPanel);
		        
		       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       // setLocation(120,90);
		       // setResizable(false);
		       // repaint();
		       // setVisible(true);
		 }
	    static LosingScreen losingscreen;
	  
	  /*  public static void main(String[] args)throws CloneNotSupportedException {
	        LosingScreen losingscreen = new LosingScreen();
	        JFrame frame = new JFrame();
	        frame.setSize(1200,600);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocation(120,90);
	        frame.setResizable(false);
	        frame.add(losingscreen);} */
	        
	      //  losingscreen.getContentPane().addMouseListener(new Box());
	        

		private void setBackground(ImageIcon image) {
			this.bg = image;
		}
		public void paint(Graphics g) { // Draw Background of screen
			  try {backGround = ImageIO.read(new File("ImageSource\\ZombieAteYourBraintest.png"));
				   g.drawImage(backGround,0 ,0, null);} 
			  catch (IOException e) {e.printStackTrace();}}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == retry) {
				
				TapVeDemo.setRun(false);
				Screen.callSetPanel(DynamicPanel.tapVeDemo);
				TapVeDemo.reStart();
				TapVeDemo.tt.startTest();
				TapVeDemo.setRun(true);
			    
			}
			if(e.getSource() == exist) {
				//JOptionPane.showMessageDialog(null,"ZOMBIE ATE YOUR BRAIN" + '\n' + "CLICK OK TO EXIT");
				System.exit(0);
			}
			
		}
		
}
