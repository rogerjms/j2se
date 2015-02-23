package javabasic;

import java.util.Collection;
import java.util.HashSet;

public class BasicContainer {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add("hello");
        c.add(new Gxk("f1","l1"));
        c.add(new Integer(100));
        c.remove("hello"); 
        c.remove(new Integer(100));
        System.out.println
                  (c.remove(new Gxk("f1","l1")));
        System.out.println(c);
    }
    
}
 @SuppressWarnings("rawtypes")
class  Gxk implements Comparable {
    private String firstName,lastName;
    public Gxk(String firstName, String lastName) {
        this.firstName = firstName; this.lastName = lastName;
    }
    public String getFirstName() {  return firstName;   }
    public String getLastName() {   return lastName;   }
    public String toString() {  return firstName + " " + lastName;  }
    
    public boolean equals(Object obj) {
	    if (obj instanceof Gxk) {
	        Gxk name = (Gxk) obj;
	        return (firstName.equals(name.firstName))
	            && (lastName.equals(name.lastName));
	    }
	    return super.equals(obj);
		}
		public int hashCode() {
		    return firstName.hashCode();
		}
		
		
		
		public int compareTo(Object o) {
        Gxk n = (Gxk)o;
        int lastCmp = 
            lastName.compareTo(n.lastName);
        return 
             (lastCmp!=0 ? lastCmp :
              firstName.compareTo(n.firstName));
    }

}