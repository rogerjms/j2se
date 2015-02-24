//使用Collections类中的方法
import java.util.*;
class DemonCollections {
	public static void main(String args[]) {
		//创建一个包含3个字符串的列表
		List list = Collections.nCopies(2,"dog");

		//创建一个数组列表
		ArrayList arrayList = new ArrayList(list);
		System.out.println("The initial list is "+arrayList);
		list = null;//将列表清空

		//将"cat"字符串添加进列表
		Collections.fill(arrayList,"cat");
		System.out.println("After filling cat,the list is " + arrayList);

		//向列表中添加3个新元素
		arrayList.add("horse");
		arrayList.add("rabbit");
		arrayList.add("dog");
		System.out.println("After adding new elements,the list is \n" + arrayList);

		//将列表中的元素随机排列
		Collections.shuffle(arrayList);
		System.out.println("After shuffling,the list is \n" + arrayList);

		//查找列表中的最小元素和最大元素
		System.out.println("The minimum element in the list is " + Collections.min(arrayList));
		System.out.println("The maximum element in the list is " + Collections.max(arrayList));

		//给列表排序
		Collections.sort(arrayList);
		System.out.println("The sorted list is\n" + arrayList);

		//检索列表
System.out.println("The search result for dog is " + Collections.binarySearch(arrayList,"dog"));

	}
}
