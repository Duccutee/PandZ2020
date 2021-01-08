package PlantvsZombie;
import java.awt.*;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Zombie extends Sprite{

/*  private ImageIcon imageArray[];
  private ImageIcon imageArrayEat[];
  private int totalFrame = 27, currentFrame = 0, previousFrame = -1;
  private int totalFrameEat = 12, currentFrameEat = 0, previousFrameEat = -1;
  private int healthZombie = 200;
  private int DamagePerEat = 1;
  private int count = 3;
  public static int totalZombieCreate = 0;
  public static int zombieToCreate = 5;
  public static int zombieHaveDied = 0;*/

	private int healthZombie;
	private int DamagePerEat;
	private int velocity;

public Zombie(int x, int y, int width, int height) {
		super(x, y, width, height);}
   
   public void healthAttact(int damageOfProjectile) {healthZombie = healthZombie - damageOfProjectile;}
   public int getVelocity() {return velocity;}
   public void setVelocity(int velocity) {this.velocity = velocity;}



public int getHealth() {
	return healthZombie;
}

public int getLane() {
	  if(y==25) return 1;
	  else if(y== 115) return 2;
	  else if(y==215) return 3;
	  else if (y==295) return 4;
	  else return 5;
}

public void setHealth(int healthZombie) {
	this.healthZombie = healthZombie;
}

public int getDamagePerEat() {return DamagePerEat;}

public void setDamagePerEat(int damagePerEat) {DamagePerEat = damagePerEat;}

@Override
   public Rectangle getBound(){
	    return new Rectangle(x,y+50,width,height);
	  }
   public void drawBound(Graphics g) {
		  g.drawRect(x,y+50,width,height);
	  }
   
   public abstract void drawAni(Graphics g);
//  g.drawImage(getZombieAniImage(),x,y,null);}


  public boolean checkCollisionWithPlant() {
	  ArrayList <Plant> plants = TapVeDemo.getPlantList();
	      for (int k = 0; k < plants.size();k++) {
	    	  Plant tempPlant = plants.get(k);
	    	  isZomEating(this, tempPlant);
		    	if(isZomEating(this, tempPlant)){
		    		x=tempPlant.getX()+tempPlant.getWidth()-1; //tai_sao_+39 thi dung lai an con >40 thi di tiep k an???
		    		//ANSWER: vi cach qua xa se khong collision thi phai move
		    		if(tempPlant.getHealth()!=0) {
		    			//System.out.printf("Health of Plant %d at begin: %d\t",k, tempPlant.getHealth());
				    	//System.out.println("COLLISIONBETWEENPLantsVSZ\t");
		    			tempPlant.healthAttact(getDamagePerEat());
		    			System.out.println("Damage Per Eat: "+getDamagePerEat()); //to be suitable with every kind of zombie
		    			//System.out.printf("Health of Plant %d after being eaten: %d\n\n",k, tempPlant.getHealth());
		    			return true;}
	    	 
	    	  if(tempPlant.getHealth()==0) {
	    		  TapVeDemo.getBox().recievePoint(tempPlant.getX(), tempPlant.getY());
	    		  TapVeDemo.removePlant(tempPlant);}
	      }
	    }
		return false;
	  }
  
  public boolean checkCollisionWithVegan() {
	  ArrayList <Vegan> vegans = TapVeDemo.getVeganList();
	      for (int k = 0; k < vegans.size();k++) {
	    	  Vegan tempVegan = vegans.get(k);
	    	  isZomEatingVegan(this, tempVegan);
		    	if(isZomEatingVegan(this, tempVegan)){
		    		x=tempVegan.getX()+tempVegan.getWidth()-1; 
		    		if(tempVegan.getHp()!=0) {
		    			tempVegan.healthAttact(getDamagePerEat());
		    			System.out.println("Damage Per Eat: "+getDamagePerEat()); 
		    			return true;}
	    	 
	    	  if(tempVegan.getHp()==0) {
	    		  TapVeDemo.getBox().recievePoint(tempVegan.getX(), tempVegan.getY());
	    		  TapVeDemo.removeVegan(tempVegan);}
	      }
	    }
		return false;
	  }
  
  public boolean checkCollisionWithSunFlower() {
	  ArrayList <Sunflower> sunFlowers = TapVeDemo.getSunFlowerList();
	      for (int k = 0; k < sunFlowers.size();k++) {
	    	  Sunflower tempSunfl = sunFlowers.get(k);
	    	  isZomEatingSunFlower(this, tempSunfl );
		    	if(isZomEatingSunFlower(this, tempSunfl)){
		    		x=tempSunfl .getX()+tempSunfl.getWidth()-1;
		    		if(tempSunfl .getHp()!=0) {
		    			tempSunfl.Hp(getDamagePerEat());
		    			//System.out.printf("Health of Sunfl %d after being eaten: %d\n\n",k, tempSunfl.getHp());
		    			return true;}
	    	 
	    	  if(tempSunfl.getHp()==0) {
	    		  TapVeDemo.getBox().recievePoint(tempSunfl.getX(), tempSunfl.getY());
	    		 
	    		  TapVeDemo.removeSunFlower(tempSunfl);}
	      }
	    }
		return false;
	  }
  
  public boolean isZomEating(Zombie tempZ, Plant tempP) {
	  if(tempZ.getBound().intersects(tempP.getBound())){
	  return true;}
	return false;}
  
  public boolean isZomEatingSunFlower(Zombie tempZ, Sunflower tempS) {
	  if(tempZ.getBound().intersects(tempS.getBound())){
	  return true;}
	return false;}
  
  public boolean isZomEatingVegan(Zombie tempZ, Vegan tempV) {
	  if(tempZ.getBound().intersects(tempV.getBound())){
	  return true;}
	return false;}
  
  public abstract void move();
//  public abstract Image getZombieAniImage();
}
