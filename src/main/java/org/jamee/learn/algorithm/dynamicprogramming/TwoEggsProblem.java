package org.jamee.learn.algorithm.dynamicprogramming;

/**
 * You are given two eggs to test the minimal height (from 1 to 100)
 * the egg will break if dropped at that height.
 * If the egg does not break, it can be reused to test another height.
 * So what is your strategy to minimize the number of tests at worst cases?
 * Two eggs are exactly identical.
 *
 * https://helloacm.com/googles-two-eggs-problem/
 * 问题转为：
 * 第一次从x楼尝试，如果碎了，则还要尝试 x - 1 次，一共尝试 1 + x - 1 = x 次；
 * 如果没碎，则继续算 n - x 层楼尝试的次数
 * 最差情况则是这些尝试的最大值
 * 最少的尝试次数则是所有尝试方式的最小值
 * f(n) = min(1...n, max(x, 1 + f(n - x)))
 */
public class TwoEggsProblem {
    private final int[] cache;
    private final int n;

    public TwoEggsProblem(int n) {
        cache = new int[n + 1];
        this.n = n;
    }

    public int getStairs() {
        return getStairs(n);
    }

    private int getStairs(int n) {
        if (1 == n) {
            return 1;
        }
        // 如果已经缓存结果
        if (cache[n] > 0) {
            return cache[n];
        }
        int m = n + 1;
        for (int i = n - 1; i >= 2; i--) {
            m = Math.min(m, 1 + Math.max(i - 1, getStairs(n - i)));
        }
        // 缓存已经计算结果
        cache[n] = m;
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new TwoEggsProblem(100).getStairs());
    }
}
