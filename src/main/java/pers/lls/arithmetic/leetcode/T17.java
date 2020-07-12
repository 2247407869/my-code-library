package pers.lls.arithmetic.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class T17 {

    public List<String> letterCombinations(String digits) {
        return null;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -1,2,1,-4
        };

        int i = 1 ;

        String string ="23";


        Class c = T17.class;
        Method[] methods = c.getDeclaredMethods();

        Class[] parameterTypes = methods[methods.length-1].getParameterTypes();
        Object[] arguments = new Object[parameterTypes.length];
        for(int x=0;x<parameterTypes.length;x++){
            String nameString=parameterTypes[x].getName();
            System.out.println("parameterType:"+nameString);//打印方法参数类型
            if (nameString.equals("[I")) arguments[x] = intarray;
            if (nameString.equals("int")) arguments[x] = i;
            if (nameString.equals("java.lang.String")) arguments[x] = string;
        }

        System.out.println(methods[methods.length-1].invoke(c.newInstance(), arguments));
    }
}
