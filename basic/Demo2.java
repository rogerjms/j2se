package codeseg.gouzaokuai;
//类中的构造块先于构造方法执行
class Demo {
	{
		System.out.println("1.构造块");
	}
	public Demo(){
		System.out.println("2.构造方法");
	}
}
public class Demo2{
	public static void main(String[] args){
		new Demo();
		new Demo();
		new Demo();
	}
}
