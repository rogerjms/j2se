package codeseg;
//普通代码块，构造快，静态块，
public class CommonCodeSeg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			int x = 30;
			System.out.println("普通代码块--->x = "+x);
		}
		int x = 100;
		System.out.println("代码块之外--->x = "+x);
		
	}

}
