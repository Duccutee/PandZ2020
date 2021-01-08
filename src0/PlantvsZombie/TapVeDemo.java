package PlantvsZombie;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

  public class TapVeDemo extends JPanel implements Runnable{
	  
  int enemyCount = 5;
  int zombieCount = 5;
  static int plantCount = 2;
  int projectileCount = 4;
  static Point point;
  //static boolean runningGame = true;
  static int zombieHaveDied;
  public static int level = 1;
  public static int nextLevel = level+1;
  static String pathOfBackGround = "D:\\ImageSource\\Background.jpg";
  static boolean run = true;
  static int currentState=0;
  
  
  /***/
  int sunFlowerCount = 2,j=100;
	
  public static int getLevel() {
	return level;
}

  public static void setLevel(int level) {
	TapVeDemo.level = level;
}

static ArrayList<Zombie> zombies = new ArrayList<>();
  static ArrayList<Plant> plants = new ArrayList<>();
  
  static ArrayList <Mower> mowers = new ArrayList <Mower>();
  static ArrayList <Vegan> vegans = new ArrayList<Vegan>();
 //***** 
//  static ArrayList<Timetest> times = new ArrayList<>();
  
  static ArrayList<Sunflower> sunFlowers = new ArrayList<Sunflower>();
  static ArrayList<Sun> suns = new ArrayList<Sun>();
  
 // ArrayList<ArrayList<Zombie>> laneZombies;
 // ArrayList<ArrayList<Plant>> lanePlants;

  static  ArrayList<Projectile> projectiles = Plant.getProjectileList();
  Random rand = new Random();
  
  //***************************************************************************/
  
  
  static Timetest tt = new Timetest();
 // NewspaperZom newsZom = new NewspaperZom();
  
  private BufferedImage backGround;
  	static Box box = new Box();
  	Menu menu = new Menu();
  	static Boardgame board = new Boardgame();
 

  public TapVeDemo() {
    Thread threadTV = new Thread(this);
    threadTV.start();
    /*addVegan(new Chomper(960,350,100,50));
    addVegan(new Chomper(960,450,100,50));
    addVegan(new Chomper(980,250,100,50));
    addVegan(new Chomper(960,150,100,50));
    addVegan(new Chomper(960,50,100,50));*/
  
    
    for(int i=0; i< 5; i++) addMower(new Mower(200,(i+1)*90, 100, 50));
   /* tt.startGame();
	tt.startAddZombie();
	tt.startAddSun();*/
	  //reStart();
    }

   
	
	/***/
//	addSunFlower(new Sunflower(330,275,50,50));
	
/*	laneZombies = new ArrayList<>();
    laneZombies.add(new ArrayList<>()); //line 1
    laneZombies.add(new ArrayList<>()); //line 2
    laneZombies.add(new ArrayList<>()); //line 3
    laneZombies.add(new ArrayList<>()); //line 4
    laneZombies.add(new ArrayList<>()); //line 5
    
  //  for (int i =0; i<laneZombies.size();i++)
    lanePlants = new ArrayList<>();
    lanePlants.add(new ArrayList<>()); //line 1
    lanePlants.add(new ArrayList<>()); //line 2
    lanePlants.add(new ArrayList<>()); //line 3
    lanePlants.add(new ArrayList<>()); //line 4
    lanePlants.add(new ArrayList<>()); //line 5*/

  public static Box getBox() {return box;}
  

public static int getPointX() {
	return (int) point.getX();
}
public static int getPointY() {
	return (int) point.getY();
}

public void setBox(Box box) {
	this.box = box;
}
public void callTimetest() {
	tt.startTest();
}
public static boolean isRun() {return run;}
public static void setRun(boolean run) {TapVeDemo.run = run;}
public static int getCurrentState() {return currentState;}
public static void setCurrentState(int currentState) {TapVeDemo.currentState = currentState;}

public static void changeScene(int choice) {
	 int userChoice = choice;
	   switch (userChoice) {
	 	case 0:  pathOfBackGround = "D:\\ImageSource\\Background.jpg"; break;
	 	case 1:  pathOfBackGround = "D:\\ImageSource\\Background1.jpg"; break;
	 	case 2:  pathOfBackGround = "D:\\ImageSource\\Background2.jpg"; break;
	 	case 3:  pathOfBackGround = "D:\\ImageSource\\Background3.jpg"; break;
	 	case 4:  pathOfBackGround = "D:\\ImageSource\\Background4.jpg"; break;}

}

public void paint(Graphics g) { // Draw Background of screen
	  //try {backGround = ImageIO.read(new File("D:\\ImageSource\\Background3.jpg"));
	  try {backGround = ImageIO.read(new File(pathOfBackGround));
		   g.drawImage(backGround,0 ,0, null);} 
	  catch (IOException e) {e.printStackTrace();}

		if(currentState ==0) {menu.paint(g);}
			else if(currentState ==1) {
			
	g.drawImage(backGround,0 ,0, this);
    box.draw(g);
    board.draw(g);
	
   // for(Zombie tempZombie: zombies) {tempZombie.drawAni(g);tempZombie.drawBound(g);}
   
    for (Plant tempPlant: plants) {tempPlant.drawAni(g);tempPlant.drawBound(g);}

    for(int i = 0; i< projectiles.size();i++) {Projectile tempProjectile = projectiles.get(i); tempProjectile.draw(g);tempProjectile.drawBound(g);}
 //   for (Projectile tempProjectile: projectiles) {tempProjectile.draw(g);}
    
	for (Sunflower tempSunFlower: sunFlowers) {tempSunFlower.paint(g);tempSunFlower.drawBound(g);}

	for (int i = 0; i < zombies.size(); i++) {
        Zombie tempZombie = zombies.get(i);
        tempZombie.drawAni(g);
        tempZombie.drawBound(g);}
	//for (Sun tempSun: suns) {tempSun.paint(g);}
	for (int i = 0; i < suns.size(); i++) {
	        Sun tempSun = suns.get(i);
	        tempSun.paint(g);}
	
	for(int i=0; i < vegans.size(); i++) {
			Vegan tempVegan = vegans.get(i);
			tempVegan.paint(g);
			tempVegan.drawBound(g);}
	
	for(int i=0; i< mowers.size(); i++) {
		//addMower(new Mower(200,(i+1)*90, 100, 85));
		Mower tempMower = mowers.get(i);
		tempMower.paint(g);
		tempMower.drawBound(g);
	}
	

	if(box.errorByChangeColor()==false) 
		{for(int i=0; i<10; i++) {g.setColor(Color.red);}// g.setColor(Color.black);}
		box.statisfyOrNot = true;
		}
		else g.setColor(Color.white);
	
	g.setFont(new Font ("Arial",Font.BOLD,25));
	g.drawString("Score: "+Score.getScore(), 100,20);
	
	g.setFont(new Font ("Arial",Font.BOLD,25));
	g.drawString("DAY: "+getLevel(), 1100,550);
	
	if(Timetest.secondPassed <= 3) {
		g.setColor(new Color(255,255,0));
		g.setFont(new Font ("Chiller",Font.BOLD,100));
		g.drawString("READY: "+Timetest.secondPassed, 500,300);
		
	} else if(Timetest.secondPassed==5) {
		g.setColor(new Color(255,255,0));
		g.setFont(new Font ("Charlemagne Std",Font.BOLD,100)); //The Serif Hand Light, Charlemagne Std
		g.drawString("PLANT!!", 500,300);}
  }
}
  
  
  public void run() {
    while (true) {
    	System.out.print("");
    	if(run) {
      repaint();
      PointerInfo info = MouseInfo.getPointerInfo();
      point = info.getLocation();
      box.placeCanShovel(); 
      box.callWhereIsMouse(); //vi neu k thong qua box, goi thang board thi board chua cap nhat
     // System.out.println("x:"+point.getX()+", y:"+point.getY());
      
    //  for(Zombie tempZombie: zombies) {
    for (int i = 0; i < zombies.size(); i++) {
    		Zombie tempZombie = zombies.get(i);
          tempZombie.move();
      	  tempZombie.checkCollisionWithPlant();
      	  tempZombie.checkCollisionWithSunFlower();
      	  tempZombie.checkCollisionWithVegan();}
      
//      for (Sun tempSun: suns) {
//			tempSun.tangy();}
      
      for (int i = 0; i < suns.size(); i++) {
          Sun tempSun = suns.get(i);
          tempSun.tangy();}
		
	  for (Sunflower tempSunFlower: sunFlowers) {
			tempSunFlower.Loop();}
		
      for (int i = 0; i < plants.size(); i++) {
          Plant tempPlant = plants.get(i);
          tempPlant.LoopToShoot();}
      
      for( int i=0; i<mowers.size(); i++) {
    	  Mower tempMower = mowers.get(i);
    	  tempMower.collideZombie();
    	  tempMower.Move();
      }
      for (int i = 0; i < projectiles.size();i++) {
    	  Projectile tempProjectile = projectiles.get(i);
    	  tempProjectile.move(4);
    	  tempProjectile.checkCollisionWithZombie();}
  
      try {
	        Thread.sleep(10);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
      
  
   
    	 //if(zombieHaveDied == NormalZom.zombieToCreate+NewspaperZom.zombieToCreate+BucketZom.zombieToCreate+ConeZom.zombieToCreate) {
      if(winningGameOrNot()) {
    	System.out.println("FINISHHHHHHHHHHH!!!, ZOMBIE DIED: "+zombieHaveDied);
    	setRun(false);
    	JOptionPane.showMessageDialog(null,"COMPLETE LEVEL"+level + '\n' + "CLICK OK TO NEXT LEVEL: "+ nextLevel);
    	level = nextLevel;
    	nextLevel = level + 1;
    	reStart();
    	setRun(true);
    	//System.out.println(run);
    	tt.startTest();
    	 
    	
    	//System.exit(0);
    	}
      
    for(Zombie tempZombie: zombies) {
    	if(tempZombie.getX()<220) {
    		
    		//JOptionPane.showMessageDialog(null,"ZOMBIE ATE YOUR BRAIN" + '\n' + "CLICK OK TO EXIT");
    //	Screen.screen.dispose();
    
    	LosingScreen losescreen = new LosingScreen();
		Screen.callSetPanel(losescreen);
    	System.out.println("RETRY THU O TAPVE: "+run);
   
    	 }
    	}
    //Timetest.canStopAddZombie();
    tt.canStopAddZom();
   // times.get(0).canStopAddZombie();
    }
   }

  }
  
   public static void addZombie(Zombie z) {
	    zombies.add(z);}

   public static void removeZombie(Zombie z){
	   int yOfZombie = z.getY();
	   if(z instanceof ConeZom) {yOfZombie+=30;}
	   	else if(z instanceof BucketZom) {yOfZombie+=10;}
	   switch (yOfZombie) {
	 	case 25:  Timetest.minusAmountZInLane0(); break;
	 	case 115: Timetest.minusAmountZInLane1(); break;
	 	case 215: Timetest.minusAmountZInLane2();break;
	 	case 295: Timetest.minusAmountZInLane3(); break;
	 	case 395: Timetest.minusAmountZInLane4(); break;}
	    zombies.remove(z);
	    if(z instanceof NormalZom) NormalZom.zombieHaveDied ++;
	    else if(z instanceof BucketZom) BucketZom.zombieHaveDied ++;
	    else if(z instanceof ConeZom) ConeZom.zombieHaveDied ++;
	    else if (z instanceof NewspaperZom) NewspaperZom.zombieHaveDied ++;}
	//    zombieHaveDied ++;}
   
   	public static boolean winningGameOrNot() {
   		if(NormalZom.zombieHaveDied == NormalZom.zombieToCreate&&
   				BucketZom.zombieHaveDied == BucketZom.zombieToCreate&&
   				ConeZom.zombieHaveDied == ConeZom.zombieToCreate&&
   				NewspaperZom.zombieHaveDied == NewspaperZom.zombieToCreate) return true;
   		return false;
   	}
   
	//    if(tempZombie instanceof NormalZom) {NormalZom.zombieHaveDied ++; System.out.println("So Normal chet"+NormalZom.zombieHaveDied);}
	 //   if(tempZombie instanceof NewspaperZom) {NewspaperZom.zombieHaveDied ++; System.out.println("So NEWSPAPER chet"+NewspaperZom.zombieHaveDied);} }
  
   public static ArrayList<Zombie> getZombieList() {
	    return zombies;}
   
	   public static void addPlant(Plant p) {
		    plants.add(p);}
	
	   public static void removePlant(Plant p){
		   plants.remove(p);}
		  
	   public static ArrayList<Plant> getPlantList() {
		    return plants;}
	   
	   //List of sunflower
		public static void addSunFlower(Sunflower sf) {
			sunFlowers.add(sf);
		}
		public static ArrayList<Sunflower> getSunFlowerList(){
			return sunFlowers;
		}
		public static void removeSunFlower(Sunflower sf) {
			sunFlowers.remove(sf);
		}
		
		//List of Sun
		public static void addSun(Sun sun) {
			suns.add(sun);
		}
		public static ArrayList<Sun> getSunList(){
			return suns;
		}
		public static void removeSun(Sun sun) {
			suns.remove(sun);
		}
		//LIST OF VEGAN
		public static void addVegan (Object object) {
			vegans.add((Vegan) object);
		}
		
		public static ArrayList<Vegan> getVeganList (){
			return vegans;
		}
		public static void removeVegan (Object o) {
			vegans.remove((Vegan) o);
		}
		
		// List of mower
				public static void addMower(Mower mower) {
					mowers.add(mower);
				}
				public static ArrayList<Mower> getMowerList(){
					return mowers;
				}
				public static void removeMower (Mower m) {
					mowers.remove(m);
				}
		
		
/*		//List Of Time
		public static void addTime(Timetest t) {
			times.add(t);
		}
		public static ArrayList<Timetest> getTimeList(){
			return times;
		}
		public static void removeTime(Timetest t) {
			times.remove(t);
		}
*/
		public static void reStart() {
			zombieHaveDied = 0;
			Score.setScore(50);
			zombies.clear();
			plants.clear();
			projectiles.clear();
			sunFlowers.clear();
			suns.clear();
			vegans.clear();
			mowers.clear();
			NormalZom.zombieHaveDied = 0; NormalZom.totalZombieCreate = 0;
			BucketZom.zombieHaveDied = 0; BucketZom.totalZombieCreate = 0;
			ConeZom.zombieHaveDied = 0; ConeZom.totalZombieCreate = 0;
			NewspaperZom.zombieHaveDied = 0; NewspaperZom.totalZombieCreate = 0;
			//winningGameOrNot();
			Timetest.canAddZomBuc = true;
			Timetest.canAddZomCone = true;
			Timetest.canAddZomNews = true;
			Timetest.canAddZomNor = true;
			Timetest.canStopAddZom();
			box.clickBoxOrNot = 0;
			box.clickShovelOrNot = 0;
			box.initialTime = 0;
			box.initialTimeSunFlower = 0;
			box.iWalnut = 0;
			//board.setUpGrid();
			box.board.setUpGrid();
			for(int i=0; i< 5; i++) addMower(new Mower(200,(i+1)*90, 100, 40));
			
		}



		
		
	   												
}