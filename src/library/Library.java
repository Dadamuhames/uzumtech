package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
  private AppState state;
  private boolean isRunning;
  private List<Book> books;
  private Long lastBookId;

  public Library() {
    this.state = AppState.IDLE;
    this.isRunning = true;
    this.books = new ArrayList<>();
    this.lastBookId = 1L;
  }

  public AppState getState() {
    return this.state;
  }

  public void setState(final AppState state) {
    this.state = state;
  }

  public void shutDown() {
    this.isRunning = false;
  }

  public boolean isRunning() {
    return this.isRunning;
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public Book getBook(final Long id) {
    return this.books.stream()
        .filter(b -> b.id().equals(id))
        .findAny()
        .orElseThrow(BookNotFoundException::new);
  }

  public void deleteBook(final Long id) {
    books.removeIf(b -> b.id().equals(id));
  }

  public void addBook(final Book book) {
    this.books.add(book);
    lastBookId++;
  }

  public Long getLastBookId() {
      return this.lastBookId;
  }
}
