package test.helloworld;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
	public static void main(String args[]) {
		// 创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			// 创建远程对象
			IHelloWorld hello = new HelloWorld();
			// 启动注册表
			LocateRegistry.createRegistry(1099);
			// 将名称绑定到对象
			Naming.rebind("//localhost:1099/HelloWorldService", hello);

			System.out.println("RMI服务器正在运行...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
