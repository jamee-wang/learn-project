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
        if (binary == null) {
            throw new NullPointerException("binary can not be null");
        }
        int i = 0;
        int length = binary.length();
        for (int j = 0; j < length; ++j) {
            char ch = binary.charAt(j);
            if (ch != '0' && ch != '1') {
                throw new IllegalArgumentException(binary + " is not binary string");
            }
            i += (ch - '0') * (1 << (length - j - 1));
        }
        return i;
    }

    public static String toHexString(int i) {
        final char[] HEX = new char[]{
                '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'
        };
        StringBuilder hexString = new StringBuilder(8);
        for (int j = 28; j >= 0; j -= 4) {
            hexString.append(HEX[(i >> j) & 0XF]);
        }
        return hexString.toString();
    }

    public static int hexToInteger(String hex) {
        if (hex == null) {
            throw new NullPointerException("hex can not be null");
        }
        int startIndex = 0;
        if (hex.charAt(0) == '0' && (hex.charAt(1) == 'x' || hex.charAt(1) == 'X')) {
            startIndex = 2;
        }
        int i = 0;
        int length = hex.length();
        for (int j = startIndex; j < length; ++j) {
            int v;
            char ch = hex.charAt(j);
            if (ch <= '9') {
                v = hex.charAt(j) - '0';
            } else if (ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f') {
                v = 10 + ch - 'a';
            } else if (ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F') {
                v = 10 + ch - 'A';
            } else {
                throw new IllegalArgumentException(hex + " is not hex string");
            }
            i += v * (1 << 4 * (length - j - 1));
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

        System.out.println("1 = " + toHexString(1));
        System.out.println("2 = " + toHexString(2));
        System.out.println("8 = " + toHexString(8));
        System.out.println("13 = " + toHexString(13));
        System.out.println("16 = " + toHexString(16));
        System.out.println("0X18 = " + toHexString(0X18));
        System.out.println("0X12 = " + toHexString(0X12));
        System.out.println("max = " + toHexString(Integer.MAX_VALUE));

        System.out.println("0x16 = " + hexToInteger("16"));
        System.out.println("0x7FFFFFFF = " + hexToInteger("7FFFFFFF"));
        System.out.println("0x2ac9 = " + hexToInteger("0x2ac9"));
        System.out.println("0X62A = " + hexToInteger("0X62A"));
        System.out.println("0X62A = " + Integer.parseInt("62A", 16));
        // System.out.println("0X62G = " + hexToInteger("0X62G"));
    }
}
