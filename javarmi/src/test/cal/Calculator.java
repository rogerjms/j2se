package test.cal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements ICalculator {
	private static final long serialVersionUID = 1L;

	public Calculator() throws RemoteException {
		super();
	}

	public int plus(int m, int n) throws RemoteException {
		return m + n;
	}

	public int minus(int m, int n) throws RemoteException {
		return m - n;
	}

	public int multiply(int m, int n) throws RemoteException {
		return m * n;
	}

	public int divide(int m, int n) throws RemoteException {
		return m / n;
	}
}
