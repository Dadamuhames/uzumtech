package wordCounter;

import java.util.*;

public class WordCounter {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Input string: ");
      String str = scanner.nextLine();
      System.out.print("Input frequency: ");
      int n = scanner.nextInt();

      String result = wordCounter(str, n);
      System.out.printf("Result: %s%n", result);
    }
  }

  public static String wordCounter(final String str, final int n) {
    if (str == null || str.isEmpty()) return "";

    Map<String, Integer> wordCountMap = new HashMap<>();

    String[] words = str.toLowerCase().split(" ");

    for (String word : words) {
      int count = wordCountMap.getOrDefault(word, 0) + 1;

      wordCountMap.put(word, count);
    }

    List<String> result = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
      if (entry.getValue().equals(n)) {
        result.add(entry.getKey());
      }
    }

    return String.join(", ", result);
  }
}
