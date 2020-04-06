package pers.lls.arithmetic.sword;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class T2 {
    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        int n = 0;

        for (int i=0;i<length;i++){
            if (str.charAt(i) == ' '){
                n++;
            }
        }

        int finallenth = length + 2*n;
        int newstrcursorl = length-1;
        int newstrcursorr = finallenth-1;
        str.setLength(finallenth);
        for (int i=0;i<length;i++){
            if(str.charAt(newstrcursorl)!=' '){
                str.setCharAt(newstrcursorr--,str.charAt(newstrcursorl));
            }else {
                str.setCharAt(newstrcursorr--,'0');
                str.setCharAt(newstrcursorr--,'2');
                str.setCharAt(newstrcursorr--,'%');
            }
            newstrcursorl--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T2().replaceSpace(new StringBuffer("a b")));
    }
}
