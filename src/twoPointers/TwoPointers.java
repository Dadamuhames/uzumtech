package twoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class TwoPointers {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Input numbers array, (ex: 1, 2, 3, 4): ");
      String numbers = scanner.nextLine();

      String[] numbersSplited = numbers.split(", ");
      int[] nums = new int[numbersSplited.length];

      for (int i = 0; i < numbersSplited.length; i++) {
        nums[i] = Integer.parseInt(numbersSplited[i]);
      }

      twoPointers(nums);

      printArrayIgnoringZeros(nums);
    }
  }

  public static void twoPointers(final int[] nums) {
    int freeLeft = 0;

    int pointerOne = 0;
    int pointerTwo = 1;

    while (pointerOne < nums.length && pointerTwo < nums.length) {
      if (nums[pointerOne] == nums[pointerTwo]) {
        nums[pointerTwo] = 0;

        if (freeLeft == 0 || freeLeft > pointerTwo) {
          freeLeft = pointerTwo;
        }
        pointerTwo++;
        continue;
      }

      if (freeLeft != 0) {
        nums[freeLeft] = nums[pointerTwo];
        nums[pointerTwo] = 0;
        pointerOne = freeLeft;
        freeLeft++;
      }

      pointerTwo++;
    }
  }

  public static void printArrayIgnoringZeros(final int[] nums) {
    System.out.print("[");
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];

      if (n == 0 && i != 0) break;

      System.out.print(n);

      if (i != nums.length - 1 && nums[i + 1] != 0) {
        System.out.print(", ");
      }
    }

    System.out.println("]");
  }
}
