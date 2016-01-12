

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Runtime类封装了运行时的环境。每个 Java 应用程序都有一个 Runtime
 * 类实例，使应用程序能够与其运行的环境相连接。一般不能实例化一个Runtime对象，应用程序也不能创建自己的 Runtime 类实例，但可以通过
 * getRuntime 方法获取当前Runtime运行时对象的引用。
 */
public class RuntimeTest {

       public static void test2() {
              Runtime rt = Runtime.getRuntime();
              try {
                     Process p = rt.exec("java -jar e:/begale/beagle.r1399.jar gt=e:/begale/test.r1399.vcf.gz out=e:/begale/out.gt");
                     BufferedReader br = new BufferedReader(new InputStreamReader(p
                                   .getInputStream()));
                     String msg = null;
                     while ((msg = br.readLine()) != null) {
                            System.out.println(msg);
                     }
                     br.close();
              } catch (IOException e) {
                     e.printStackTrace();
              }
       }
       public static void main(String[] args) {
              test2();
       }
}