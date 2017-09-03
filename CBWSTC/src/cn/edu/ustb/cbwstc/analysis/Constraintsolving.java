package cn.edu.ustb.cbwstc.analysis;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.RealVar;

public class Constraintsolving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Create a Model
        Model model = new Model("my first problem");
        
        // 2. Create variables
        IntVar login_loginTime = model.intVar("login_loginTime", IntVar.MIN_INT_BOUND, IntVar.MAX_INT_BOUND);
        BoolVar v = model.boolVar("v");
        IntVar feeCalculate_timeout = model.intVar("feeCalculate_timeout", IntVar.MIN_INT_BOUND, IntVar.MAX_INT_BOUND);
//        IntVar feeCalculate_type;
//        BoolVar  feeCalculate_dayOfWeek;
//        BoolVar  feeCalculate_discountCoupon; 
//        RealVar x;
//        RealVar y = model.realVar(5d);
        // 3. Post constraints
//        x = model.realVar("x", 5d, 7d, 1d);
//        login_loginTime = model.intVar("login_loginTime", -9, 7);
//        feeCalculate_timeout = model.intVar("feeCalculate_timeout", 0, 24);
//        feeCalculate_type = model.intVar("feeCalculate_type", 0);
//        feeCalculate_dayOfWeek = model.boolVar("feeCalculate_dayOfWeek", true);
//        feeCalculate_discountCoupon = model.boolVar("feeCalculate_discountCoupon", true);
//        login_loginTime = model.intVar("login_loginTime", 2, 24);
        model.arithm(login_loginTime, "<=", 24).post();
        model.arithm(login_loginTime, ">=", 0).post();
        model.arithm(feeCalculate_timeout, ">=", login_loginTime).post();
        model.arithm(feeCalculate_timeout, "-", login_loginTime, "<", 24).post();
        model.arithm(feeCalculate_timeout, "-", login_loginTime, ">=", 4).post();
        
        // 4. Solve the problem
        if(model.getSolver().solve()){
        	// 5. Print the solution
        	System.out.println(login_loginTime);
        	System.out.println(v);
        	System.out.println(feeCalculate_timeout);
//        	System.out.println(feeCalculate_type);
//        	System.out.println(feeCalculate_dayOfWeek);
//        	System.out.println(feeCalculate_discountCoupon);
//        	System.out.println(x.getLB());
//        	System.out.println(y.getLB());
        }
        
        
	}

}
