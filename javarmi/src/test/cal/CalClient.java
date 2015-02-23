package test.cal;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class CalClient {
	public static void main(String[] args) {
		// 创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			ICalculator cal = (ICalculator) Naming
					.lookup("rmi://localhost:1099/CalculatorService");
			System.out.println("100+22=" + cal.plus(100, 22));
			System.out.println("100-22=" + cal.minus(100, 22));
			System.out.println("100*22=" + cal.multiply(100, 22));
			System.out.println("100/22=" + cal.divide(100, 22));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
