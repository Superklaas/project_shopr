package be.vdab.domain.item;

public abstract class Book extends Item {

    private String author;
    private int isbn;
    private int pages;

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getIsbn() {
        return isbn;
    }

    public Book setIsbn(int isbn) {
        this.isbn = isbn;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

}
