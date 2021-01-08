
package PlantvsZombie;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Sound{
	void playMusic(String musicLocation) {
	 try {
		 File musicPath = new File (musicLocation);
		 if (musicPath.exists()) {
			 AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			 Clip clip = AudioSystem.getClip();
			 clip.open(audioInput);
			 clip.start();
			// clip.loop(Clip.LOOP_CONTINUOUSLY);
			 System.out.println("O BOX: "+Box.soundOn);
			 if(Box.soundOn==false) {System.out.println("DA TAT SOUND");clip.stop();}
			 
			 /**JOptionPane.showMessageDialog(null,  "Hit ok to pause");
			 long clipTimePosition = clip.getMicrosecondPosition();
			 clip.stop();
			 
			 JOptionPane.showMessageDialog(null,  "Hit ok to resume");
			 clip.getMicrosecondPosition();
			 clip.start();
			 
		 	JOptionPane.showMessageDialog(null, "Press ok to stop playing");**/
	 }
			 else {
				 System.out.println("ERROR");
			 	  }}catch (Exception ex) {
		ex.printStackTrace();
	}
 }
	/**
	 * Run sound.
	 */
/*	private static void SoundActive() {
		String filepath = "Music/music.wav";
		Sound musicObject = new Sound();
		musicObject.playMusic(filepath);
		
	}*/
}