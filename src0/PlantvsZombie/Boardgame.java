package PlantvsZombie;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Boardgame {
	//ArrayList gameField = new ArrayList<>();
	int gridW = 95, gridH = 95;
	int column = 9, row = 5;
	int isContain = 0;
	int xOfStartPoint, yOfStartPoint, xOfEndPoint, yOfEndPoint;
	static int xCenter, yCenter;
	int xCenterOfSunfl, yCenterOfSunfl; 
	int xCenterOfVegan, yCenterOfVegan; 
	int xMouseMoving, yMouseMoving;
	static int xCanAdd, yCanAdd, yCanShovel, xCanShovel;
	static int alreadyShovel; 
	
	public int getxCanAdd() {
		return xCanAdd;
	}

	public void setxCanAdd(int xCanAdd) {
		this.xCanAdd = xCanAdd;
	}

	public int getyCanAdd() {
		return yCanAdd;
	}

	public void setyCanAdd(int yCanAdd) {
		this.yCanAdd = yCanAdd;
	}

	public int getXCenterOfSunfl() {
		System.out.println("X Center: "+xCenter);
		return xCenter+10;}
	
	public int getYCenterOfSunfl() {
		System.out.println("Y Center: "+yCenter);
		return yCenter+15;}
	
	public int getXCenterOfVegan() {
		System.out.println("X Center: "+xCenter);
		return xCenter;}
	
	public int getYCenterOfVegan() {
		System.out.println("Y Center: "+yCenter);
		return yCenter;}
	
	
	public int getYCenterOfPlant() {
		return yCenter;
	}
	public int getXCenterOfPlant() {
		return xCenter;
	}
	

	public int getxMouseMoving() {
		return xMouseMoving;
	}

	public int getyMouseMoving() {
		return yMouseMoving;
	}


	//[0][0] = 290, 70: 290 + 95, 70 + 95
	public int gameField[][] = new int [column][row];
	int xSpace = 290, ySpace = 70;
	public int[][] getGameField() {
		return gameField;
	}
	public void setGameField(int[][] gameField) {
		this.gameField = gameField;
	}
	public Boardgame() {
		setUpGrid();
	}
	public void draw(Graphics g){
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
				g.drawRect(xSpace+k*gridW,ySpace+i*gridH,gridW,gridH);
		
		if((Box.clickBoxOrNot==1)&&(Box.callWhereIsMouse()==true)) {
		g.drawImage(getLaneHorImage(),290,yCanAdd,null);
		g.drawImage(getLaneVerImage(),xCanAdd,70,null);}
		
		if((Box.clickShovelOrNot==1)&&(Box.placeCanShovel()==true)) {
			g.drawImage(getLaneHorImage(),290,yCanShovel,null);
			g.drawImage(getLaneVerImage(),xCanShovel,70,null);}
	}

	   public Image getLaneHorImage(){
	    ImageIcon icon = new ImageIcon("ImageSource/LaneHor.png");
	    return icon.getImage();}
	   
	   public int getxOfStartPoint() {
		return xOfStartPoint;
	}

	public void setxOfStartPoint(int xOfStartPoint) {
		this.xOfStartPoint = xOfStartPoint;
	}

	public int getyOfStartPoint() {
		return yOfStartPoint;
	}

	public void setyOfStartPoint(int yOfStartPoint) {
		this.yOfStartPoint = yOfStartPoint;
	}

	public Image getLaneVerImage(){
		    ImageIcon icon = new ImageIcon("ImageSource/LaneVer.png");
		    return icon.getImage();}
	
	public boolean checkUpGrid(int i, int k) {
		if (gameField[k][i]==0) {System.out.println("Empty Ground at: ["+i+","+k+"]");return true; }
		else {System.out.println("Full ground at: ["+i+","+k+"]");return false; }
	}
	public void addToGrid(int i, int k) {
		isContain = 1;
		gameField[k][i]= isContain;
	}
	
	public void removeFromGrid(int i, int k) {
		isContain = 0;
		gameField[k][i] = isContain;
	}
	
	public void setUpGrid() {
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
				gameField[k][i]= 0;
		System.out.println("DAT TRONG 45 O:");
		tinhTrangDat();
	}
	public void tinhTrangDat() {
		for(int i=0; i < row; i++) {
			for(int k=0; k<column; k++)
				System.out.printf("At"+"["+i+","+k+"]: "+gameField[k][i]+"\t");
			System.out.println();}
		System.out.println();
	}
	public int xCenterOfGrid(int k) {
		 xCenter = xSpace+k*gridW; return xCenter;
	}
	
	public int yCenterOfGrid(int i) {
		yCenter = ySpace+i*gridH; return yCenter; }
	

	public boolean checkpointInWhichGrid(int xMouse, int yMouse) {
		int enable = 0;
		System.out.println("VO R MA");
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
			{
				xOfStartPoint = xSpace+k*gridW;
				yOfStartPoint = ySpace+i*gridH;
				xOfEndPoint = xSpace+k*gridW + gridW;
				yOfEndPoint =  ySpace+i*gridH + gridH;
				if ((xOfStartPoint <= xMouse)&&(xMouse <= xOfEndPoint)&&(yOfStartPoint<=yMouse)&&(yMouse<=yOfEndPoint)) 
				{
		
					if (checkUpGrid(i,k)==true) {
						addToGrid(i,k); xCenterOfGrid(k); yCenterOfGrid(i); System.out.println("DUOC ADD VI TRONG"); enable = 1;}
					else {System.out.println("KHONG"); 
					//Box.clickBoxOrNot =0; //Vi chi = 0 khi da dat chuot xuong
					//enable = 0;
					}}
				else Box.clickBoxOrNot = 0;
						
			}
		tinhTrangDat();
		if (enable==1) return true;
		else return false;
	}
	
	public boolean checkGridToShovel(int xMouse, int yMouse) {
		int enable = 0;
		System.out.println("VO R MA");
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
			{
				xOfStartPoint = xSpace+k*gridW;
				yOfStartPoint = ySpace+i*gridH;
				xOfEndPoint = xSpace+k*gridW + gridW;
				yOfEndPoint =  ySpace+i*gridH + gridH;
				if ((xOfStartPoint <= xMouse)&&(xMouse <= xOfEndPoint)&&(yOfStartPoint<=yMouse)&&(yMouse<=yOfEndPoint)) 
				{
		
					if (checkUpGrid(i,k)==false) {
						removeFromGrid(i,k); xCenterOfGrid(k); yCenterOfGrid(i); 
						System.out.println("DA DUOC XOA KHOI GRID"); enable = 1;}
					else {System.out.println("KHONG CO GI DE XOA"); 
					//Box.clickBoxOrNot =0; //Vi chi = 0 khi da dat chuot xuong
					//enable = 0;
					}}
				else Box.clickShovelOrNot = 0;
						
			}
		tinhTrangDat();
		if (enable==1) return true;
		else return false;
	}
	public int whichPlantIsThat() {
		int plantNumb = -1 ;
		 ArrayList <Plant> plants = TapVeDemo.getPlantList();
		 
	      for (int k = 0; k < plants.size();k++) {
	    	  Plant tempPlant = plants.get(k);
	    	  if((tempPlant.getX()==getXCenterOfPlant()) && (tempPlant.getY()==getYCenterOfPlant()))
	    	  plantNumb = k;}
		return plantNumb;
	}
	
	public int whichSunflIsThat() {
		int sunFlowerNumb = -1;
		 ArrayList <Sunflower> sunFlowers = TapVeDemo.getSunFlowerList();
	
	      for (int k = 0; k < sunFlowers.size();k++) {
	    	  Sunflower tempSunfl = sunFlowers.get(k);
	    	  if((tempSunfl.getX()==getXCenterOfSunfl()) && (tempSunfl.getY()==getYCenterOfSunfl()))
	    		  sunFlowerNumb = k;}
		return sunFlowerNumb;
	}
	
	public int whichVeganIsThat() {
		int veganNumb = -1;
		 ArrayList <Vegan> vegans = TapVeDemo.getVeganList();
	
	      for (int k = 0; k < vegans.size();k++) {
	    	  Vegan tempVegan = vegans.get(k);
	    	  if((tempVegan.getX()==getXCenterOfVegan()) && (tempVegan.getY()==getYCenterOfVegan()))
	    		  veganNumb = k;}
		return veganNumb;
	}
	
	public boolean whereisMouse() {
		xMouseMoving = TapVeDemo.getPointX()-126;
		yMouseMoving = TapVeDemo.getPointY()-120;
		int enable = 0;
		if(Box.clickBoxOrNot==1) {
		//	System.out.println("Click ROI");
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
			{
				xOfStartPoint = xSpace+k*gridW;
				yOfStartPoint = ySpace+i*gridH;
				xOfEndPoint = xSpace+k*gridW + gridW;
				yOfEndPoint =  ySpace+i*gridH + gridH;
				if ((xOfStartPoint <= xMouseMoving) && (xMouseMoving <= xOfEndPoint) && (yOfStartPoint<=yMouseMoving) && (yMouseMoving<=yOfEndPoint)) 
				{
					System.out.println("X,Y: "+xMouseMoving+","+yMouseMoving+"i,k: "+i+k);
					//checkUpGrid(i,k);
					if (checkUpGrid(i,k)==true) {enable = 1;
					xCanAdd = xOfStartPoint;
					yCanAdd = yOfStartPoint;
					System.out.println("TRONG HIEN CO THE ADD");}
					else System.out.println("KHONG TRONG");
					}
			}}
		if (enable==1) return true;
		else return false;
	}
	
	
	public boolean whereisMouseToShovel() {
		xMouseMoving = TapVeDemo.getPointX()-126;
		yMouseMoving = TapVeDemo.getPointY()-120;
		int enable = 0;
		if(Box.clickShovelOrNot==1) {
		//	System.out.println("Click ROI");
		for(int i=0; i < row; i++) 
			for(int k=0; k<column; k++)
			{
				xOfStartPoint = xSpace+k*gridW;
				yOfStartPoint = ySpace+i*gridH;
				xOfEndPoint = xSpace+k*gridW + gridW;
				yOfEndPoint =  ySpace+i*gridH + gridH;
				if ((xOfStartPoint <= xMouseMoving) && (xMouseMoving <= xOfEndPoint) && (yOfStartPoint<=yMouseMoving) && (yMouseMoving<=yOfEndPoint)) 
				{
					System.out.println("X,Y: "+xMouseMoving+","+yMouseMoving+"i,k: "+i+k);
					//checkUpGrid(i,k);
					if (checkUpGrid(i,k)==false) {enable = 1;
					xCanShovel = xOfStartPoint;
					yCanShovel = yOfStartPoint;
					System.out.println("PLANT IS HERE CAN BE SHOVELED");}
					else System.out.println("CANNOT BE BECAUSE NOT PLANT");
					}
			}}
		if (enable==1) return true;
		else return false;
	}
	
	
	public void findPlantInWhichGrid(int xPlantPos, int yPlantPos) {
		System.out.println("Current circumstance: ");
		tinhTrangDat();
		for(int i = 0; i < row; i++) 
			for(int k = 0; k < column; k++)
			{
				xOfStartPoint = xSpace + k * gridW;
				yOfStartPoint = ySpace + i * gridH;
				xOfEndPoint = xSpace + k * gridW + gridW;
				yOfEndPoint =  ySpace + i * gridH + gridH;
				if ((xOfStartPoint <= xPlantPos) && (xPlantPos <= xOfEndPoint) && (yOfStartPoint<=yPlantPos) && (yPlantPos<=yOfEndPoint)) 
				{
					System.out.println("Plant at"+"["+i+","+k+"]");
					removeFromGrid(i,k);
					System.out.println("AfTER CLEAR THAT PLANT");
					
				}
				tinhTrangDat();
			}}
}
