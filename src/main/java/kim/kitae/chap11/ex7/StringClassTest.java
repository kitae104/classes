package kim.kitae.chap11.ex7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringClassTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class strClass = Class.forName("java.lang.String");

        Constructor[] cons = strClass.getConstructors();
        for(Constructor con : cons){
            System.out.println(con);
        }

        System.out.println("----------------------------");

        Field[] fields = strClass.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("----------------------------");

        Method[] methods = strClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
    }
}
