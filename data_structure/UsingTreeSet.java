// 演示TreeSet的用法。
import java.util.*;
public class UsingTreeSet {
  public static void main(String args[]) {
	  //创建哈希集
	  Set set = new HashSet();
	  String text = "You are good.You are very good.You are great." +
		  "You are wonderful!";
	  //从文本中析取单词
	  StringTokenizer st = new  StringTokenizer(text," .!");
	  while(st.hasMoreTokens())
		  set.add(st.nextToken());

	  TreeSet treeSet = new TreeSet(set);
	  System.out.println(treeSet);
	  //获取迭代器
	  Iterator iterator = treeSet.iterator();
	  //显示树集中的元素
	  while (iterator.hasNext()) {
		  System.out.print(iterator.next() + " ");
	  }
  }
}
