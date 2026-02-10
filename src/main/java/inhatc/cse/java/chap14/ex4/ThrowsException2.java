package inhatc.cse.java.chap14.ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException2 {

    public Class loadClass(String fileName, String className)  {
        
        try {
            FileInputStream fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Class c= null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void main(String[] args) {
        ThrowsException2 test = new ThrowsException2();
        
        test.loadClass("a.txt", "java.lang.String");
        
    }
}
