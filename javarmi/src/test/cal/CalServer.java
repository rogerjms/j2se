package test.cal;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

public class CalServer {
	public static void main(String args[]) {
		// 鍒涘缓骞跺畨瑁呭畨鍏ㄧ鐞嗗櫒
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			// 鍒涘缓杩滅▼瀵硅薄
			ICalculator cal = new Calculator();
			// 鍚姩娉ㄥ唽琛�
			LocateRegistry.createRegistry(1099);
			// 灏嗗悕绉扮粦瀹氬埌瀵硅薄
			Naming.rebind("//localhost:1099/CalculatorService", cal);

			System.out.println("RMI鏈嶅姟鍣ㄦ鍦ㄨ繍琛�");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
