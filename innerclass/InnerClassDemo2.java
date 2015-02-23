package innerclass;

public class InnerClassDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer2().fun();
	}

}
class Outer2{
	private String info = "hello world!!";
	public String getInfo(){
		return this.info;
	}
	public void fun(){
		new Inner(this).print();
	}
}
class Inner{
	private Outer2 out = null;
	public Inner(Outer2 out){
		this.out = out;
	}
	public void print(){
		System.out.println(out.getInfo());
	}
}