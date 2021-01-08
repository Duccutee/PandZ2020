package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class NewspaperZom extends Zombie {
		
	private ImageIcon imageArray[];
	  private ImageIcon imageArrayCrump[];
	  private ImageIcon imageArrayAngry[];
	  private ImageIcon imageArrayEat[];
	  
	  private static int i=0;
	  
	  private BufferedImage newsZombieImage, sprite;
	  private final int hpToChangeVel = 160;
	  
	  private int totalFrame = 8, currentFrame = 0, previousFrame = -1; 
	  private int totalFrameEat = 6, currentFrameEat = 0, previousFrameEat = -1; 
	 // private int totalFrameCrump = 8, currentFrameCrump = 0, previousFrameCrump = -1; 
	  private int totalFrameAngry = 8, currentFrameAngry = 0, previousFrameAngry = -1; 
	  //private int healthZombie = 260;
	  //private int DamagePerEat = 2;
	  private int count = 10;
	  public static int totalZombieCreate = 0;
	  public static int zombieToCreate = 1;
	  public static int zombieHaveDied = 0;
	  private int wait = 100; 
	 // private int velocity = 1;
	  
	  
		public NewspaperZom(int x, int y, int width, int height) {
		super(x, y, width, height);
		setHealth(260);
		setVelocity(1);
		setDamagePerEat(2);
		totalZombieCreate++;
		System.out.println("DA TAO NEWSPAPER");
		// TODO Auto-generated constructor stub
	}

	public boolean speedUp() {
		if(this.getHealth()<hpToChangeVel) return true;
		else return false;
	}

	@Override
	public void move() {
		 if(speedUp()==true) 
	    	{//System.out.println(speedUp());
	    	setVelocity(8);
	    	//System.out.println(velocity);
	    	}
		 count--;
		 if(count<=0) {
	    x = x - getVelocity();
	    count = 10;}
	}
	
	 public void drawAni(Graphics g){
	if(checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan()) {g.drawImage(getZombieAniImageEat(),x,y,null);}
	
	else if((this.getHealth()>0)&&(this.getHealth()<hpToChangeVel)) {g.drawImage(getZombieAniImageAngry(),x,y,null);}
	
	else if(this.getHealth()==hpToChangeVel){
		try {newsZombieImage = ImageIO.read(new File("ImageSource\\ZombieNews\\ZombieNewsCrump8.png"));} 
		catch (IOException e) {e.printStackTrace();}g.drawImage(newsZombieImage,x,y,null);}
	else {
		//try {sprite= ImageIO.read(new File("D:\\ImageSource\\newsZombieAni1.png"));
		try {sprite= ImageIO.read(new File("ImageSource/ZombieNews/newsZombieAni1.png"));
		newsZombieImage = sprite.getSubimage(i, 0, 120, 150);} 
		catch (IOException e) {e.printStackTrace();}
		i+=120;
		if(i==2880)i=0;
	g.drawImage(newsZombieImage,x,y,null);}}
	
	 /*NOT USE THIS*/
	public Image getZombieAniImage() {
		imageArray = new ImageIcon[totalFrame];
		//imageArrayCrump = new ImageIcon[totalFrameCrump];
		imageArrayAngry = new ImageIcon[totalFrameAngry];
		imageArrayEat = new ImageIcon[totalFrameEat];
		ImageIcon icon = new ImageIcon("D:\\ImageSource\\ZombieNews\\ZombieNewsCrump8.png");
		
	   // for (int i = 0; i < imageArrayCrump.length; i++) {
	     // imageArrayCrump[i] = new ImageIcon("D:\\ImageSource\\ZombieNews\\ZombieNewsCrump" + i + ".png");}
	    
	    for (int i = 0; i < imageArrayEat.length; i++) {
		      imageArrayEat[i] = new ImageIcon("D:\\ImageSource\\ZombieNews\\ZomNewsEat" + i + ".png");}
	    
	    for (int i = 0; i < imageArrayAngry.length; i++) {
		      imageArrayAngry[i] = new ImageIcon("D:\\ImageSource\\ZombieNews\\ZomNewsAngry" + i + ".png");}
	    
	    int i = 0;
       // for (int i = 0; i < imageArray.length; i++) {
        while(i<imageArray.length) { 	
      //  	System.out.println(wait);
        	wait--;
        imageArray[i] = new ImageIcon("D:\\ImageSource\\ZombieNews\\ZombieNews" + i + ".png");
    //	System.out.println("Hinh vi tri thu: "+i);
    	if(wait<=0) {
    		i++; this.wait=100;}}
      
        while(true){ 
        	if(checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan()) {
  		      if (currentFrameEat == previousFrameEat) {
  		    		currentFrameEat++;}
  		      if (currentFrameEat >= imageArrayEat.length) {
  		        currentFrameEat = 0;}
  		      previousFrameEat = currentFrameEat;
  		      return imageArrayEat[currentFrameEat].getImage();}
        	
        	/*if((this.getHealth()>200)&&(this.getHealth()<=300)) {
  		      if (currentFrameCrump == previousFrameCrump) {
  		    		currentFrameCrump++;}
  		      if (currentFrameCrump >= imageArrayCrump.length) {
  		        currentFrameCrump = 0;}
  		      previousFrameCrump = currentFrameCrump;
  		      return imageArrayCrump[currentFrameCrump].getImage();}*/
        	
        	if((this.getHealth()>0)&&(this.getHealth()<hpToChangeVel)) {
    		      if (currentFrameAngry == previousFrameAngry) {
    		    		currentFrameAngry++;}
    		      if (currentFrameAngry >= imageArrayAngry.length) {
    		        currentFrameAngry = 0;}
    		      previousFrameAngry = currentFrameAngry;
    		      return imageArrayAngry[currentFrameAngry].getImage();}
        	
        	if(this.getHealth()==hpToChangeVel) return icon.getImage();

      	  
      	if (currentFrame == previousFrame) {currentFrame++;}
    
          if (currentFrame >= imageArray.length) {
            currentFrame = 0;}
    
          previousFrame = currentFrame;
          return imageArray[currentFrame].getImage();
        }
	}
	
	public Image getZombieAniImageAngry() {
		imageArrayAngry = new ImageIcon[totalFrameAngry];
	    for (int i = 0; i < imageArrayAngry.length; i++) {
		      imageArrayAngry[i] = new ImageIcon("ImageSource\\ZombieNews\\ZomNewsAngry" + i + ".png");}
       
      
        while(true){ 
        	 if (currentFrameAngry == previousFrameAngry) {
		    		currentFrameAngry++;}
		      if (currentFrameAngry >= imageArrayAngry.length) {
		        currentFrameAngry = 0;}
		      previousFrameAngry = currentFrameAngry;
		      return imageArrayAngry[currentFrameAngry].getImage();}}
	
	public Image getZombieAniImageEat() {
		imageArrayEat = new ImageIcon[totalFrameEat];
	    
	    for (int i = 0; i < imageArrayEat.length; i++) {
		      imageArrayEat[i] = new ImageIcon("ImageSource\\ZombieNews\\ZomNewsEat" + i + ".png");}
        while(true){ 
        		if (currentFrameEat == previousFrameEat) {
    		    		currentFrameEat++;}
    		      if (currentFrameEat >= imageArrayEat.length) {
    		        currentFrameEat = 0;}
    		      previousFrameEat = currentFrameEat;
    		      return imageArrayEat[currentFrameEat].getImage();

        }
	}
}
