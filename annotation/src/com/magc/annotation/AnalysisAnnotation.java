package com.magc.annotation;

import java.lang.reflect.Method;

public class AnalysisAnnotation {
    /**
     * ������ʱ��������annotation���͵���Ϣ
     * 
     * 
     */
    public static void main(String[] args) {
        try {
                //ͨ������ʱ����API���annotation��Ϣ
                Class rt_class = Class.forName("com.magc.annotation.Utility");
                Method[] methods = rt_class.getMethods();
                
                boolean flag = rt_class.isAnnotationPresent(Description.class);
                
                if(flag)
                {
                    Description description = (Description)rt_class.getAnnotation(Description.class);
                    System.out.println("Utility's Description--->"+description.value());
                    for (Method method : methods) {
                        if(method.isAnnotationPresent(Author.class))
                        {
                            Author author = (Author)method.getAnnotation(Author.class);
                            System.out.println("Utility's Author--->"+author.name()+" from "+author.group());
                            
                        }
                    }
                }
            
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

}