package org.jamee.learn.algorithm.dynamicprogramming;

public class Fibonacci {
    // 递归求解：自顶向下
    public static int get(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return get(n - 1) + get(n - 2);
    }

    // 非递归：自底向上
    public static int forGet(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1, prePre = 1, curr = 2;
        for (int i = 3; i <= n; ++i) {
            curr = pre + prePre;
            prePre = pre;
            pre = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println("fib(10)=" + Fibonacci.get(10));
        System.out.println("fib(10)=" + Fibonacci.forGet(10));
    }
}
