package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class NormalZom extends Zombie {
	private ImageIcon imageArray[];
	  private ImageIcon imageArrayEat[];
	  private int totalFrame = 27, currentFrame = 0, previousFrame = -1;
	  private int totalFrameEat = 12, currentFrameEat = 0, previousFrameEat = -1;
	 // private int healthZombie = 200;
	  //private int DamagePerEat = 1;
	  private int count = 7;
	  public static int totalZombieCreate = 0;
	  public static int zombieToCreate = 2;
	  public static int zombieHaveDied = 0;
	  //private int velocity = 1;
	
	public NormalZom(int x, int y, int width, int height) {
		super(x, y, width, height);
		setHealth(200);
		setVelocity(1);
		setDamagePerEat(1);
		totalZombieCreate++;
		System.out.println("DA TAO NORMAL ZOM");
	}
	 public void move() {
		 count--;
		 if(count<=0) {
	    x = x - getVelocity();
	    count = 7;}
	  }
	public void drawAni(Graphics g){
		  g.drawImage(getZombieAniImage(),x,y,null);}
	
	public Image getZombieAniImage(){
		  imageArray = new ImageIcon[totalFrame];
		  imageArrayEat = new ImageIcon[totalFrameEat];

		    for (int i = 0; i < imageArrayEat.length; i++) {
		      imageArrayEat[i] = new ImageIcon("ImageSource\\ZombieNormal\\ZomNorEat" + i + ".png");}

		    for (int i = 0; i < imageArray.length; i++) {
		      imageArray[i] = new ImageIcon("ImageSource\\ZombieNormal\\ZombieNormal" + i + ".png");}
		  
		    while(true){ if(checkCollisionWithPlant()||checkCollisionWithSunFlower()||checkCollisionWithVegan()) {
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
		}
}
