package javabasic;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("java.lang.String");
            System.out.println("package "+c.getPackage().getName()+";");
            System.out.print(Modifier.toString(c.getModifiers())+" ");
            System.out.print("class "+c.getSimpleName()+" ");
            if (c.getSuperclass()!=Object.class) {
                System.out.print("extends " + c.getSuperclass().getSimpleName());
            }
            Class[] inters=c.getInterfaces();
            if(inters.length>0){
                System.out.print("implements ");
                for(int i=0;i<inters.length;i++){
                    System.out.print(inters[i].getSimpleName());
                    if(i<inters.length-1){
                        System.out.print(",");
                    }
                }
            }
            System.out.println("{");
            printFields(c);
            printMethods(c);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
    public static void printFields(Class c){
        Field[] field=c.getDeclaredFields();
        if(field.length>0){
            for(int i=0;i<field.length;i++){
                System.out.println(Modifier.toString(field[i].getModifiers())+" "+field[i].getType().getSimpleName()+" "+field[i].getName()+";");
            }
        }
    }
    public static void printMethods(Class c){
        Method[] method=c.getDeclaredMethods();
        if(method.length>0){
            for(int i=0;i<method.length;i++){
                Class[] parameter=method[i].getParameterTypes();
                System.out.print(Modifier.toString(method[i].getModifiers())+" "+method[i].getReturnType().getSimpleName()+" "+method[i].getName()+"(");
                for(int j=0;j<parameter.length;j++){
                    System.out.print(parameter[j].getSimpleName()+" args");
                    if(j!=parameter.length-1){
                        System.out.print(",");
                    }
                }
                System.out.print(") ");
                Class exception[]=method[i].getExceptionTypes();
                
                if (exception.length>0) {
                    System.out.print("throws ");
                    for (int j = 0; j < exception.length; j++) {
                        System.out.print(exception[j].getSimpleName());
                    }
                }
                System.out.println("{");
                System.out.println("\t... ...");
                System.out.println("}");
            }
            
        }
    }
}
