public class StaticCodeseg {
	static {
		System.out.println("在主方法所在类中中定义的静态块");
	}
 {
		System.out.println("在主方法所在类中中定义的普通块");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo();
		new Demo();
	}

}

class Demo {
	{
		System.out.println("1.构造块");
	}
	static {
		System.out.println("0.静态代码块");
	}
	public Demo(){
		System.out.println("2.构造方法");
	}
}