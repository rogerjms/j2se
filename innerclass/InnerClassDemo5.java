package innerclass;


public class InnerClassDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer5().fun(60);
	}

}
class Outer5{
	private static String info = "hello world!!!";
	public void fun(final int temp){ 
	@SuppressWarnings("unused")
	class Inner5{
		private static final String UNUSED = "unused";

		@SuppressWarnings(UNUSED)
		public void print(){
			System.out.println("���е�����"+info);
			System.out.println("�����еĲ���"+temp);
		}
	}
 };
}