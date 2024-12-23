package pers.lls.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        System.gc();
    }
}