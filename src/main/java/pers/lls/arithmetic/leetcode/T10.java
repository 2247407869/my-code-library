package pers.lls.arithmetic.leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T10 {
    public boolean isMatch(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        // 动态规划
        boolean[][] dp = new boolean[slength + 1][plength + 1];
        dp[0][0] = true;
        for (int i = 0; i < slength + 1; i++) {
            for (int j = 1; j < plength + 1; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = check(s, p, i, j) && dp[i - 1][j - 1];
                } else {
                    if (i != 0 && s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 2]);
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[slength][plength];
    }

    private boolean check(String s, String p, int i, int j) {
        if (i < 0) return false;
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }

    public static void main(String[] args) {
        System.out.println(new T10().isMatch("aa", "ab"));
    }
}
