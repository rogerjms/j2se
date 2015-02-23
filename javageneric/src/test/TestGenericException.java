package test;

public interface TestGenericException<E extends Exception> {
	void execute(int i) throws E;
}
