package PlantvsZombie;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int level;
	
	public User(String name, int level) {
		this.name=name;
		this.level=level;
	}
	
	public String toString() {
		return this.name +" "+this.level+"\n";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
