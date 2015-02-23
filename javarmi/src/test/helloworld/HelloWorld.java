package test.helloworld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorld extends UnicastRemoteObject implements IHelloWorld {
	private static final long serialVersionUID = 1L;

	public HelloWorld() throws RemoteException {
		super();
	}

	public String sayHello(String world) throws RemoteException {
		return "Hello " + world + "!";
	}
}
