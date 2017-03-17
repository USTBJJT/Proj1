package cn.edu.ustb.parser;


import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.RealVar;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.real.RealConstraint;
import org.chocosolver.solver.expression.continuous.arithmetic.*;


public class Constraintsolving {
	

	public static void CS() {
		// 1. Create a Model
        Model model = new Model("my first problem");
        // 2. Create variables
        RealVar d = model.realVar("d", 0.2d);
        IntVar x = model.intVar("X", 0,5);                 // x in [0,5]
        IntVar y = model.intVar("Y", new int[]{2, 3, 8});   // y in {2, 3, 8}
        // 3. Post constraints
        model.arithm(x, "+", y, "<", 5).post(); // x + y < 5
        model.times(x,y,4).post();              // x * y = 4
        // 4. Solve the problem
        model.getSolver().solve();
        // 5. Print the solution
        System.out.println(x); // Prints X = 2
        System.out.println(y); // Prints Y = 2
	}
	
	public static void assign() {
		Model model = new Model("my first problem");
		BoolVar b = model.boolVar("b", true);
		BoolVar c = model.boolVar("c");//默认为true 1
		IntVar x = model.intVar("x", 0,2);
		IntVar y = model.intVar("y", 0,80);
		IntVar a1 = model.intVar("a1", 0,5);
		IntVar a2 = model.intVar("a2", 0, 10000);
		RealVar d = model.realVar("d", 0.2d);
		model.ifThen(
				model.arithm(x,"<",3),
				model.arithm(y,">",42)
				);
		model.arithm(a2, "=", a1).post();
//		while(model.getSolver().solve()) { 这样可以求解出全部的解
//			System.out.println(a1);
//			System.out.println(x);
//			System.out.println(y);
//			System.out.println(c);
//			System.out.println(b);
//		}
		
		System.out.println(model.getSolver().solve());//为true代表有解，否则无解
		model.getSolver().solve();
		System.out.println(a1);
		System.out.println(x);
		System.out.println(y);
		System.out.println(c);
		System.out.println(b);
	}
//	public static void main(String args[]) throws Exception{
//		CS();
//    }
	
	public static void mytry() {
		
		// 1. Create a Model
		Model model = new Model("my first problem");
		
		// 2. Create variables
		IntVar a1 = model.intVar("a1", 0,1000);//Integer.MIN_VALUE
		IntVar a2 = model.intVar("a2", 0,1000);//Integer.MAX_VALUE
		IntVar b1 = model.intVar("b1", 0,1000);
		IntVar a3 = model.intVar("a3", 0,1000);
		IntVar b2 = model.intVar("b2", 0,1000);
		// 3. Post constraints
		model.arithm(a1, "+", a2, "=", b1).post();
		model.arithm(a3, "=", b1).post();
		b2 = model.intOffsetView(a3, 7);
		model.arithm(b2, ">", 10).post();
		 // 4. Solve the problem
        model.getSolver().solve();
     // 5. Print the solution
        System.out.println(a1);
        System.out.println(a2);
		
	}
	
	public static void shunxu() {
		
		Model model = new Model("my first problem");
		RealVar d1 = model.realVar("d1", 3.0);
		RealVar d2 = model.realVar("d2", 0.2);
		IntVar a1 = model.intVar("a1", 0,1000);//Integer.MIN_VALUE
		IntVar a2 = model.intVar("a2", 0,1000);//Integer.MAX_VALUE
//		RealVar addreturn = model.realVar("addreturn",0.0d);
//		IntVar a1 = model.intVar("a1", 5,100);//Integer.MIN_VALUE
//		IntVar a2 = model.intVar("a2",0,100);//Integer.MAX_VALUE
//		double t = 0;
//		RealVar ce = model.realVar(t);
//		ce.getPrecision();
//		CArExpression d4 = ce.sub(d2).abs();
//		//CArExpression ce1 = d1.add(ce);
//		model.times(a1,3,a2).post();
		a1.add(a2).lt(5).post();
		
		while(model.getSolver().solve()) {
			System.out.println(a1);
			System.out.println(a2);
		}
		
	}

}
