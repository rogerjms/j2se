package test.helloworld;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class RMIClient {
	public static void main(String[] args) {
		// 创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			IHelloWorld hello = (IHelloWorld) Naming
					.lookup("rmi://localhost:1099/HelloWorldService");
			System.out.println(hello.sayHello("World"));
			System.out.println(hello.sayHello("China"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
