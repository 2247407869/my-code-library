package pers.lls.arithmetic.sword;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class T1 {
    public static boolean find(int target, int[][] array) {
        int h = array.length - 1;
        int w = array[0].length - 1;

        int x = h;
        int y = 0;
        while (x >= 0 && y <= w) {
            if (target == array[x][y]) {
                return true;
            } else if (target > array[x][y]) {
                y += 1;
            } else {
                x -= 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 6, 9}};
        System.out.println(find(11, data));
    }
}
