package library;

public record Book(Long id, String name, String author, Integer year) {
  @Override
  public String toString() {
    return String.format("Id: %d\nName: %s\nAuthor: %s\nYear: %s\n", id, name, author, year);
  }
}
