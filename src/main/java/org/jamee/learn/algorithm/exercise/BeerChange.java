package org.jamee.learn.algorithm.exercise;

/**
 * 小区便利店正在促销，用 y 个空酒瓶可以兑换一瓶新酒。你购入了 x 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算最多能喝到多少瓶酒。
 *
 * 输入：x = 9, y = 3
 *
 * 输出：13
 *
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 *
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 *
 */
public class BeerChange {
    public static int drinkBeerA(int x, int y) {
        return (x * y - 1) / (y - 1);
    }

    public static int drinkBeer(int x, int y) {
        int sum = x;
        while(x >= y) {
            int change = x / y;
            sum += change;
            x = change + x % y;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("x = 9, y = 3, button of beer: " + drinkBeer(9, 3));
        System.out.println("x = 10, y = 3, button of beer: " + drinkBeer(10, 3));
        System.out.println("x = 15, y = 4, button of beer: " + drinkBeer(15, 4));
        System.out.println("x = 5, y = 5, button of beer: " + drinkBeer(5, 5));
        System.out.println("x = 2, y = 3, button of beer: " + drinkBeer(2, 3));

        System.out.println("x = 9, y = 3, button of beer: " + drinkBeerA(9, 3));
        System.out.println("x = 10, y = 3, button of beer: " + drinkBeerA(10, 3));
        System.out.println("x = 15, y = 4, button of beer: " + drinkBeerA(15, 4));
        System.out.println("x = 5, y = 5, button of beer: " + drinkBeerA(5, 5));
        System.out.println("x = 2, y = 3, button of beer: " + drinkBeerA(2, 3));
    }
}
