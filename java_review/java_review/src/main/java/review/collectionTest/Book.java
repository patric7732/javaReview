package review.collectionTest;

public class Book {
    private String title;
    private Author author;

    public Book(String title) {
        this.title = title;
        this.author = new Author();
    }

    public void setAuthorName(String name) {
        author.setName(name);
    }

    public String getAuthorName() {
        return author.getName();
    }

    public void printBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + getAuthorName());
    }

    // Member inner class 'Author'
    public class Author {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Book book = new Book("어떻게 사람 이름이");
        book.author.setName("엄..");

        book.printBookDetails();
    }
}
