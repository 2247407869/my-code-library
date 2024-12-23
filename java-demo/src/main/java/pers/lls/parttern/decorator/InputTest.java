package pers.lls.parttern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: parttern-practice
 * @description: TODO
 * @author: LLS
 * @create: 2019-07-14 16:30
 **/
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in =
                    new LowerCaseInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("test.txt")));
            while ((c = in.read()) >=0){
                System.out.println((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
