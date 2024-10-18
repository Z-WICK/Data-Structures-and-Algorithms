package Exercises.字符串相似性判断;

import java.util.Scanner;

/**
 * @Author : wick
 * @Date : 2024/10/17 14:54
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < n; i++) {
            String x = sc.nextLine();
            String y = sc.nextLine();
            System.out.println(areSimilar(x, y) ? "Yes" : "No");
        }
        sc.close();
    }

    // 判断两个字符串是否相似
private static boolean areSimilar(String x, String y) {
        // 如果两个字符串长度不相等，则返回false
        if (x.length() != y.length()) return false;
        // 如果两个字符串相等，则返回true
        if (x.equals(y)) return true;

        // 定义一个计数器，用于记录两个字符串中不同字符的个数
        int diffCount = 0;
        // 定义一个数组，用于记录两个字符串中不同字符的索引
        int[] diffIndex = new int[2];
        // 遍历两个字符串，比较每个字符
        for (int i = 0; i < x.length(); i++) {
            // 如果两个字符串中对应位置的字符不相等
            if (x.charAt(i) != y.charAt(i)) {
                // 如果不同字符的个数已经达到2个，则返回false
                if (diffCount == 2) {
                    return false;
                }
                // 记录不同字符的索引
                diffIndex[diffCount++] = i;
            }
        }
        // 如果不同字符的个数等于2，并且两个字符串中对应位置的字符相等，则返回true
        return diffCount == 2 &&
               x.charAt(diffIndex[0]) == y.charAt(diffIndex[1]) &&
               x.charAt(diffIndex[1]) == y.charAt(diffIndex[0]);
    }
}
