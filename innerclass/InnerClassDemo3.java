package innerclass;

import innerclass.Outer3.Inner;

public class InnerClassDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer3.Inner().print();
	}

}
class Outer3{
	private static String info = "hello world!!!";
	static class Inner{
		public void print(){
			System.out.println(info);
		}
	}
	public void fun(){
		new Inner().print();
	}
}