package pers.lls.java;

import java.util.concurrent.atomic.AtomicInteger;

public class HashDemo {
    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    /**
     * The difference between successively generated hash codes - turns
     * implicit sequential thread-local IDs into near-optimally spread
     * multiplicative hash values for power-of-two-sized tables.
     */
    private static final int HASH_INCREMENT = 0x61c88647;

    /**
     * Returns the next hash code.
     */
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        System.out.println(nextHashCode);
        nextHashCode();
        System.out.println(nextHashCode);
        nextHashCode();
        System.out.println(nextHashCode);
        nextHashCode();
        System.out.println(nextHashCode);
    }
}
