package cn.edu.ustb.cbwstc.tsg;

public class IDGenerator {
	
	private int id = 0;

	private static IDGenerator instance = null;

	private IDGenerator() {
	}

	public static IDGenerator getInstance() {
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}

	public int getNextId() {
		return id++;
	}

	public void clear() {
		id = 0;
	}

}
