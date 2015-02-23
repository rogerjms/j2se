package test.cal;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
	public int plus(int m, int n) throws RemoteException;

	public int minus(int m, int n) throws RemoteException;

	public int multiply(int m, int n) throws RemoteException;

	public int divide(int m, int n) throws RemoteException;
}
