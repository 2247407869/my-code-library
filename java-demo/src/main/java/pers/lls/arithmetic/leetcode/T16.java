package pers.lls.arithmetic.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class T16 {
    public int threeSumClosest(int[] nums,int target) {
        int result = 10000000;

        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i>0&&nums[i] == nums[i-1]) continue;
            int k = length - 1;
            for (int j = i+1; j < length && k>j; ) {
                int sum = nums[j] + nums[k] + nums[i];
                if (j>i+1&&nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (sum > target){
                    k--;
                }else if (sum < target){
                    j++;
                }else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -1,2,1,-4
        };

        int i =
                1
                ;

        String string ="23";


        Class c = T16.class;
        Method[] methods = c.getDeclaredMethods();

        Class[] parameterTypes = methods[1].getParameterTypes();
        Object[] arguments = new Object[parameterTypes.length];
        for(int x=0;x<parameterTypes.length;x++){
            String nameString=parameterTypes[x].getName();
            System.out.print("parameterType:"+nameString);//打印方法参数类型
            if (nameString.equals("[I")) arguments[x] = intarray;
            if (nameString.equals("int")) arguments[x] = i;
        }

        System.out.println(methods[1].invoke(c.newInstance(), arguments));
    }
}
