package cn.edu.ustb.cbwstc.analysis;

import java.util.Random;
import java.util.Scanner;

public class GuangL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int rI = random.nextInt(1000 - 0 + 1) + 0;
		System.out.println(rI);
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			int guess = sc.nextInt();
			if(guess == rI) {
				int time = i+1;
				System.out.println("��ϲ�����¶��ˣ�һ������" + time + "��");
				break;
			}else if(guess < rI) {
				int time = 9-i;
				System.out.println("���������ֹ�С�����������룬����"+ time + "�λ���");
			}else {
				int time = 9-i;
				System.out.println("���������ֹ������������룬����"+ time + "�λ���");
			}
		}
		

	}

}
