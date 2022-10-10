package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T75 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int p = 0;
        while (p <= right){

            if (nums[p] == 0){
                exchange(nums, left, p);
                left++;
            }
            if (nums[p] == 2){
                exchange(nums, right, p);
                right--;
            }else {
                p++;
            }

        }
    }

    private void exchange(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                2,0,2,1,1,0
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        new T75().sortColors(intarray);

        System.out.println(JSONObject.toJSONString(intarray, SerializerFeature.PrettyFormat));
    }
}

