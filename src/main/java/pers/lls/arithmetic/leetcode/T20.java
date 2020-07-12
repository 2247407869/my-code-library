package pers.lls.arithmetic.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Stack;

public class T20 {

    public boolean isValid(String s) {
        if (s==null) return false;
        if (s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.empty()) return false;
                Character pop = stack.pop();
                if (c == ')'){
                    if (pop != '(') return false;
                }
                if (c == ']'){
                    if (pop != '[') return false;
                }
                if (c == '}'){
                    if (pop != '{') return false;
                }
            }

        }

        return stack.empty();
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -1,2,1,-4
        };

        int i = 1 ;

        String string ="[";


        Class c = T20.class;
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
