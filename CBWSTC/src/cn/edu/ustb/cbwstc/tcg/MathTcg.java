package cn.edu.ustb.cbwstc.tcg;

import java.util.Random;
/**
 * ֱ��ʹ��Random�޷����������ظ������֣������Ҫ���ɲ��ظ�����������У���Ҫ��������ͼ�����
 * http://www.cnblogs.com/ningvsban/p/3590722.html
 * α����������Ǽ������������ġ�α�����й��ɵ���˼�����Ǽ����������α�������������������й��ɵ�
 * �����������ϵͳʱ�ӣ�ȷ�е�˵�������Լ���������ϵĶ�ʱ/���������ڴ��еļ���ֵ
 * ���������������Ӹ���һ���ļ��㷽�������������ֵ�����ԣ�ֻҪ���㷽��һ�����������һ������ô������������Ͳ���䡣Ҳ����˵��α�����Ҳ��ĳ�ֶ�Ӧӳ��Ĳ��ֻ��������Ա�����ϵͳ��ʱ�����
 * �����ÿ�ε���Random()ʱ���ṩ��ͬ������ֵ����ô���㽫��õ���ͬ�����������
 * @author JJT
 * �ο�����ʦ���TSTG�����е�alan.testcase.handle.RandomGenerator
 * TSTG������alan.testcase.handle.TestCaseGenerator��getTestCases
 */
public class MathTcg {
	
	private Random random = new Random();
	
	public MathTcg(Random random) {
		this.random = random;
	}
	
	/**
	 * ��ȡ[min��max)�����intֵ(����min ������max)
	 * @param min
	 * @param max
	 * @return
	 */
	public int intIITCG(int min,int max) {
		int rint =0;
		rint = (int) ((Math.random()*(max-min)) + min);
		//Math.random()ϵͳ���ѡȡ���ڵ��� 0.0 ��С�� 1.0 ��α��� double ֵ
		return rint;
	}
	
	/**
	 * ��ȡ[min��max)�����doubleֵ(����min ������max)
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
	 * ��ȡ[min��max)�����floatֵ(����min ������max)
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
	 * �������boolean���͵�����
	 * @return
	 */
	public boolean boolTCG() {
		boolean rbool = true;
		rbool = random.nextBoolean();
		return rbool;
	}

}
