package innerclass;

public class InnerClassDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().fun();
	}

}
class Outer{
	private String info = "hello world!!!";
	class Inner{
		public void print(){
			System.out.println(info);
		}
	}
	public void fun(){
		new Inner().print();
	}
}