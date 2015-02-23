package test;

import java.util.Hashtable;

public class TestGeneric<K, V> {
	public Hashtable<K, V> hash = new Hashtable<K, V>();

	public void put(K k, V v) {
		hash.put(k, v);
	}

	public V get(K k) {
		return hash.get(k);
	}

	public static void main(String[] args) {
		TestGeneric<String, String> test = new TestGeneric<String, String>();
		test.put("001", "admin");
		test.put("002", "liuzhongbing");
		String str = test.get("001");
		System.out.println(str);
	}
}
