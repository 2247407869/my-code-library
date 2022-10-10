package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T22 {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace("",n, n);
        return result;
    }

    private void backtrace(String s, int i, int j) {
        if (i == j && j == 0) result.add(s);
        else {
            if (i != j){
                backtrace(s + ")",i,--j);
                j++;
            }
            if (i > 0)
            backtrace(s + "(",--i,j);
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -1,2,1,-4
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));


//        Class c = T22.class;
//        Method[] methods = c.getDeclaredMethods();
//
//        Class[] parameterTypes = methods[methods.length-1].getParameterTypes();
//
//
//        Object[] arguments = new Object[]{listNode,listNode2};

//        Object[] arguments = new Object[parameterTypes.length];
//        for(int x=0;x<parameterTypes.length;x++){
//            String nameString=parameterTypes[x].getName();
//            System.out.println("parameterType:"+nameString);//打印方法参数类型
//            if (nameString.equals("[I")) arguments[x] = intarray;
//            if (nameString.equals("int")) arguments[x] = i;
//            if (nameString.equals("java.lang.String")) arguments[x] = string;
//            if (nameString.equals("pers.lls.arithmetic.leetcode.ListNode")) arguments[x] = string;
//        }

        System.out.println(JSONObject.toJSONString(new T22().generateParenthesis(3)));
    }
}

