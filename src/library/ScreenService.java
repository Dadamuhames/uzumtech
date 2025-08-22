package library;

import java.util.List;
import java.util.Scanner;

public class ScreenService {
  private final Library library;
  private final Scanner scanner;

  public ScreenService(final Library library, final Scanner scanner) {
    this.library = library;
    this.scanner = scanner;
  }

  public void awaitKeyboardInput() {

    String key = scanner.next();

    switch (key) {
      case "L" -> library.setState(AppState.LIST);

      case "I" -> library.setState(AppState.ONE);

      case "A" -> library.setState(AppState.CREATE);

      case "D" -> library.setState(AppState.DELETE);

      case "Q" -> library.setState(AppState.QUIT);

      default -> {
        Utils.clearTerminal();

        System.out.println("Invalid input");

        System.out.print(Keyboard.getMainKeyboard());

        awaitKeyboardInput();
      }
    }
    scanner.nextLine();
  }

  public void mainScreen() {
    Utils.clearTerminal();

    String stringBuilder = "Welcome to the library\n\n" + Keyboard.getMainKeyboard();

    System.out.print(stringBuilder);

    awaitKeyboardInput();
  }

  public void createBookScreen() {
    Utils.clearTerminal();

    library.setState(AppState.IDLE);

    System.out.println("Create a book\n");

    // enter name
    System.out.print("Enter the books name: ");
    String bookName = scanner.nextLine();

    // enter author
    System.out.print("Enter the books author: ");
    String author = scanner.nextLine();

    // enter year
    System.out.print("Enter publishing year: ");
    int year = scanner.nextInt();

    Book book = new Book(library.getLastBookId(), bookName, author, year);
    library.addBook(book);

    System.out.println("Book created!\n\n");

    System.out.print(Keyboard.getMainKeyboard());

    awaitKeyboardInput();
  }

  public void list() {
    Utils.clearTerminal();

    List<Book> books = library.getBooks();

    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("Books list\n\n");

    stringBuilder.append("------------------\n");

    if (!books.isEmpty()) {
      for (Book book : books) {
        stringBuilder.append(book.toString());
      }
    } else {
      stringBuilder.append("| No books found |\n");
    }

    stringBuilder.append("------------------\n\n\n");

    stringBuilder.append(Keyboard.getMainKeyboard());

    System.out.print(stringBuilder);

    library.setState(AppState.IDLE);

    awaitKeyboardInput();
  }

  public void one() {
    Utils.clearTerminal();

    System.out.print("Enter the book id: ");
    Long id = scanner.nextLong();

    System.out.println("------------------------");

    try {
      Book book = library.getBook(id);

      System.out.println(book.toString());

    } catch (BookNotFoundException e) {
      System.out.println("| 404 - Book not found |");
    }

    System.out.println("------------------------\n\n");

    System.out.print(Keyboard.getMainKeyboard());

    library.setState(AppState.IDLE);

    awaitKeyboardInput();
  }

  public void delete() {
    Utils.clearTerminal();

    System.out.print("Enter the book id: ");
    Long id = scanner.nextLong();
    library.deleteBook(id);

    System.out.println("------------------------");

    System.out.println("Book deleted!");

    System.out.println("------------------------\n\n");

    System.out.print(Keyboard.getMainKeyboard());

    library.setState(AppState.IDLE);

    awaitKeyboardInput();
  }
}
