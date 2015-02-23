package test;

import java.io.IOException;

public class TestGenericExceptionMain implements
		TestGenericException<IOException> {
	public void execute(int i) throws IOException {
		if (i < 10)
			throw new IOException();
	}

	public static void main(String[] args) {
		try {
			TestGenericExceptionMain test = new TestGenericExceptionMain();
			test.execute(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
