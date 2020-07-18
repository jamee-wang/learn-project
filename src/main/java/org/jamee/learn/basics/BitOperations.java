package org.jamee.learn.basics;

public class BitOperations {
    public static String toBinaryString(int i) {
        StringBuilder binary = new StringBuilder(32);
        for (int k = 31; k >= 0; --k) {
            binary.append((i >> k) & 1);
        }
        return binary.toString();
    }

    public static int toInteger(String binary) {
        int i = 0;
        int length = binary.length();
        for (int j = 0; j < length; ++j) {
            i += (binary.charAt(j) - '0') * (1 << (length - j - 1));
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("101 & 110 = " + (5 & 6));
        System.out.println("101 | 110 = " + (5 | 6));
        System.out.println("101 ^ 110 = " + (5 ^ 6));
        System.out.println("sMAX = " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("mMAX = " + toBinaryString(Integer.MAX_VALUE));
        System.out.println("s5 = " + Integer.toBinaryString(5));
        System.out.println("m5 = " + toBinaryString(5));
        System.out.println("s8 = " + Integer.toBinaryString(8));
        System.out.println("m8 = " + toBinaryString(8));
        System.out.println("s1024 = " + Integer.toBinaryString(1024));
        System.out.println("m1024 = " + toBinaryString(1024));
        System.out.println("s6358 = " + Integer.toBinaryString(6358));
        System.out.println("m6358 = " + toBinaryString(6358));
        System.out.println("s0 = " + Integer.toBinaryString(0));
        System.out.println("m0 = " + toBinaryString(0));
        System.out.println("s-0 = " + Integer.toBinaryString(-0));
        System.out.println("m-0 = " + toBinaryString(-0));
        System.out.println("s-6 = " + Integer.toBinaryString(-6));
        System.out.println("m-6 = " + toBinaryString(-6));
        System.out.println("s-143 = " + Integer.toBinaryString(-143));
        System.out.println("m-143 = " + toBinaryString(-143));
        System.out.println("s-4096 = " + Integer.toBinaryString(-4096));
        System.out.println("m-4096 = " + toBinaryString(-4096));
        System.out.println("sMIN = " + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("mMIN = " + toBinaryString(Integer.MIN_VALUE));

        System.out.println("0 = " + toInteger("0"));
        System.out.println("1 = " + toInteger("1"));
        System.out.println("10 = " + toInteger("10"));
        System.out.println("101 = " + toInteger("101"));
        System.out.println("110 = " + toInteger("110"));
        System.out.println("1000 = " + toInteger("1000"));
        System.out.println("10000000000 = " + toInteger("10000000000"));
        System.out.println("1100011010110 = " + toInteger("1100011010110"));
        System.out.println("11111111111111111111111111111010 = " + toInteger("11111111111111111111111111111010"));
        System.out.println("11111111111111111111111101110001 = " + toInteger("11111111111111111111111101110001"));
        System.out.println("11111111111111111111000000000000 = " + toInteger("11111111111111111111000000000000"));
        System.out.println("10000000000000000000000000000000 = " + toInteger("10000000000000000000000000000000"));
    }
}
