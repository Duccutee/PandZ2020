package PlantvsZombie;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class Screen extends JFrame {
	   // static TapVeDemo tapVeDemo = new TapVeDemo();
	    //static BackMenu backMenu = new BackMenu();
		static DynamicPanel panel = new DynamicPanel();
	//	static ArrayList<Timetest> times = new ArrayList<>();
	//	static Timetest tt = new Timetest();
	//	DynamicPanel.tapVeDemo 
		static String name ;

		public String getName() {
				return name;
		}
		public void setName(String name) {
				Screen.name = name;
		}
		
	    public Screen(){
	    	System.out.println("New Screen");
	        setSize(1200,600);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocation(120,90);
	        setResizable(false);
	      //  TapVeDemo tapVeDemo = new TapVeDemo(); time, sun bi nhan doi
	        add(panel);
	     
	        getContentPane().addMouseListener(new Box());
	      //  setLayout(null); //****if not we cannot adjust the location 
	        
	        addKeyListener(new KeyListener() {
				public void keyTyped(KeyEvent e) {
				}
				public void keyPressed(KeyEvent e) {
				 int key = e.getKeyCode();
					 
					 if(TapVeDemo.getCurrentState()==0)
						 if(key == KeyEvent.VK_SPACE) {Menu.setPress(true);}
					 
					 if(TapVeDemo.getCurrentState()==1) {
						 if(key == KeyEvent.VK_P) {panel.tapVeDemo.setRun(false); System.out.println("PAUSE");}
						 else if (key == KeyEvent.VK_C) {panel.tapVeDemo.setRun(true);
						 }}
				}
				
				public void keyReleased(KeyEvent e) {
					int key = e.getKeyCode();
					 if(TapVeDemo.getCurrentState()==0)
				     {if(key == KeyEvent.VK_SPACE) {
				    	 //if(times.size()>0) times.clear();
				    	 TapVeDemo.setCurrentState(1);
				    	 	panel.tapVeDemo.callTimetest();
				    		//addTime(tt);
							//tt.startTest();
				     }}
				}
			});
		}
	    
	    public static void callSetPanel(JPanel newpan) {
	       panel.setPanel(newpan);
	    }
	    
	    static Screen screen;
	    public static void begin() {
	    
	        screen.dispose();
	       screen = new Screen();
	    }
	    public static void main(String[] args)throws CloneNotSupportedException {
	    
	        screen = new Screen();
	        SoundActive();
	        name = JOptionPane.showInputDialog("What's your name?");
	        
	        Menu.setName(name);
	        User u1 = new User(name,1);
	      //  screen.getContentPane().addMouseListener(new Box());
	      /*  while(true) {
	        	System.out.println(Box.clickMenuOrNot);
	        	 if (Box.clickMenuOrNot == 0) screen.add(tapVeDemo); 
	 	        else if (Box.clickMenuOrNot == 1) {TapVeDemo.runningGame = false; screen.add(backMenu); 
	 	        System.out.println("DA STOP 1 THOI GIAN"); TapVeDemo.runningGame = true; Box.clickMenuOrNot = 0;
	 	        }}*/
	        
	        
	    }
	    
	    private static void SoundActive() {
			String filepath = "music.wav";
			Sound musicObject = new Sound();
			musicObject.playMusic(filepath);
		}
	    
	/*	public static void addTime(Timetest t) {
			times.add(t);
		}
		public static ArrayList<Timetest> getTimeList(){
			return times;
		}
		public static void removeTime(Timetest t) {
			times.remove(t);
		}*/
			
	}

