package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            list = getnewList(list,head);
            head <<= 1;
        }
        return list;
    }

    public List<Integer> getnewList(List<Integer> list,Integer head){
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add(list.get(i)+ head);
        }
        return list;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                2,3,4,0,0,0
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));



        System.out.println(JSONObject.toJSONString(new T89().grayCode(i), SerializerFeature.PrettyFormat));
    }
}

