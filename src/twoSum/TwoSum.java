package twoSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSum {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Input numbers array, (ex: 1, 2, 3, 4): ");
      String numbers = scanner.nextLine();

      System.out.print("Input the target sum: ");
      int targetSum = scanner.nextInt();

      String[] numbersSplited = numbers.split(", ");
      int[] nums = new int[numbersSplited.length];

      for (int i = 0; i < numbersSplited.length; i++) {
        nums[i] = Integer.parseInt(numbersSplited[i]);
      }

      List<List<Integer>> result = twoSums(nums, targetSum);
      String resultString = resultToString(result, targetSum);

      System.out.printf("Result: %s%n", resultString);
    } catch (NumberFormatException e) {
        System.out.println("Malformed input");
    }
  }

  public static List<List<Integer>> twoSums(final int[] nums, final int targetSum) {
    int start = 0;
    int end = nums.length - 1;

    List<List<Integer>> result = new ArrayList<>();

    while (start < end) {
      int sum = nums[start] + nums[end];

      if (sum < targetSum) {
        start++;
        continue;
      }

      if (sum > targetSum) {
        end--;
        continue;
      }

      result.add(List.of(nums[start], nums[end]));
      start++;
      end--;
    }

    return result;
  }

  public static String resultToString(List<List<Integer>> result, final int targetSum) {
    StringBuilder stringBuilder = new StringBuilder();

    for (List<Integer> pair : result) {
      stringBuilder.append(
          String.format("%d + %d = %d; ", pair.getFirst(), pair.getLast(), targetSum));
    }

    return stringBuilder.toString();
  }
}
