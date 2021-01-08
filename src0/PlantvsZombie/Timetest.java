package PlantvsZombie;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Timetest{
	ArrayList<Zombie> zombies = TapVeDemo.getZombieList();
    ArrayList<Projectile> projectiles = Plant.getProjectileList();
    ArrayList<Plant> plants = TapVeDemo.getPlantList();
  //  ArrayList<Timetest> times = Screen.getTimeList();
    
   // LaneObject <Zombie> laneZombie0 = TapVeDemo.getZombieList0();
    int[] yOfLane = new int[] {25, 115, 215, 295, 395};
    static boolean canAddZomNor =true, canAddZomBuc =true, canAddZomCone=true, canAddZomNews = true; 
    
    static int amountZInLane0, amountZInLane1, amountZInLane2, amountZInLane3,amountZInLane4;
    
  //  public Timetest() {
   // 	Screen.addTime(this);
   // }
	public int[] getyOfLane() {
		return yOfLane;
	}
	public void reStartTimetest() {
		Timer timeToAddZombie = new Timer();
		Timer timeToAddSun = new Timer();
		Timer timeToAddNewsZombie = new Timer();
		Timer timeToAddBucZombie = new Timer();
		Timer timeGame = new Timer();
	}
	public void setyOfLane(int[] yOfLane) {
		this.yOfLane = yOfLane;
	}
	Random rand = new Random();
    
    public static int secondPassed=0;
/*	static Timer timeToAddZombie = new Timer();
	static Timer timeToAddSun = new Timer();
	static Timer timeToAddNewsZombie = new Timer();
	static Timer timeToAddBucZombie = new Timer();
	static Timer timeToAddConeZombie = new Timer();
	static Timer timeGame = new Timer();*/
    
	
	public static int getSecondPassed() {
		return secondPassed;
	}
	/***/
	
	
/*	TimerTask taskGame = new TimerTask() {
		
		public void run() {
		if(DynamicPanel.tapVeDemo.isRun()){	
			secondPassed++;
			System.out.printf("Second pass: %d\n",secondPassed);
			}}
	};*/
	
	TimerTask tasktoSun = new TimerTask(){
		public void run() {
			if(DynamicPanel.tapVeDemo.isRun()) {
			TapVeDemo.addSun(new Sun());
		}
	}
	};
	TimerTask taskToAddZombie = new TimerTask() {
		public void run() {
			if(DynamicPanel.tapVeDemo.isRun()){	
		int lane=rand.nextInt(5);
		if (lane == 0 ) amountZInLane0 ++;
		else if (lane==1) amountZInLane1 ++;
		else if (lane == 2) amountZInLane2 ++;
		else if (lane == 3) amountZInLane3 ++;
		else amountZInLane4 ++;
		TapVeDemo.addZombie(new NormalZom(1250, yOfLane[lane], 10, 80));
		}}
	};
	TimerTask taskToAddNewsZombie = new TimerTask() {
		public void run() {
			if(DynamicPanel.tapVeDemo.isRun()){	
		int lane=rand.nextInt(5);
		if (lane == 0 ) amountZInLane0 ++;
		else if (lane==1) amountZInLane1 ++;
		else if (lane == 2) amountZInLane2 ++;
		else if (lane == 3) amountZInLane3 ++;
		else amountZInLane4 ++;
		TapVeDemo.addZombie(new NewspaperZom(1250, yOfLane[lane], 10, 80));
		}}
	};
	TimerTask taskToAddBucZombie = new TimerTask() {
		public void run() {
			if(DynamicPanel.tapVeDemo.isRun()){	
		int lane=rand.nextInt(5);
		if (lane == 0 ) amountZInLane0 ++;
		else if (lane==1) amountZInLane1 ++;
		else if (lane == 2) amountZInLane2 ++;
		else if (lane == 3) amountZInLane3 ++;
		else amountZInLane4 ++;
		TapVeDemo.addZombie(new BucketZom(1250, yOfLane[lane]-10, 10, 80));
		}}
	};
	TimerTask taskToAddConeZombie = new TimerTask() {
		public void run() {
			if(DynamicPanel.tapVeDemo.isRun()){	
		int lane=rand.nextInt(5);
		if (lane == 0 ) amountZInLane0 ++;
		else if (lane==1) amountZInLane1 ++;
		else if (lane == 2) amountZInLane2 ++;
		else if (lane == 3) amountZInLane3 ++;
		else amountZInLane4 ++;
		TapVeDemo.addZombie(new ConeZom(1250, yOfLane[lane]-30, 10, 80));
		}}
	};
	
	/*public void startAddZombie() {
	timeToAddZombie.scheduleAtFixedRate(taskToAddZombie, 20000, 15000);
	timeToAddBucZombie.scheduleAtFixedRate(taskToAddBucZombie, 25000, 16000);
	timeToAddConeZombie.scheduleAtFixedRate(taskToAddConeZombie, 36000, 25000);
	timeToAddNewsZombie.scheduleAtFixedRate(taskToAddNewsZombie, 40000, 30000);
	}*/
	
	
/*	public static void stopAddBucZombie() {
		timeToAddBucZombie.cancel();
		timeToAddBucZombie.purge();
		
	}
	public static void stopAddConeZombie() {
		timeToAddConeZombie.cancel();
		timeToAddConeZombie.purge();
	}
	public static void stopAddZombie() {
		timeToAddZombie.cancel();
		timeToAddZombie.purge();
	}
	public static void stopAddNewsZombie() {
		timeToAddNewsZombie.cancel();
		timeToAddNewsZombie.purge();
	}*/
	
/*	public static void canStopAddZombie() {
		//System.out.println("zombieToCreate: "+ BucketZom.zombieToCreate);
		//System.out.println("ZombieDaTao: "+ BucketZom.totalZombieCreate);
		if(NewspaperZom.totalZombieCreate >= NewspaperZom.zombieToCreate) stopAddNewsZombie();
		if(NormalZom.totalZombieCreate >= NormalZom.zombieToCreate) stopAddZombie();
		if(BucketZom.totalZombieCreate >= BucketZom.zombieToCreate) stopAddBucZombie(); 
		if(ConeZom.totalZombieCreate >= ConeZom.zombieToCreate) stopAddConeZombie();
		
	
	}*/
	
/*	public void start() {
		if(DynamicPanel.tapVeDemo.run) {
		startGame();
		startAddSun();
		startAddZombie();}
	}*/
	public static boolean canStopAddZom() {
		//System.out.println("zombieToCreate: "+ BucketZom.zombieToCreate);
		//System.out.println("ZombieDaTao: "+ BucketZom.totalZombieCreate);
		//System.out.println("Can Add Zom Buc hong: "+canAddZomBuc);
		if(NewspaperZom.totalZombieCreate >= NewspaperZom.zombieToCreate) canAddZomNews = false;
		if(NormalZom.totalZombieCreate >= NormalZom.zombieToCreate) canAddZomNor = false;
		if(BucketZom.totalZombieCreate >= BucketZom.zombieToCreate) {canAddZomBuc = false;}//System.out.println("CANADDBUC: "+canAddZomBuc);}
		if(ConeZom.totalZombieCreate >= ConeZom.zombieToCreate) canAddZomCone = false;
		if(canAddZomNews == false&&canAddZomNor == false && canAddZomBuc == false && canAddZomCone == false)
			return true;
		else return false;}
		
	public void startTest() {
		if(TapVeDemo.run) {
		startGame();
		startAddSun();
		startAddAllZombieTest();}
	}
/*	public void startGame() {
		if(DynamicPanel.tapVeDemo.run)
		timeGame.scheduleAtFixedRate(taskGame, 0, 1000);} 
		
	public void startAddSun() {
		if(DynamicPanel.tapVeDemo.run)
		timeToAddSun.scheduleAtFixedRate(tasktoSun,5000,8000);}*/
	public void startGame() {
		Timer timeGame = new Timer();
		timeGame.schedule(new TimerTask() {

			@Override
			public void run() {
				if(DynamicPanel.tapVeDemo.isRun()&&TapVeDemo.winningGameOrNot()==false){	
					secondPassed++;
					System.out.printf("Second pass: %d\n",secondPassed);
					}
				if(TapVeDemo.winningGameOrNot()) {
					System.out.println("RUN TRONG STARTGAME Dynamic.tapVeDemo.run:" +DynamicPanel.tapVeDemo.run);
					System.out.println("RUN TRONG STARTGAME TapVemo:" +TapVeDemo.run);
					timeGame.cancel(); secondPassed = 0;
					System.out.println("WIN CHUA MA: "+TapVeDemo.winningGameOrNot());}// startGame();}
			}
			
		}, 0, 1000);}
	
	
	public void startAddSun() {
		Timer timeToAddSun = new Timer();
		timeToAddSun.schedule(new TimerTask() {
			public void run() {
			if(DynamicPanel.tapVeDemo.isRun()&&TapVeDemo.winningGameOrNot()==false) 
				TapVeDemo.addSun(new Sun());
			if(TapVeDemo.winningGameOrNot()) {timeToAddSun.cancel();}}//startAddSun();}}
		}, 5000, 8000);}
	
	public void startAddZombieNormal() {
		Timer timeToAddZombie = new Timer();
		timeToAddZombie.schedule(new TimerTask() {
			public void run() {
				if(TapVeDemo.isRun()&&canAddZomNor==true){	
			int lane=rand.nextInt(5);
			if (lane == 0 ) amountZInLane0 ++;
			else if (lane==1) amountZInLane1 ++;
			else if (lane == 2) amountZInLane2 ++;
			else if (lane == 3) amountZInLane3 ++;
			else amountZInLane4 ++;
			TapVeDemo.addZombie(new NormalZom(1250, yOfLane[lane], 10, 80));
			}
				if(canAddZomNor == false) {
					timeToAddZombie.cancel();//startAddZombieNormal();
				}}
		}, 20000, 15000);}
	
	public void startAddZombieBuc() {
		Timer timeToAddZombieBuc = new Timer();
		System.out.println("DMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		timeToAddZombieBuc.schedule(new TimerTask() {
			public void run() {
			System.out.println("DynamicPanel.tapVeDemo.isRun(): "+DynamicPanel.tapVeDemo.isRun()+"canAddZomBuc: "+canAddZomBuc);
				if(DynamicPanel.tapVeDemo.isRun()&&canAddZomBuc==true){	
			int lane=rand.nextInt(5);
			if (lane == 0 ) amountZInLane0 ++;
			else if (lane==1) amountZInLane1 ++;
			else if (lane == 2) amountZInLane2 ++;
			else if (lane == 3) amountZInLane3 ++;
			else amountZInLane4 ++;
			TapVeDemo.addZombie(new BucketZom(1250, yOfLane[lane]-10, 10, 80));
			}
				if(canAddZomBuc == false) {
					timeToAddZombieBuc.cancel();//startAddZombieBuc();
					System.out.println("CANCEL ADD BUC R");
				}}
		}, 25000, 16000);}
	
	public void startAddZombieCone() {
		Timer timeToAddZombieCone = new Timer();
		timeToAddZombieCone.schedule(new TimerTask() {
			public void run() {
				if(DynamicPanel.tapVeDemo.isRun()&&canAddZomCone==true){	
			int lane=rand.nextInt(5);
			if (lane == 0 ) amountZInLane0 ++;
			else if (lane==1) amountZInLane1 ++;
			else if (lane == 2) amountZInLane2 ++;
			else if (lane == 3) amountZInLane3 ++;
			else amountZInLane4 ++;
			TapVeDemo.addZombie(new ConeZom(1250, yOfLane[lane]-30, 10, 80));
			}
				if(canAddZomCone == false) {
					timeToAddZombieCone.cancel();//startAddZombieCone();
				}}
		}, 36000, 25000);}
	
	public void startAddZombieNews() {
		Timer timeToAddZombieNews = new Timer();
		timeToAddZombieNews.schedule(new TimerTask() {
			public void run() {
				if(DynamicPanel.tapVeDemo.isRun()&&canAddZomNews==true){	
			int lane=rand.nextInt(5);
			if (lane == 0 ) amountZInLane0 ++;
			else if (lane==1) amountZInLane1 ++;
			else if (lane == 2) amountZInLane2 ++;
			else if (lane == 3) amountZInLane3 ++;
			else amountZInLane4 ++;
			TapVeDemo.addZombie(new NewspaperZom(1250, yOfLane[lane], 10, 80));
			}
				if(canAddZomNews == false) {
					timeToAddZombieNews.cancel();//startAddZombieNews();
				}}
		}, 40000, 30000);}
	
	public void startAddAllZombieTest() {
		startAddZombieNormal();
		startAddZombieBuc();
		startAddZombieCone();
		startAddZombieNews();
	}
/*	public void startAddZombie() {
		timeToAddZombie.scheduleAtFixedRate(taskToAddZombie, 20000, 15000);
		timeToAddBucZombie.scheduleAtFixedRate(taskToAddBucZombie, 25000, 16000);
	//	timeToAddConeZombie.scheduleAtFixedRate(taskToAddConeZombie, 36000, 25000);
	//	timeToAddNewsZombie.scheduleAtFixedRate(taskToAddNewsZombie, 40000, 30000);}*/
		
	/*public static void resetTime() {
		//timeToAddZombie.cancel();
		//timeToAddZombie.purge();
		//timeToAddNewsZombie.cancel();
		//timeToAddNewsZombie.purge();
		timeGame.cancel();
		timeGame.purge();
		timeToAddSun.cancel();
		timeToAddSun.purge();
		
	}*/
	
		public static int minusAmountZInLane0() {return amountZInLane0--;}
		
		public static int minusAmountZInLane1() {return amountZInLane1--;}

		public static int minusAmountZInLane2() {return amountZInLane2--;}
			
		public static int minusAmountZInLane3() {return amountZInLane3--;}

		public static int minusAmountZInLane4() {return amountZInLane4--;}
		
}
