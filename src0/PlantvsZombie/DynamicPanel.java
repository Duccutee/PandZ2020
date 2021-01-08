package PlantvsZombie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DynamicPanel  extends JPanel  {
	  static TapVeDemo tapVeDemo = new TapVeDemo();
	 static BackMenu backMenu = new BackMenu();
	 
	  
	 public DynamicPanel() {
	        init();
	    }
	 private void init() {
		 add(tapVeDemo);
	    }

	 public void setPanel(JPanel pn) {
		removeAll();
		add(pn);
		repaint();
		revalidate();
	    }
	 
	
}
