package org.jamee.learn.algorithm.dynamicprogramming;

import java.util.Arrays;

import static java.lang.Math.min;

/**
 * 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 * 再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 *
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 *
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AF%A6%E8%A7%A3%E8%BF%9B%E9%98%B6.md
 */
public class CoinChange {
    public static int getMinCoinCount(int[] values, int amount) {
        if (amount < 0) return -1;
        // dp[x]: 总金额为 x 时，最少的硬币数，由于要获取参数：amount 的最少硬币数，因此初始化长度为 amount + 1
        int[] dp = new int[amount + 1];
        // 初始化数组元素值为：amount + 1，因为最多硬币数为 amount，即全部都用面值为1的凑，
        // 但可能没有面值为 1 的，则凑不出，因此用 amount + 1 初始化，表示无解
        Arrays.fill(dp, amount + 1);
        // amount = 0 时，需要最少 0
        dp[0] = 0;
        // 计算总金额从 0 ~ amount 的最少硬币数
        for (int i = 0; i < amount + 1; ++i) {
            // 穷举所有面值
            for (int v : values) {
                // 无解跳过
                if (i - v < 0) continue;
                // 总金额为：i 时，最少硬币数为 i - 当前面值剩余金额的最少硬币数 + 1（当前这个硬币个数）
                dp[i] = min(dp[i], 1 + dp[i - v]);
            }
        }
        // 无解？返回 -1，否则返回解
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static int[] getCoins(int[] values, int amount) {
        // 无解返回空数组
        if (amount < 0) return new int[]{};
        int[][] coins = new int[amount + 1][];
        // dp[x]: 总金额为 x 时，最少的硬币数，由于要获取参数：amount 的最少硬币数，因此初始化长度为 amount + 1
        int[] dp = new int[amount + 1];
        // 初始化数组元素值为：amount + 1，因为最多硬币数为 amount，即全部都用面值为1的凑，
        // 但可能没有面值为 1 的，则凑不出，因此用 amount + 1 初始化，表示无解
        Arrays.fill(dp, amount + 1);
        // amount = 0 时，需要最少 0
        dp[0] = 0;
        // 计算总金额从 0 ~ amount 的最少硬币数
        for (int i = 0; i < amount + 1; ++i) {
            // 穷举所有面值
            for (int v : values) {
                // 无解跳过
                if (i - v < 0) {
                    continue;
                }
                // 总金额为：i 时，最少硬币数为 i - 当前面值剩余金额的最少硬币数 + 1（当前这个硬币个数）
                dp[i] = min(dp[i], 1 + dp[i - v]);
                // 无解跳过
                if (amount + 1 == dp[i]) {
                    continue;
                }
                // 如果有更小的硬币数再拷贝
                if (null != coins[i] && dp[i] >= coins[i].length) {
                    continue;
                }
                coins[i] = new int[dp[i]];
                if (null != coins[i -v]) {
                    System.arraycopy(coins[i - v], 0, coins[i], 0, coins[i - v].length);
                }
                coins[i][dp[i] - 1] = v;
            }
        }
        return coins[amount];
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 2, 5};
        System.out.println("Min coin count: " + CoinChange.getMinCoinCount(values, 19));
        System.out.println("Min coins: " + Arrays.toString(CoinChange.getCoins(values, 19)));
    }
}
