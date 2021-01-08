package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BucketZom extends Zombie {
	private ImageIcon imageArray[];
	  private ImageIcon imageArrayEat[];
	
	  private int totalFrame = 9, currentFrame = 0, previousFrame = -1;
	  private int totalFrameEat = 12, currentFrameEat = 0, previousFrameEat = -1;
	 // private int healthZombie = 200;
	  //private int DamagePerEat = 1;
	  private int count = 7;
	  public static int totalZombieCreate = 0;
	  public static int zombieToCreate = 2;
	  public static int zombieHaveDied = 0;
	  //private int velocity = 1;
	  
	  private static int i=0, b=0, mw;
	  private BufferedImage newsZombieImage, sprite;
	
	public BucketZom(int x, int y, int width, int height) {
		super(x, y, width, height);
		totalZombieCreate++;
		setHealth(200);
		setVelocity(3);
		setDamagePerEat(1);
		System.out.println("DA TAO BUCKET ZOM");
	}
	
	@Override
	 public void drawAni(Graphics g){
		if((checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan())&&(this.getHealth()>=100)) {
			try {sprite= ImageIO.read(new File("ImageSource/ZombieBucket/BucketZombieEat.png"));
		newsZombieImage = sprite.getSubimage(i, 0, 100, 160);} 
		catch (IOException e) {e.printStackTrace();}
		i+=100;
		if(i==1200)i=0;}
		
		else if((this.getHealth()<100)&&(checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan())) {
			try {sprite= ImageIO.read(new File("ImageSource/ZombieBucket/BucketZombieEatWithout.png"));
			newsZombieImage = sprite.getSubimage(i, 0, 100, 160);} 
			catch (IOException e) {e.printStackTrace();}
			i+=100;
			if(i==1200)i=0;
		}
		
		else if(this.getHealth()<100){
			try {sprite = ImageIO.read(new File("ImageSource/ZombieBucket/BucketZombieMoveWithout.png"));
			newsZombieImage = sprite.getSubimage(mw, 0, 91, 160);} 
			catch (IOException e) {e.printStackTrace();}
			mw+=91;
			if(mw==2457)mw=0;} 
		
		else {
			try {sprite= ImageIO.read(new File("ImageSource/ZombieBucket/BucketZombieMove.png"));
			newsZombieImage = sprite.getSubimage(b, 0, 91, 160);} 
			catch (IOException e) {e.printStackTrace();}
			b+=91;
			if(b==2457)b=0;}
		g.drawImage(newsZombieImage,x,y,null);}
	
	
	 public void move() {
		 count--;
		 if(count<=0) {
	    x = x - getVelocity();
	    count = 7;}
	  }

	
/*	public Image getZombieAniImage(){
		  imageArray = new ImageIcon[totalFrame];
		  imageArrayEat = new ImageIcon[totalFrameEat];

		    for (int i = 0; i < imageArrayEat.length; i++) {
		      imageArrayEat[i] = new ImageIcon("D:\\ImageSource\\ZombieNormal\\ZomNorEat" + i + ".png");}

		    for (int i = 0; i < imageArray.length; i++) {
		      imageArray[i] = new ImageIcon("D:\\ImageSource\\ZombieBucket\\ZomBucket" + i + ".png");}
		  
		    while(true){ if(checkCollisionWithPlant()||checkCollisionWithSunFlower()) {
		    		      if (currentFrameEat == previousFrameEat) {
		    		    		currentFrameEat++;}
		    		      if (currentFrameEat >= imageArrayEat.length) {
		    		        currentFrameEat = 0;}
		    		      previousFrameEat = currentFrameEat;
		    		      return imageArrayEat[currentFrameEat].getImage();}

		      if (currentFrame == previousFrame) {currentFrame++;}
		      if (currentFrame >= imageArray.length) {
		        currentFrame = 0;}

		      previousFrame = currentFrame;
		      return imageArray[currentFrame].getImage();
		    }
		}*/
}
