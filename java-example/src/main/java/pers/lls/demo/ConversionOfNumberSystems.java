package pers.lls.demo;

public class ConversionOfNumberSystems {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     *
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber(String number) {

        int i;
        try {
            i = Integer.parseInt(number);
        } catch (Exception e) {
            return "INPUTERROR";
        }
        if (i > 32767 || i < -32767) return "NODATA";
        if (i == 0) return "0000000000000000,0000";
        if (i < 0) {
            i = 65536 + i;
        }
        int i2 = i;
        StringBuilder sb1 = new StringBuilder();
        while (true) {
            if (i == 0) {
                break;
            } else {
                sb1.append(i % 2);
                i /= 2;
            }

        }

        int length = sb1.length();
        for (int j = 0; j < 16 - length; j++) {
            sb1.append(0);
        }
        String s = sb1.reverse().toString();

        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (i2 == 0) {
                break;
            } else if (i2 % 16 == 10) {
                sb2.append("A");
            } else if (i2 % 16 == 11) {
                sb2.append("B");
            } else if (i2 % 16 == 12) {
                sb2.append("C");
            } else if (i2 % 16 == 13) {
                sb2.append("D");
            } else if (i2 % 16 == 14) {
                sb2.append("E");
            } else if (i2 % 16 == 15) {
                sb2.append("F");
            } else {
                sb2.append(i2 % 16);
            }
            i2 /= 16;
        }

        int length2 = sb2.length();
        for (int j = 0; j < 4 - length2; j++) {
            sb2.append(0);
        }
        String s2 = sb2.reverse().toString();
        return s + "," + s2;
    }

    public static void main(String[] args) {
        System.out.println(new ConversionOfNumberSystems().changeFormatNumber("15"));
    }
}