package PlantvsZombie;

public class Score {
private static int score=50;
	
	public static int getScore() {
		return score;
	}
	public static void setScore(int score) {
		Score.score = score;
	}

	public void CollectSun() {
		score+=25;
	}
	
	public void MinusSun(int plantCost) {
		score = score - plantCost;
	}
}
