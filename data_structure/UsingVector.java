//演示Vector类的用法。 
import java.util.*;
import javax.swing.JOptionPane;
public class UsingVector {
  public static void main(String args[]) {

	 Vector scoreVector = new Vector();//用矢量存储分数
	 double bestScore=0;
	 char grade; //定义分数的级别

	 do{
		//读入分数并找出最高分
		String scoreString = JOptionPane.showInputDialog(null,
			"请输入分数" +
			"\n输入负数表示输入结束","演示Vector(输入)",
			JOptionPane.QUESTION_MESSAGE);
		//将字符串转换成整型值
		double scoreInt = Integer.parseInt(scoreString);
		if (scoreInt<0)
		{
			break;
		}
		//将分数添加进矢量
		scoreVector.addElement(new Double(scoreInt));
		//找出最高分
		if (scoreInt > bestScore)
		{
			bestScore = scoreInt;
		}
	 }while (true);

	 //设置输出字符串
	 String output = "一共有"+scoreVector.size() +"个学生";
	 //确定并显示分数的级别
	 for (int i = 0;i < scoreVector.size() ; i++)
	 {
		 //检索矢量
		 Double doubleObj = (Double)(scoreVector.elementAt(i));
		 //获取分数
		 double score = doubleObj.doubleValue();
		 if(score >= bestScore-10)
			 grade = 'A';
		 else if(score >=bestScore-20)
			 grade = 'B';
		 else if(score >=bestScore-30)
			 grade = 'C';
		 else
			 grade = 'D';
		 output += "\n学生"+ i +"的分数是"+ score +
			 "，级别是" + grade;
	 }

	 JOptionPane.showMessageDialog(null,output,
		 "演示Vector(输出)",JOptionPane.INFORMATION_MESSAGE);
	 System.exit(0);
  }
}
