//演示HashMap类和TreeMap类的用法
import java.util.*;
class Mortgage{

	private double annualInterestRate;//年利率
	private int numberOfYears;//贷款年数
	private double loanAmount;//贷款数额

	public Mortgage(){
		this(6.0,10,10000);
	}
	public Mortgage(double interestRate,int years,double loan){
		this.annualInterestRate = interestRate;
		this.numberOfYears = years;
		this.loanAmount = loan;
	}

	public double getAnnualInterestRate(){//获取年利率
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double interestRate){//设置年利率
		this.annualInterestRate = interestRate;
	}

	public int getNumberOfYears(){
		return numberOfYears;
	}
	public void setNumberOfYears(int years){
		this.numberOfYears = years;
	}

	public double getLoanAmount(){
		return loanAmount;
	}
	public void setLoanAmount(double loan){
		this.loanAmount = loan;
	}

	//计算月还款额
	public double monthlyPayment(){
		double monthlyInterestRate = annualInterestRate/1200;
		return loanAmount * monthlyInterestRate/ (1 -
			(Math.pow(1/(1 + monthlyInterestRate),numberOfYears * 12)));
	}
	//计算总还款额
	public double totalPayment(){
		return monthlyPayment() * 12 * numberOfYears;
	}
}

public class UsingMap {
  public static void main(String args[]) {
	  //创建哈希集
	  HashMap hashMap = new  HashMap();
	  hashMap.put("张智",new Mortgage(6.5,10,20000));
	  hashMap.put("李奇",new Mortgage(6.5,10,30000));
	  hashMap.put("姜森",new Mortgage(6.5,15,30000));
	  hashMap.put("郑国庆",new Mortgage(6.5,15,10000));

	  //显示王五的贷款数额
	  System.out.println("张智的贷款数额是" +
		  ((Mortgage)(hashMap.get("张智"))).getLoanAmount());
	  //为哈希集创建数集
	  TreeMap treeMap = new  TreeMap(hashMap);

	  Set entrySet = treeMap.entrySet();
	  Iterator iterator = entrySet.iterator();

	  System.out.println("\n以键的升序顺序显示映射"); 
	  while(iterator.hasNext()){
		  System.out.println(iterator.next());
	  }
  }
}
