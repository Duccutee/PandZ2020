package PlantvsZombie;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

/*public class Plant extends JPanel {
    
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(10,250,40,50);
     
    }
}*/

public class Plant extends Sprite{
	Timetest tt = new Timetest();
//	Timer timeToShoot = new Timer();
	static ArrayList<Projectile> projectiles = new ArrayList<>();
	
    private ImageIcon imageArray[];
    private int totalFrame = 30, currentFrame = 0, previousFrame = -1;
    private int healthPlant = 300, wait=120;
  
    public Plant(int x, int y, int width, int height) {
        super(x, y, width, height);
        // TODO Auto-generated constructor stub
    }
    public void healthAttact(int damageOfZombie) {
 	   healthPlant = healthPlant - damageOfZombie;
    }
    public int getHealth() {return healthPlant; }
    
    public boolean isZombieHere() {
     	 ArrayList<Zombie> zombies = TapVeDemo.getZombieList();
     	 int yOfPlant = this.getY();
     	// System.out.println("y of Plant: "+this.getY());
     	 switch (yOfPlant) {
     	 	case 70: 
     	 		if (tt.amountZInLane0>0) return true; 
     	 		else return false; 
     	 	case 165: 
     	 		if (tt.amountZInLane1>0) return true; 
     	 		else return false;
     	 	case 260: 
     	 		if (tt.amountZInLane2>0) return true; 
     	 		else return false;
     	 	case 355: 
     	 		if (tt.amountZInLane3>0) return true; 
     	 		else return false;
     	 	case 450: 
     	 		if (tt.amountZInLane4>0) return true; 
     	 		else return false;
     	 	default: return false;
     	 }}
      
    public void LoopToShoot() {
		wait--;
		if(wait<=0) {
			if(isZombieHere()) Plant.addProjectile(new Projectile(this.getX()+75, this.getY()+20, 20, 20));
			this.wait=120;
		}
	}
    public void drawAni(Graphics g){
        g.drawImage(getAniImage(),x,y,null);}
      
      public Image getAniImage(){
        imageArray = new ImageIcon[totalFrame];
      
          for (int i = 0; i < imageArray.length; i++) {
          imageArray[i] = new ImageIcon("ImageSource\\PlantImage\\PeaShooter" + i + ".png");}
        
          while(true){ 
        	if (currentFrame == previousFrame) {currentFrame++;}
      
            if (currentFrame >= imageArray.length) {
              currentFrame = 0;}
      
            previousFrame = currentFrame;
            return imageArray[currentFrame].getImage();
          }
        }
      
      public static void addProjectile(Projectile pr) {
		    projectiles.add(pr);}
	
	   public static void removeProjectile(Projectile pr){
		   projectiles.remove(pr);}
		  
	   public static ArrayList<Projectile> getProjectileList() {
		    return projectiles;}


}
