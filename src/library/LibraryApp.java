package library;

import java.util.Scanner;

public class LibraryApp {
  public static void main(String[] args) {
    Library library = new Library();

    try (Scanner scanner = new Scanner(System.in)) {
      ScreenService screenService = new ScreenService(library, scanner);

      screenService.mainScreen();

      while (library.isRunning()) {
        AppState state = library.getState();

        switch (state) {
          case CREATE -> screenService.createBookScreen();

          case LIST -> screenService.list();

          case ONE -> screenService.one();

          case DELETE -> screenService.delete();

          case QUIT -> {
            Utils.clearTerminal();

            System.exit(0);
          }
        }
      }
    }
  }
}
