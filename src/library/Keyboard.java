package library;

public class Keyboard {
  public static String getMainKeyboard() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("[L] - Books list | ");
    stringBuilder.append("[I] - View the book | ");
    stringBuilder.append("[A] - Add book | ");
    stringBuilder.append("[D] - Delete book | ");
    stringBuilder.append("[Q] - Quit | : ");

    return stringBuilder.toString();
  }
}
