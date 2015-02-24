//使用Arrays类中的方法。
import java.util.*;
class DemonArrays 
{
	public static void main(String[] args) 
	{
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		//用20填充数组中7至（9－1）的位置
		Arrays.fill(array,7,9,20);

		System.out.println("After filling,the array is");
		for(int i = 0;i<10;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		//将数组排序
		Arrays.sort(array);
		System.out.println("After sorting,the array is");
		for(int i = 0;i<10;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		//在数组中检索25
		System.out.println("Search 25 in the array : "+ Arrays.binarySearch(array,25));
		//在数组中检索5
		System.out.println("Search 5 in the array : "+ Arrays.binarySearch(array,5));
		//将数组array同数组arrayB相比较
		int[] arrayB = new int[10];
		System.out.println("Compare with arrayB : "+Arrays.equals(array,arrayB));
	}
}
