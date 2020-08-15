package org.jamee.learn.algorithm.dynamicprogramming;


/**
 * 问题：楼梯一共有 n 级，可以一次走一级，或者一次走两级，那么 n 级楼梯有多少种走法？
 *
 * 1 级：[1]
 * 2 级：[1,1],[2]
 * 3 级：[1,1,1],[2,1],[1,2]
 *
 * 假设 n 级楼梯走了 n -1 次，还有一次，则可以是 [f(n-1), 1]，或者 [f(n -2), 2]
 * f(n) = f(n - 1) + f(n - 2)
 */
public class StairsProblem {
    public static int getWayR(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getWayR(n - 1) + getWayR(n - 2);
    }

    public static int getWayF(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prePre = 1;
        int pre = 2;
        int way = 0;
        for (int i = 3; i <= n; i++) {
            way = pre + prePre;
            prePre = pre;
            pre = way;
        }
        return way;
    }

    public static void main(String[] args) {
        System.out.println("3 step, way: " + getWayR(3));
        System.out.println("19 step, way: " + getWayR(19));
        System.out.println("3 step, way: " + getWayF(3));
        System.out.println("19 step, way: " + getWayF(19));
    }
}
