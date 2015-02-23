package test;

import java.util.ArrayList;
import java.util.List;

public class TestGenericMethod {

	public <T extends Number> String getString(T obj) {
		return obj.toString();
	}

	public <T extends Number> List<T> getList(T obj) {
		return new ArrayList<T>();
	}

	public static void main(String[] args) {
		TestGenericMethod test = new TestGenericMethod();
		//String s = "Hello";
		Integer i = 100;
		Float f = 95.1f;
		//System.out.println(test.getString(s));
		System.out.println(test.getString(i));
		System.out.println(test.getString(f));
	}
}
