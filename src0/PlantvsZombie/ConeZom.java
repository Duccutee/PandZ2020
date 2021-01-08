package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ConeZom extends Zombie {
	private ImageIcon imageArray[], imageArrayNoCone[];
	  private ImageIcon imageArrayEat[];
	  private int totalFrame = 9, currentFrame = 0, previousFrame = -1;
	  private int totalFrameNoCone = 9, currentFrameNoCone = 0, previousFrameNoCone = -1;
	  private int totalFrameEat = 6, currentFrameEat = 0, previousFrameEat = -1;
	 
	  private int count = 7;
	  public static int totalZombieCreate = 0;
	  public static int zombieToCreate = 2;
	  public static int zombieHaveDied = 0;

	
	public ConeZom(int x, int y, int width, int height) {
		super(x, y, width, height);
		setHealth(300);
		setVelocity(2);
		setDamagePerEat(1);
		totalZombieCreate++;
		System.out.println("DA TAO CONE ZOM");
	}
	// @Override
	  // public Rectangle getBound(){
		//    return new Rectangle(x,y+100,width,height);
		  //}
	
	@Override

	 public void move() {
		 count--;
		 if(count<=0) {
	    x = x - getVelocity();
	    count = 7;}
	  }
	
	public Image getZombieAniImage(){
		  imageArray = new ImageIcon[totalFrame];
		  imageArrayEat = new ImageIcon[totalFrameEat];
		  imageArrayNoCone = new ImageIcon[totalFrameNoCone];

		    for (int i = 0; i < imageArrayEat.length; i++) {
		      imageArrayEat[i] = new ImageIcon("D:\\ImageSource\\ZombieCone\\ZomConeEat" + i + ".png");}

		    for (int i = 0; i < imageArray.length; i++) {
		      imageArray[i] = new ImageIcon("D:\\ImageSource\\ZombieCone\\ZomCone" + i + ".png");}
		    
		    for (int i = 0; i < imageArrayNoCone.length; i++) {
			      imageArrayNoCone[i] = new ImageIcon("D:\\ImageSource\\ZombieCone\\ZomConeWithout" + i + ".png");}
		  
		    while(true){ if((checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan())&&(this.getHealth()>(getHealth()/2))) {
		    		      if (currentFrameEat == previousFrameEat) {
		    		    		currentFrameEat++;}
		    		      if (currentFrameEat >= imageArrayEat.length) {
		    		        currentFrameEat = 0;}
		    		      previousFrameEat = currentFrameEat;
		    		      return imageArrayEat[currentFrameEat].getImage();}
		    
		    if((checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan())&&(this.getHealth()<=150)) {
		    	if (currentFrameEat == previousFrameEat) {
		    		currentFrameEat++;}
		      if (currentFrameEat >= imageArrayEat.length) {
		        currentFrameEat = 0;}
		      previousFrameEat = currentFrameEat;
		      return imageArrayEat[currentFrameEat].getImage();}
		    
		    if(this.getHealth()<150) {
		    	if (currentFrameNoCone == previousFrameNoCone) {
		    		currentFrameNoCone++;}
		      if (currentFrameNoCone >= imageArrayNoCone.length) {
		        currentFrameNoCone = 0;}
		      previousFrameNoCone = currentFrameNoCone;
		      return imageArrayNoCone[currentFrameNoCone].getImage();}
		    

		      if (currentFrame == previousFrame) {currentFrame++;}
		      if (currentFrame >= imageArray.length) {
		        currentFrame = 0;}

		      previousFrame = currentFrame;
		      return imageArray[currentFrame].getImage();
		    }
		}
	@Override
	public void drawAni(Graphics g) {
		g.drawImage(getZombieAniImage(),x,y,null);
	}
}

