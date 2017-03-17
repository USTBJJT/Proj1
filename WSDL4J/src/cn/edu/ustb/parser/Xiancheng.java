package cn.edu.ustb.parser;

public class Xiancheng extends Thread{
	
	
	     @Override
	     public void run(){
	        try{
	             Thread.sleep(1);
	             }catch (InterruptedException e){
	             e.printStackTrace();
	             }
	             System.out.print("run");
	     }
	     public static void main(String[] args){
	    	 Xiancheng example=new Xiancheng();
	             example.run();
	             System.out.print("main");
	     }
}
