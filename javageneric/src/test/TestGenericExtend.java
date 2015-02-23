package test;

import java.io.Serializable;
import java.util.Hashtable;

public class TestGenericExtend<K extends Number & Serializable, V> {
	public Hashtable<K, V> hash = new Hashtable<K, V>();

	public void put(K k, V v) {
		hash.put(k, v);
	}

	public V get(K k) {
		return hash.get(k);
	}

	public static void main(String[] args) {
		TestGenericExtend<Integer, String> test = new TestGenericExtend<Integer, String>();
		test.put(1, "admin");
		test.put(2, "liuzhongbing");
		String str = test.get(1);
		System.out.println(str);
	}
}
