package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class T21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode();
        ListNode pr = result;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                pr.next = p2;
                p2 = p2.next;
            } else {
                pr.next = p1;
                p1 = p1.next;
            }
            pr = pr.next;
        }

        if (p1 == null){
            pr.next = p2;
        } else {
            pr.next = p1;
        }

        return result.next;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -1,2,1,-4
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));


        Class c = T21.class;
        Method[] methods = c.getDeclaredMethods();

        Class[] parameterTypes = methods[methods.length-1].getParameterTypes();


        Object[] arguments = new Object[]{listNode,listNode2};

//        Object[] arguments = new Object[parameterTypes.length];
//        for(int x=0;x<parameterTypes.length;x++){
//            String nameString=parameterTypes[x].getName();
//            System.out.println("parameterType:"+nameString);//打印方法参数类型
//            if (nameString.equals("[I")) arguments[x] = intarray;
//            if (nameString.equals("int")) arguments[x] = i;
//            if (nameString.equals("java.lang.String")) arguments[x] = string;
//            if (nameString.equals("pers.lls.arithmetic.leetcode.ListNode")) arguments[x] = string;
//        }

        System.out.println(JSONObject.toJSONString(methods[methods.length-1].invoke(c.newInstance(), arguments)));
    }
}

