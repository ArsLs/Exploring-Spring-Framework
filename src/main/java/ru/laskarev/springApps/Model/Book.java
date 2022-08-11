package ru.laskarev.springApps.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Title can't be empty")
    @Size(max = 128, message = "Maximum length = 128")
    private String title;

    @NotEmpty(message = "Author can't be empty")
    @Size(max = 128, message = "Maximum length = 128")
    private String author;

//    @NotEmpty(message = "Please write down the year when this exactly edition was published")
    @Min(value = 0, message = "Please write down the year when this exactly edition was published")
    private int yearOfPublished;

//    @NotEmpty(message = "If the exactly year is unknown, write down the approximate")
    @Min(value = -10000, message = "Minimum year is -10000 (10000 B.C.)")
    private int yearOfWritten;

    public Book() {

    }

    public Book(int id, String title, String author, int yearOfPublished, int yearOfWritten) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublished = yearOfPublished;
        this.yearOfWritten = yearOfWritten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublished() {
        return yearOfPublished;
    }

    public void setYearOfPublished(int yearOfPublished) {
        this.yearOfPublished = yearOfPublished;
    }

    public int getYearOfWritten() {
        return yearOfWritten;
    }

    public void setYearOfWritten(int yearOfWritten) {
        this.yearOfWritten = yearOfWritten;
    }
}
