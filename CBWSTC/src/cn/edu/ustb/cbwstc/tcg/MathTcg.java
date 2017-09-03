package cn.edu.ustb.cbwstc.tcg;

import java.util.Random;
/**
 * 直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
 * http://www.cnblogs.com/ningvsban/p/3590722.html
 * 伪随机数并不是假随机数，这里的“伪”是有规律的意思，就是计算机产生的伪随机数既是随机的又是有规律的
 * 随机种子来自系统时钟，确切地说，是来自计算机主板上的定时/计数器在内存中的记数值
 * 随机数是由随机种子根据一定的计算方法计算出来的数值。所以，只要计算方法一定，随机种子一定，那么产生的随机数就不会变。也就是说，伪随机数也是某种对应映射的产物，只不过这个自变量是系统的时间而已
 * 如果你每次调用Random()时都提供相同的种子值，那么，你将会得到相同的随机数序列
 * @author JJT
 * 参考赵彦师姐的TSTG工具中的alan.testcase.handle.RandomGenerator
 * TSTG工具中alan.testcase.handle.TestCaseGenerator的getTestCases
 */
public class MathTcg {
	
	private Random random = new Random();
	
	public MathTcg(Random random) {
		this.random = random;
	}
	
	/**
	 * 获取[min，max)的随机int值(包括min 不包括max)
	 * @param min
	 * @param max
	 * @return
	 */
	public int intIITCG(int min,int max) {
		int rint =0;
		rint = (int) ((Math.random()*(max-min)) + min);
		//Math.random()系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
		return rint;
	}
	
	/**
	 * 获取[min，max)的随机double值(包括min 不包括max)
	 * @param min
	 * @param max
	 * @return
	 */
	public double doubleTCG(double min,double max) {
		double dint = 0.0;
		dint = (random.nextDouble()*(max-min)) + min;
		return dint;
	}
	
	/**
	 * 获取[min，max)的随机float值(包括min 不包括max)
	 * @param min
	 * @param max
	 * @return
	 */
	public float floatTCG(float min,float max) {
		float fint = 0;
		fint = (random.nextFloat()*(max-min)) + min;
		return fint;
	}
	
	/**
	 * 随机生成boolean类型的数据
	 * @return
	 */
	public boolean boolTCG() {
		boolean rbool = true;
		rbool = random.nextBoolean();
		return rbool;
	}

}
