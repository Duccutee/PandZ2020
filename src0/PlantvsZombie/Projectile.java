package PlantvsZombie;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

 public class Projectile extends Plant{
	 private int DamagePerShot = 20;
	 

   public Projectile(int x, int y, int width, int height) {
      super(x, y, width, height);
   }
   
   public void checkCollisionWithZombie() {
	    ArrayList<Zombie> zombies = TapVeDemo.getZombieList();
	 
	    for (int i = 0; i < zombies.size(); i++){
	      Zombie tempZombie = zombies.get(i); 	      
		if(getBound().intersects(tempZombie.getBound())){
	    	  System.out.printf("Health of Zombie %d at begin: %d\t",i, tempZombie.getHealth());
	    	  System.out.println("COLLISIONBETWEENPVSZ\t");
	    	  tempZombie.healthAttact(DamagePerShot);
	    	  Plant.removeProjectile(this);
	  
	    	  System.out.printf("Health of Zombie %d when collision: %d\n\n",i, tempZombie.getHealth());
	    	  if(tempZombie.getHealth()==0) {TapVeDemo.removeZombie(tempZombie);}
	      }
	    }
	  }
   public void draw(Graphics g){
	    g.drawImage(getProjectileImage(),x,y,null);}

	   public Image getProjectileImage(){
	    ImageIcon icon = new ImageIcon("ImageSource\\Pea.png");
	    return icon.getImage();}
	   
   public void move(int velocity) {x = x + velocity ;}

 }
