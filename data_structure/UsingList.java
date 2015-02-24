//演示ArrayList类和LinkedList类的用法。
import java.util.*;
public class UsingList {
  public static void main(String args[]) {
	  ArrayList arrayList = new  ArrayList();
	  arrayList.add(new Integer(5));
	  arrayList.add(new Integer(8));
	  arrayList.add(new Integer(6));
	  arrayList.add(new Integer(30));
	  arrayList.add(new Integer(4));
	  arrayList.add(0,new Integer(40));
	  arrayList.add(2,new Integer(50));

	  System.out.println("A list of integers in the array list:");
	  System.out.println(arrayList);

	  LinkedList linkedList = new LinkedList(arrayList);
	  linkedList.add(1,"beautiful");
	  linkedList.removeLast();
	  linkedList.addFirst("world");

	  System.out.println("Display the linked list forward:");
	  ListIterator listIterator =linkedList.listIterator();
	  while(listIterator.hasNext()) {
		  System.out.print(listIterator.next() +" ");
	  }
	  System.out.println();

	  System.out.println("Display the linked list backward:");
	  listIterator =linkedList.listIterator(linkedList.size());
	  while (listIterator.hasPrevious())
	  {
		  System.out.print(listIterator.previous() + " " );
	  }
  }
}
