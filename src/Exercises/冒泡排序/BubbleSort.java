/**
 * @Author : wick
 * @Date : 2024/10/17 15:17
 */
package Exercises.冒泡排序;

import java.util.Scanner;

/**
 * @Author : wick
 * @Date : 2024/10/17 15:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strs = line.split(" ");

        int[] nums = new int[strs.length];
        for(int i=0; i<strs.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        bubbleSort(nums);
        for(int num : nums){
            System.out.println(num+ " ");
        }
    }

    private static void bubbleSort(int[] nums){
        int n = nums.length;
        for (int i=0; i<n; i++){
            for(int j=0; j<n-1-i; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }


}
