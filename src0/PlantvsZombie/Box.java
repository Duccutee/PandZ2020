package PlantvsZombie;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class Box extends MouseAdapter implements Cloneable {
	//JLabel boxToAddPeaShooter;
	int posXPeaShooter=10, posYPeaShooter=130;
	int posXSunFlower =10, posYSunFlower=30;
	int posXShovel = 300, posYShovel=10;
	int posXMenuButton = 1100, posYMenuButton = 10;
	static boolean soundOn = true;
	
	
	static int clickBoxOrNot = 0;
	static int clickShovelOrNot = 0;
//	static int clickMenuOrNot = 0;
	/****/ 
	BufferedImage cherryCard,sprite,sunflowerCard,walnutCard,chomperCard;
	int posXBox=10, posYBox=10,xCherry=10,yCherry=330,xSunflower=10, ySunflower=200,xWalnut=10,yWalnut=230, xChomper=10,yChomper=430;
	//Image bgImage;
	private ImageIcon imageBox[];
	
	final int peaShooterCost = 100, cherryCost = 150, chomperCost = 150; 
	final int sunFlowerCost = 50;
	
	  private ImageIcon imageArray[];
	    private int totalFrame = 2, currentFrame = 0, previousFrame = -1;
	
	
	static int initialTime=0, recoverTimeToAddPeaShooter = 8, iCherry,iSunflower,iWalnut, iChomper, c, k,s,w ;
	static int initialTimeSunFlower=0, recoverTimeToAddSunFlower = 5; //5 seconds
	public static boolean statisfyOrNot = true;
	
//	Timetest time = new Timetest();
	Score score = new Score();
	static Boardgame board = new Boardgame();
	
	
	
	ArrayList<Plant> plants = TapVeDemo.getPlantList();
	ArrayList<Sunflower> sunFlowers = TapVeDemo.getSunFlowerList();
	ArrayList <Sun> suns = TapVeDemo.getSunList();
	ArrayList <Vegan> vegans = TapVeDemo.getVeganList();
	
	static int xMouseP, yMouseP;
	public Box() {
		//boxToAddPeaShooter = new JLabel();
		ArrayList<Plant> plants = TapVeDemo.getPlantList();}

	 public void draw(Graphics g){
		 try {
				sprite = ImageIO.read(new File("ImageSource/Card/CardSprite.png"));
				
				cherryCard = sprite.getSubimage(k, 0, 64,90);
			//	sunflowerCard = sprite.getSubimage(s, 90, 64, 90);
				walnutCard = sprite.getSubimage(w, 180, 64,90);
				chomperCard = sprite.getSubimage(c, 270, 64, 90);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 if(cherryCard()==false) {
			 if(Timetest.getSecondPassed() >= iCherry+30) k=64*6;
			 else if(Timetest.getSecondPassed() >= iCherry+25) k=64*5;
			 else if(Timetest.getSecondPassed() >= iCherry+20) k=64*4;
			 else if(Timetest.getSecondPassed() >= iCherry+15) k=64*3;
			 else if(Timetest.getSecondPassed() >= iCherry+10) k=64*2;
			 else if(Timetest.getSecondPassed() >= iCherry +5) k=64;
			 else if(Timetest.getSecondPassed() >= iCherry) k=0;
		 }
		 else k=448;
		 
		 if(walnutCard()==false) {
			 if(Timetest.getSecondPassed() >= iWalnut+18) w=64*10;
			 else if(Timetest.getSecondPassed() >= iWalnut+16) w=64*9;
			 else if(Timetest.getSecondPassed() >= iWalnut+14) w=64*8;
			 else if(Timetest.getSecondPassed() >= iWalnut+12) w=64*7;
			 else if(Timetest.getSecondPassed() >= iWalnut+10) w=64*6;
			 else if(Timetest.getSecondPassed() >= iWalnut+8) w=64*5;
			 else if(Timetest.getSecondPassed() >= iWalnut+6) w=64*4;
			 else if(Timetest.getSecondPassed() >= iWalnut+4) w=64*3;
			 else if(Timetest.getSecondPassed() >= iWalnut+2) w=64*2;
			 else if(Timetest.getSecondPassed() >= iWalnut) w=64;
			 
		 }
		 else w=704;
		 
		 if(chomperCard()==false) {
			 if(Timetest.getSecondPassed() >= iChomper+4) c=64*4;
			 else if(Timetest.getSecondPassed() >= iChomper+3) c=64*3;
			 else if(Timetest.getSecondPassed() >= iChomper+2) c=64*2;
			 else if(Timetest.getSecondPassed() >= iChomper+1) c=64;
			 else if(Timetest.getSecondPassed() >= iChomper) c=0;
		 }
		 else c=320;
		 
		 g.drawImage(walnutCard, xWalnut, yWalnut, null);
		 g.drawImage(cherryCard, xCherry,yCherry ,null);
		 g.drawImage(chomperCard, xChomper, yChomper, null);
		 	g.drawImage(getBoxImage(),posXPeaShooter,posYPeaShooter,null);
		    g.drawImage(getCardSunFlowerImage(), posXSunFlower, posYSunFlower, null);
		    g.drawImage(getShovelImage(),posXShovel, posYShovel, null);
		    g.drawImage(getMenuButtonImage(), posXMenuButton, posYMenuButton, null);
		 if((clickShovelOrNot==1)&&(placeCanShovel()==true)) {
		  	g.drawImage(getFollowingShovelImage(), board.xMouseMoving, board.yMouseMoving-50,null);}}

		    
		private Image getMenuButtonImage() {
			ImageIcon icon = new ImageIcon("D:\\ImageSource\\Menubutton.jpg");
		    return icon.getImage();
	}

		  
		   public Image getBoxImage(){
			   String path;
		
			while(true) {
				 path ="ImageSource/Card/card_peashooter5.png";
				if(isRecover()==false) 
					{//path ="D:\\ImageSource\\Card\\card_peashooter0.png";
					if((initialTime <= Timetest.getSecondPassed()) && (Timetest.getSecondPassed() < initialTime+2 )) path= "ImageSource/Card/card_peashooter0.png";
					if((initialTime + 2 <= Timetest.getSecondPassed()) &&(Timetest.getSecondPassed() < initialTime + 4)) path= "ImageSource/Card/card_peashooter1.png";
					if((initialTime+ 4 <= Timetest.getSecondPassed()) && (Timetest.getSecondPassed() < initialTime + 6)) path= "ImageSource/Card/card_peashooter2.png";
					if((initialTime+ 6 <= Timetest.getSecondPassed()) && (Timetest.getSecondPassed() < initialTime + 8)) path ="ImageSource/Card/card_peashooter3.png";}
				if((isRecover()==true)&&(isSatisfyCost()==false)) path = "ImageSource/Card/card_peashooter4.png";
		    ImageIcon icon = new ImageIcon(path);
		    return icon.getImage();}}
		   
		   public Image getShovelImage() {
			   ImageIcon icon = new ImageIcon("ImageSource/Shovel.png");
			    return icon.getImage();
		   }
		  
		   public Image getFollowingShovelImage(){
		        imageArray = new ImageIcon[totalFrame];
		       
		          for (int i = 0; i < imageArray.length; i++) {
		          imageArray[i] = new ImageIcon("ImageSource/Shovelsmall" + i + ".png");}
		        
		          while(true){ 
		        	if (currentFrame == previousFrame) {currentFrame++;}
		            if (currentFrame >= imageArray.length) {
		              currentFrame = 0;}
		            previousFrame = currentFrame;
		            return imageArray[currentFrame].getImage();}}
		   
		   
		   public Image getCardSunFlowerImage(){
			   String path;
		
			while(true) {
				path ="ImageSource\\Card\\card_sunflower5.png";
				if(isRecoverSunFlower()==false) 
					{path ="D:\\ImageSource\\Card\\card_sunflower0.png";
					if(Timetest.getSecondPassed() == initialTimeSunFlower + 1) path= "ImageSource\\Card\\card_sunflower0.png";
					if(Timetest.getSecondPassed() == initialTimeSunFlower + 2) path= "ImageSource\\Card\\card_sunflower1.png";
					if(Timetest.getSecondPassed() == initialTimeSunFlower + 3) path= "ImageSource\\Card\\card_sunflower2.png";
					if(Timetest.getSecondPassed() == initialTimeSunFlower + 4) path ="ImageSource\\Card\\card_sunflower3.png";}
				if((isRecoverSunFlower()==true)&&(isSatisfyCostSunFlower()==false)) path = "ImageSource\\Card\\card_sunflower4.png";
			
		    ImageIcon icon = new ImageIcon(path);
		    return icon.getImage();}}
		@Override 
		public void mousePressed(MouseEvent e) {
		xMouseP=e.getX(); yMouseP=e.getY();
				//System.out.println("InPressed:"+xMouseP+","+yMouseP);
				if (posXSunFlower<getposXPressed() && getposXPressed()< posXSunFlower+61 && posYSunFlower <getposYPressed() && getposYPressed()<posYSunFlower+82)
				{		if(isRecoverSunFlower()&&isSatisfyCostSunFlower()) 
							clickBoxOrNot = 1;}
				if (posXPeaShooter<getposXPressed() && getposXPressed()< posXPeaShooter+61 && posYPeaShooter <getposYPressed() && getposYPressed()<posYPeaShooter+82)
				{		if(isRecover()&&isSatisfyCost()) 
							clickBoxOrNot = 1;}
				if (xWalnut<getposXPressed() && getposXPressed()< xWalnut+61 && yWalnut <getposYPressed() && getposYPressed()<yWalnut+82)
				{		if(walnutCard()&&Score.getScore()>=50) 
							clickBoxOrNot = 1;}
				if (xCherry<getposXPressed() && getposXPressed()< xCherry+61 && yCherry <getposYPressed() && getposYPressed()<yCherry+82)
				{		if(cherryCard()&&Score.getScore()>=cherryCost) 
							clickBoxOrNot = 1;}
				if (xChomper<getposXPressed() && getposXPressed()< xChomper+61 && yChomper <getposYPressed() && getposYPressed()<yChomper+82)
				{		if(chomperCard()&&Score.getScore()>=chomperCost) 
							clickBoxOrNot = 1;}
				
				if (posXShovel<getposXPressed() && getposXPressed()< posXShovel+50 && posYShovel <getposYPressed() && getposYPressed()<posYShovel+51)
				{clickShovelOrNot = 1;}
				
				}
		 public int getposXPressed() {return xMouseP;}
		 public int getposYPressed() {return yMouseP;}
		 
		@Override
		public void mouseClicked(MouseEvent e) {
			int x=e.getX(),y=e.getY();

			
			// Condition to collect sun
			for (int i=0; i<suns.size();i++) {
				Sun tempSun = suns.get(i);
				if(tempSun.getX()-10 <x && tempSun.getX()+85 >x && tempSun.getY()-10 < y && tempSun.getY()+85 >y)
					{soundOn =true;
					if(soundOn) soundCoinCollect();
					
					tempSun.Collect();
					soundOn = false;
					System.out.println("SOUNDON AFTER COLLECT: "+soundOn);}
			}
			if(posXMenuButton < x && posXMenuButton + 80 > x && posYMenuButton < y && posYMenuButton + 50 > y) {
				System.out.println("Click Menu r");
				TapVeDemo.setRun(false);
				BackMenu menu = new BackMenu();
				Screen.callSetPanel(menu);
			//	clickMenuOrNot = 1;
				
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int xMouse=e.getX(), yMouse=e.getY();
			//System.out.println("InReleased:"+xMouse+","+yMouse);
			
						//CARD_PEASHOOTER			
			if (posXPeaShooter<getposXPressed() && getposXPressed()< posXPeaShooter+61 && posYPeaShooter <getposYPressed() && getposYPressed()<posYPeaShooter+82)
			{	
				System.out.println("initial: "+initialTime+" recover: "+recoverTimeToAddPeaShooter);
				if(isRecover()&&isSatisfyCost()) {
					if(board.checkpointInWhichGrid(xMouse, yMouse)==true) {
				TapVeDemo.addPlant(new Plant(board.getXCenterOfPlant(),board.getYCenterOfPlant(),75,50));
				clickBoxOrNot = 0;
			
				initialTime = Timetest.getSecondPassed();
				score.MinusSun(peaShooterCost);} 
				
				}
				if(isRecover()&&isSatisfyCost()==false) statisfyOrNot = false ;}
			
						//CARD_SUNFLOWER
			if (posXSunFlower<getposXPressed() && getposXPressed()< posXSunFlower+61 && posYSunFlower <getposYPressed() && getposYPressed()<posYSunFlower+82)
			{	
				
				if(isRecoverSunFlower()&&isSatisfyCostSunFlower()) {
					if(board.checkpointInWhichGrid(xMouse, yMouse)==true) {
			
				TapVeDemo.addSunFlower(new Sunflower(board.getXCenterOfSunfl(),board.getYCenterOfSunfl(),50,50));
				
				clickBoxOrNot=0;
				initialTimeSunFlower = Timetest.getSecondPassed();
				score.MinusSun(sunFlowerCost);}
				}
				if(isRecoverSunFlower()&&isSatisfyCostSunFlower()==false) statisfyOrNot = false ;}
			
			
			/*****/ //CARD_WALNUT
			if(xWalnut <getposXPressed() && getposXPressed()< xWalnut+64 && yWalnut< getposYPressed() && getposYPressed()<yWalnut+90) {
				//&& 
				if(walnutCard()==true && Score.getScore()>=50) {
					if(board.checkpointInWhichGrid(xMouse, yMouse)==true) {
						TapVeDemo.addVegan(new wallNut(board.getXCenterOfVegan(),board.getYCenterOfVegan(),100,50));
						clickBoxOrNot = 0;
						iWalnut = Timetest.getSecondPassed();
						score.MinusSun(sunFlowerCost);}}
				if(walnutCard()==false&&Score.getScore()<50) statisfyOrNot = false;}
			
			//CARD_CHERRY
			if(xCherry<getposXPressed() && getposXPressed()<xCherry+64 && yCherry< getposYPressed() && getposYPressed()<yCherry+90) {
				//&& 
				if(walnutCard()==true && Score.getScore()>=150) {
					if(board.checkpointInWhichGrid(xMouse, yMouse)==true) {
						TapVeDemo.addVegan(new Cherry(board.getXCenterOfVegan(),board.getYCenterOfVegan(),100,50));
						clickBoxOrNot = 0;
						iCherry = Timetest.getSecondPassed();
						score.MinusSun(cherryCost);}}
				if(cherryCard()==false&&Score.getScore()<150) statisfyOrNot = false;}
			//CARD_CHOMPER
			if(xChomper <getposXPressed() && getposXPressed()< xChomper+64 && yChomper< getposYPressed() && getposYPressed()<yChomper+90) {
				
				if(chomperCard()==true && Score.getScore()>=150) {
			
					if(board.checkpointInWhichGrid(xMouse, yMouse)==true) {
						TapVeDemo.addVegan(new Chomper(board.getXCenterOfSunfl(),board.getYCenterOfSunfl()-20,50,50));
						clickBoxOrNot = 0;
						iChomper = Timetest.getSecondPassed();
						score.MinusSun(150);}}
				if(chomperCard()==false&&Score.getScore()<150) statisfyOrNot = false;}	
			
			
						//CARD_SHOVEL 
			if (posXShovel<getposXPressed() && getposXPressed()< posXShovel+50 && posYShovel <getposYPressed() && getposYPressed()<posYShovel+82)
			{
				//System.out.println("hello");
				if(board.checkGridToShovel(xMouse, yMouse)==true) {
					
					if(board.whichPlantIsThat()!=-1)
					{Plant tempPlant = plants.get(board.whichPlantIsThat());
					System.out.println("Plant thu: "+board.whichPlantIsThat());
					TapVeDemo.removePlant(tempPlant);}
					
					if(board.whichVeganIsThat()!=-1) {
						Vegan tempVegan = vegans.get(board.whichVeganIsThat());
						System.out.println("Vegan thu: "+board.whichVeganIsThat());
						TapVeDemo.removeVegan(tempVegan);}
					
					if(board.whichSunflIsThat()!=-1) {
					Sunflower tempSunfl = sunFlowers.get(board.whichSunflIsThat());
					TapVeDemo.removeSunFlower(tempSunfl);}
					clickShovelOrNot = 0;
				}
			}
		
		}
		public boolean errorByChangeColor() {
			return statisfyOrNot;
		}
		
		public boolean isRecover() {
			if (Timetest.getSecondPassed()>=initialTime + recoverTimeToAddPeaShooter) {
				//System.out.println("time.getSecondPassed(): "+time.getSecondPassed()+">="+initialTime+"+"+recoverTimeToAddPeaShooter);
				//System.out.println("Adding successfully"); 
				return true;}
			else {
				//System.out.println("time.getSecondPassed(): "+time.getSecondPassed()+"<"+initialTime+"+"+recoverTimeToAddPeaShooter);
				//System.out.println("Wait for peashooter recover"); 
				return false;}
		}
		public boolean isSatisfyCost() {
			if(score.getScore()>=peaShooterCost)return true;
			else return false;
		}
		
		public boolean isRecoverSunFlower() {
			if (Timetest.getSecondPassed()>=initialTimeSunFlower + recoverTimeToAddSunFlower) {
				//System.out.println("time.getSecondPassed(): "+time.getSecondPassed()+">="+initialTimeSunFlower+"+"+recoverTimeToAddSunFlower);
				//System.out.println("Adding successfully"); 
				return true;}
			else {
				//System.out.println("time.getSecondPassed(): "+time.getSecondPassed()+"<"+initialTimeSunFlower+"+"+recoverTimeToAddSunFlower);
				//System.out.println("Wait for peashooter recover"); 
				return false;}}
		
		public boolean isSatisfyCostSunFlower() {
			if(score.getScore()>=sunFlowerCost) return true;
			else return false;
		}
		
		/*********/ 
		public boolean walnutCard() {
			if(Timetest.getSecondPassed() >= iWalnut+20 && Score.getScore() >= 50) return true;
			else return false;
		}
		
		public boolean cherryCard() {
			if(Timetest.getSecondPassed()>= iCherry+35 && Score.getScore()>=150) return true;
			else return false;
			}
		public boolean chomperCard() {
			if(Timetest.getSecondPassed()>= iChomper + 5 && Score.getScore()>=150) return true;
			else return false;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {}
		
		

		public void recievePoint(int xPlantPos, int yPlantPos) {
			board.findPlantInWhichGrid(xPlantPos, yPlantPos);
		}
		public static boolean callWhereIsMouse() {
			if(board.whereisMouse()==true) return true;
			else return false;
		}
		public static boolean placeCanShovel() {
			if (board.whereisMouseToShovel()==true) return true;
			else return false;
		}
		private static void soundCoinCollect() {
			String filepath = "points.wav";
			Sound musicObject = new Sound();
			musicObject.playMusic(filepath);
		}
	}; 




